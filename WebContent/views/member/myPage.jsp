<%@page import="java.util.ArrayList" %>
<%@page import="kr.or.artsuwon.member.model.vo.Member" %>
<%@page import="kr.or.artsuwon.member.model.vo.Reservation" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!-- jQuery 라이브러리 -->
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
        crossorigin="anonymous"></script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My Page</title>

    <%--부트스트랩 링크 --%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
            integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
            integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
            crossorigin="anonymous"></script>

    <style>
        .wrapper {
            display: block;
            box-sizing: border-box;
            width: 70%;
            margin: 20px auto;
            position: relative;
            text-align: center;
        }
        .wrapper > * {
            overflow: hidden;
            display: block;
        }

        .reservation {
            box-sizing: border-box;
            width: 100%;
            text-align: left;
            overflow: hidden;
        }
        .noR{
            width: 100%;
            height: 100px;
            background-color: #F6F6F6;
            padding: 20px;
        }

        .change {
            box-sizing: border-box;
            width: 100%;
        }

        .wrapper > .change > .basic_info {
            box-sizing: border-box;
            width: 100%;
        }

        .basic_info_table {
            border: 1px solid black;
            width: 400px;
            margin: 0 auto;
        }

        .wrapper > .change > .detail_info {
            box-sizing: border-box;
            width: 100%;
        }
        .address{
            width: 350px;
        }
        .withBtn{
            text-align: right;
        }
        


    </style>

</head>
<body>

<!-- Header -->
<%@ include file="/include/_header.jsp" %>


<%
    Member m = (Member) session.getAttribute("member");
    ArrayList<Reservation> list = (ArrayList<Reservation>) request.getAttribute("list");
%>


<div class="wrapper cf">
    <div class="reservation">
        <form>
            <% for (Reservation r : list) {%>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col" colspan="4"><h4>예매확인/취소</h4></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row"> 예약번호</th>
                    <td colspan="3"><%= r.getReservationNo() %>
                    </td>
                </tr>
                <tr>
                    <th scope="row"> 공연번호</th>
                    <td colspan="3"><%= r.getPerformanceNo() %>
                </tr>
                <tr>
                    <th scope="row"> 공연이름</th>
                    <td colspan="3"><%= r.getTitle() %>
                </tr>
                <tr>
                    <th scope="row"> 결제번호</th>
                    <td colspan="3"><%= r.getInvoiceNo() %>
                </tr>
                <tr>
                    <th scope="row"> 결제방법</th>
                    <td colspan="3"><%= r.getPayMethod() %>
                </tr>
                <tr>
                    <th scope="row"> 예약자 ID</th>
                    <td colspan="3"><%= r.getReservationId() %>
                </tr>
                <tr>
                    <th scope="row"> 예약일자</th>
                    <td colspan="3"><%=r.getReservationDate() %>
                </tr>
                <tr>
                    <th scope="row"> 결제금액</th>
                    <td colspan="3"><%=r.getReservationPrice() %>
                </tr>
                <tr>
                    <th scope="row"> 예약좌석</th>
                    <td colspan="3"><%=r.getSeatCode() %>
                </tr>
                </tbody>
            </table>
            <% }%>

            <%if (list.isEmpty()) {%>
            <div class="noR">
            <h4>현재 예약 정보가 없습니다.</h4>
            </div>
            <%} %>
        </form>
    </div><br><br><br>

    
    <form action="/member/memberUpdate.do" method="post">
        <div class="change">
            <div class="basic_info">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col" colspan="4"><h4>기본정보</h4></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row"> 이름</th>
                        <td colspan="3"><%=m.getMemberName() %>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row"> 생년월일</th>
                        <td colspan="3"><%=m.getBirthDate() %>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row"> 성별</th>
                        <td colspan="3">
                            <%if (m.getGender() == 'M') { %>
                            남자
                            <%} else { %>
                            여자
                            <%} %>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row"> 비밀번호 변경</th>
                        <td colspan="3">
                            <button id="pwdChangeBtn" class="btn btn-primary" style="background-color: #ED4C00;">
                                비밀번호변경
                            </button>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>

            <br><br><br>
            <div class="detail_info">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col" colspan="4"><h4>추가정보</h4></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row"> 주소</th>
                        <td colspan="3"><input type="address" name="address" id="sample5_address"
                                               onclick="sample5_execDaumPostcode()" class="address"/> <input type="button"
                                                                                                       onclick="sample5_execDaumPostcode()"
                                                                                                       class="btn btn-primary"
                                                                                                       style="background-color: #ED4C00;"
                                                                                                       value="주소 검색">
                        </td>
                    </tr>
                    <tr>
                        <th scope="row"> 상세주소</th>
                        <td colspan="3"><input type="text" name="detailAddress" class="address"/></td>
                    </tr>
                    <tr>
                        <th scope="row"> 휴대폰</th>
                        <td colspan="3"><select name="phone1">
                            <option>010</option>
                            <option>011</option>
                            <option>016</option>
                            <option>017</option>
                            <option>018</option>
                            <option>019</option>
                        </select> - <input type="text" name="phone2" maxlength="4" size="4"/> - <input type="text"
                                                                                                       name="phone3"
                                                                                                       maxlength="4"
                                                                                                       size="4"/></td>
                    </tr>
                    <tr>
                        <th scope="row"> 이메일</th>
                        <td colspan="3"><input type="text" name="email1"/> @ <input type="text" name="email2"/></td>
                    </tr>
                    <tr>
                        <th scope="row"> SMS 수신동의</th>
                        <td colspan="3"><input type="radio" name="smsYN" value="Y" checked/>동의합니다.
                            <input type="radio" name="smsYN" value="N"/>동의하지 않습니다.
                        </td>
                    </tr>
                    </tbody>
                </table>

                <button class="btn btn-primary" type="reset" style="background-color: #D8D8D8;  width: 90px; height: 50px">취소
                </button>
                <button class="btn btn-primary" type="submit" style="background-color: #ED4C00;  width: 90px; height: 50px">변경하기
                </button><br><br><br>

            </div>
        </div>

    </form>
    <div class="withBtn">
    <button class="btn btn-primary" type="submit" style="background-color: #363636;  width: 90px; height: 50px">회원탈퇴</button>
    </div>
</div>


<%--비밀번호 변경 --%>
<script>
    $('#pwdChangeBtn').click(function () {
        window.open("/views/member/memberPasswordChangeWindow.jsp", "_blank", "width=700px, height=600px");
    });
</script>


<%--주소 검색 API --%>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<script>

    function sample5_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function (data) {
                var addr = data.address; // 최종 주소 변수

                // 주소 정보를 해당 필드에 넣는다.
                document.getElementById("sample5_address").value = addr;

            }
        }).open();
    }
</script>


<%--변경 재확인 --%>
<script>
    $('#submitBtn').click(function () {

        var result = window.confirm("회원정보를 변경하시겠습니까?");

        if (result) {
            return true;
        } else {
            return false;
        }

    });
</script>


<%--회원 탈퇴 버튼 --%>
<script>
    $('#withDrawBtn').click(function () {


        // 1. 탈퇴를 진행하시겠습니까?
        // 2. 탈퇴를 하시게 되면, 데이터는 절대 복구 불가능합니다.

        if (window.confirm("탈퇴를 진행하시겠습니까?") && window.confirm("탈퇴 후 데이터 복구는 불가능합니다. 진행하시겠습니까?")) {
            location.replace("/member/memberWithDraw.do");
        } else {
            alert('탈퇴를 취소하였습니다.');

        }


    });

</script>


<%--취소 후 메인화면으로 이동 --%>
<script>
    $('#reset').click(function () {

        location.replace("/");
        return false;

    });
</script>


<!-- footer -->
<%@ include file="/include/_footer.jsp" %>


</body>
</html>