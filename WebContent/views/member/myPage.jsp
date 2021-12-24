<%@page import="kr.or.artsuwon.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- jQuery 라이브러리 -->
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Page</title>

	<style>
		fieldset {
			width: 300px;
			height: 500px;
			margin: 0 auto;
		}
		legend {
			text-align: center;
		}
	</style>

</head>
<body>
	
	<%
		Member m = (Member)session.getAttribute("member");
	%>
	
	
	
	
	
	
	
	
</body>
</html>