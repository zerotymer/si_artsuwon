<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		boolean pwdResult = (boolean)request.getAttribute("pwdResult");
	%>

	<script>
		<%if(pwdResult){ %>
			alert('비밀번호 변경 성공');
			window.close(); //나 자신의 브라우저를 닫아라
		<%}else{%>
			alert('비밀번호 변경 실패. 비밀번호 재확인 바랍니다.');
			location.replace("/views/member/memberPasswordChangeWindow.jsp");
		<%}%>
	</script>
	
</body>
</html>