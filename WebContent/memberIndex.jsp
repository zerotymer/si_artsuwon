<%@page import="kr.or.artsuwon.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MEMBER MAIN PAGE</title>
</head>
<body>
	
	<!-- Header -->
    <%@ include file="/views/common/header.html" %>
	
	<%
		Member m = (Member)session.getAttribute("member");
	%>
	
	<% if(m != null){ %> 
	
		[<%=m.getMemberName() %>]님 환영합니다. <a href="/member/logout.do">로그아웃</a><br>
		
		
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