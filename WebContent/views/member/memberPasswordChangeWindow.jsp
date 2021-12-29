<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- jQuery 라이브러리 -->
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

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
	#pwdForm{
		width : 300px;
		height : 250px;
        margin: 30 auto;
        font-size: 1.2em;
	}
</style>

</head>
<body>

	<div id="pwdForm">
		<form action="/member/memberPwdChange.do" method="post">
			현재 비밀번호  <input class="form-control" name="pwd" type="password" aria-label="default input example" placeholder="현재 비밀번호를 입력하세요" size="30"><br><br>
			
			<p style="font-size: 0.7em; color: red;" >비밀번호는 소문자,대문자,숫자를 포함한 8~12 글자 이내로 입력</p>
			
			변경할 비밀번호  <input class="form-control" name="new_pwd" type="password" aria-label="default input example" placeholder="변경할 비밀번호를 입력하세요" size="30"><br>
			
			비밀번호 재확인  <input class="form-control" name="new-pwd_re" type="password" aria-label="default input example" placeholder="변경할 비밀번호를 재입력하세요" size="30"><br><br>
			
			<input type="submit" class="btn btn-primary b-block w-100" value="변경하기"/>
		</form>
	</div>
	
	
</body>
</html>