
<%@ page import="kr.or.artsuwon.member.model.vo.Member" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MEMBER MAIN PAGE</title>

<style>
    #wrapper{
        box-sizing: border-box;
        width: 80%;
        height: 500px;
        margin: 0 auto;
    }
    #login{
        box-sizing: border-box;
        border: 1px solid black;
        width: 50%;
        height: 100%;
        float: left;
    }
    #kakao_login{
        box-sizing: border-box;
        background-color: yellow;
        width: 80px;
        height: 80px;
        float: left;
    }
    #naver_login{
        box-sizing: border-box;
        background-color: green;
        width: 80px;
        height: 80px;
        float: left;
    }
    #choice{
        box-sizing: border-box;
        border: 1px solid black;
        width: 50%;
        height: 100%;
        float: left;
    }
    #choice_join{
        box-sizing: border-box;
        border: 1px solid black;
        width: 100%;
        height: 20%;
        float: left;
        margin: 100px 0px auto;
    }
    #choice_id{
        box-sizing: border-box;
        border: 1px solid black;
        width: 100%;
        height: 20%;
        float: left;
    }
    #choice_pwd{
        box-sizing: border-box;
        border: 1px solid black;
        width: 100%;
        height: 20%;
        float: left;
    }
    .choice_icon{
        border: 1px solid black;
        width: 10%;
        height: 50%;
        margin: 20px auto auto 20px;
        float: left;
    }
    
</style>

</head>
<body>
	
	<!-- Header -->
    <%@ include file="/views/common/header.html" %>
	
	<%
		Member m = (Member)session.getAttribute("member");
	%>
	
	<% if(m != null){ %> 
	
		[<%=m.getMemberName() %>]님 환영합니다. <a href="/member/logout.do">로그아웃</a><br>
		<a href="/member/memberMyPage.do">마이 페이지</a><br>
		
		
	<%}else{ %>
	
		<form action="/member/login.do" method="post">
			<input type="text" name="memberId" placeholder="ID"/><br>
			<input type="password" name="memberPwd" placeholder="Password"/><br>
			<input type="submit" value="로그인"/>
			<br>
			<a href="/views/member/memberJoinus.jsp">회원가입</a>
		</form>
	
	<%} %>
	
	<!-- footer -->
    <%@ include file="/views/common/footer.html" %>

</body>
</html>