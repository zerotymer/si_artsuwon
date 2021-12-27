<%@page import="kr.or.artsuwon.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<style>
		#passwordForm{
			border : 1px solid grey;
			width : 300px;
			height : 200px;
			margin: 200px auto;
		}
		*{
			box-sizing: border-box;
		
		}
	</style>
</head>
<body>

	<%
		Member m = (Member)session.getAttribute("member");
	%>

	<div id="passwordForm">
		<form action="/member/memberWithDraw.do" method="post">
			<fieldset>
				<legend style="text-align: center;">비밀번호 확인</legend>
				<input type="hidden" name="memberId" value="<%=m.getMemberId() %>"/>
				<input type="password" class="b-block w-100"  name="userPwd" placeholder="PW를 입력하세요"/><br><br>
				<input type="submit" class="btn btn-primary b-block w-100" value="탈퇴"/>
			</fieldset>
		</form>
	</div>

</body>
</html>