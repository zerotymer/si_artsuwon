<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수정 확인</title>
</head>
<body>
	
	<%
		boolean updateResult = (boolean)request.getAttribute("updateResult");
	%>
	
	<script>
		
		<%if(updateResult) {%>
		
			alert('정상처리 되었습니다.');
			location.replace('/member/memberMyPage.do');
			
		<%}else{%>
		
			alert('정보 변경이 실패하였습니다.');
			location.replace('/member/memberMyPage.do');
			
		<%}%>
	
		
	</script>
	
</body>
</html>