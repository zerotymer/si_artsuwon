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
            width: 80%;
            height: 500px;
            margin: 0 auto;

            background-color: skyblue;
            
        }

        .login {
            box-sizing: border-box;
            width: 100%;
            height: 100%;
            /*        float: left;*/
/*            padding: 10px 20px;*/
            display: flex;
            flex-direction: row;
        }
        .loginform {
            margin: 20px 0px;
            flex: 1 1 auto;
            width: 50%;
        }
        .form-floating {
            margin-top: 20px;
        }
        .form-control {
            line-height: 20px;
            height: 40px;
        }
        .loginform > div:last-child {
            margin-top: 100px;
        }
        #loginBtn {
            width: 100%;
            height: 50px;
        }
        .joinus {
            flex: 1 1 auto;
            box-sizing: border-box;
/*            width: 50%;*/
            height: 100%;
            /*        float: left;*/
            background-color: aqua;
        }
        #joinus_info {
/*            margin: 0% auto;*/
        }
        #kakao_login {

        }
        #naver_login {

        }
        #choice_icon {
            width: 80px;
            height: 80px;
            float: left;
            margin: 8%;
        }
        #choice_join {
            height: 35%;
            margin: 30% auto;
            background-color: #FFFFD2;
        }
    </style>

</head>
<body>
<%
    Member m = (Member) session.getAttribute("member");
%>

<!-- Header -->
<%@ include file="/include/_header.jsp" %>


<div id="wrapper">
    <div class="login">
        <div class="loginform">
            <div class="form-floating mb-3">
                아이디 <input type="email" class="form-control" id="floatingInput" placeholder="ID">
            </div>
            <div class="form-floating">
                비밀번호 <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
            </div>
            <div class="d-grid gap-2">
                <button class="btn btn-primary" id="loginBtn" type="button" style="background-color: #ED4C00;" type="submit">로그인</button>
            </div>
        </div>

        <div class="joinus">
            <div id="choice_join">
                <div id="choice_icon">
                    <img src="/assets/images/"/>
                </div>
                <br>
                <div id="joinus_info">
                    <h5><b>회원가입</b></h5>
                    <br>
                    아직 회원이 아닌가요?<br>
                    회원이 되시면 홈페이지에서 제공하는 온라인 서비스를 이용하실 수 있습니다.
                </div>
            </div>
        </div>
    </div>
</div>
<% if (m != null) { %>
<script>
    location.replce("/");
</script>
<%} else { %>
<form action="/member/login.do" method="post">
    <input type="text" name="memberId" placeholder="ID"/><br>
    <input type="password" name="memberPwd" placeholder="Password"/><br>
    <input type="submit" value="로그인"/>
    <br>
    <a href="/views/member/memberJoinus.jsp">회원가입</a>
</form>
<%} %>
<!-- footer -->
<%@ include file="/include/_footer.jsp" %>

</body>
</html>