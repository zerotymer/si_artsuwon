<%@ page import="kr.or.artsuwon.member.model.vo.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>MEMBER MAIN PAGE</title>
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

    <%--위 쪽 메뉴바 --%>
    <link rel="stylesheet" href="/assets/style/contentframe.css">
    <style>
        #wrapper {
            box-sizing: border-box;
            width: 70%;
            height: 500px;
            margin: 0 auto;
        }

        .login {
            box-sizing: border-box;
            /* width: 50%; */
            /* height: 100%; */
            /*        float: left;*/
            display: flex;
            flex-direction: row;    /* 자식 요소 수평으로 배치 */
        }
        .loginform {
            flex: 1 0 50%;          /* 자동늘리기1, 자동줄이기0, 기본크기 50% */
            padding: 30px 15px;
        }
        .form-floating {
            margin-top: 20px;
            font-size: 1.2em;
        }
        .form-floating>input{
            font-size: 1.2em;
        }
        .orangeBtn {
            margin-top: 100px;
        }
        #loginBtn {
            width: 100%;
            height: 60px;
            font-size: 1.2em;
        }
        .joinus {
            flex: 1 0 50%;          /* 자동늘리기1, 자동줄이기0, 기본크기 50% */
            box-sizing: border-box;
            height: 100%;
            padding: 0px 15px;
        }
        #joinus_info {
            margin: 0% auto;
        }
        #kakao_login {

        }
        #naver_login {

        }
        #choice_icon > img{
            width: 100px;
            height: 100px;
            float: left;
            margin: 8%;
        }
        #choice_join {
            height: 200px;
            margin: 25% auto;
            /*background-color: #FFFFD2;*/
        }
    </style>

</head>
<body>
<%
    Member m = (Member) session.getAttribute("member");
    // 로그인 실패시 fail - false, 로그인 안하고 넘어오는경우 null - true
    boolean notLogin = request.getAttribute("result") == null; 
%>

<!-- Header -->
<%@ include file="/include/_header.jsp" %>


<div id="wrapper">
    <div class="login">
       <form action="/member/login.do" method="post"  class="loginform">
        <div>
            <div class="form-floating mb-3">
                아이디 <input type="text" name="memberId" class="form-control" id="floatingInput" placeholder="ID">
            </div>
            <div class="form-floating">
                비밀번호 <input type="password" name="memberPwd" class="form-control" id="floatingPassword" placeholder="Password">
            </div>
            <div class="d-grid gap-2 orangeBtn">
                <button class="btn btn-primary" id="loginBtn" type="submit" style="background-color: #ED4C00;" >로그인</button>
            </div>
        </div>
        </form>
        <div class="joinus">
            <div id="choice_join">
               <div style = "cursor: pointer;" onclick="location.href='/views/member/memberJoinus.jsp';">
                <div id="choice_icon">
                    <img src="/assets/images/pngwing.com.png"/>
                </div>
                <br>
                <div id="joinus_info"> 
                    <h5><b>회원가입</b></h5>
                    <br>
                    아직 회원이 아닌가요?<br>
                    회원이 되시면 홈페이지에서 제공하는 온라인 서비스를 이용하실 수 있습니다.<br>
                </div>
            </div>
            </div>
        </div>
    </div>
</div>



<% if (m != null) { %>

<script>
    location.replce("/");
</script>

<%}%>

<script>
    var notLogin = <%= notLogin %>;
    if (!notLogin) {
        alert("로그인에 실패하였습니다. 다시 시도해주세요.");
    }
</script>

<!-- footer -->
<%@ include file="/include/_footer.jsp" %>

</body>
</html>