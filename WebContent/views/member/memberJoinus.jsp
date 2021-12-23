<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 page</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

	<style>
		fieldset {
			width: 400px;
			height: 500px;
			margin: 0 auto;
		}
		legend {
			text-align: center;
		}
	</style>

</head>
<body>
	
	
	<form action="/member/memberJoin.do" method="post">
		<fieldset>
			<legend>기본정보</legend>
			
				이름 : <input type="text" name="memberName"/><br>
				아이디 : <input type="text" name="memberId" id="memberId"> <input type="button" onclick="idCheck();" value="중복확인"/><br>
				영문소문자, 숫자 10~30자리 이내
				비밀번호 : <input type="password" name="memberPwd"/><br>
				영문대/소, 숫자, 특수문자 2가지 이상 조합, 10~20자리 이내
				비밀번호 확인 : <input type="password" name="memberPwd_re"/>
				동일한 비밀번호를 한 번 더 입력해주시기 바랍니다.
				생년월일 : <select>
							<option>1940</option>
							<option>1940</option>
							<option>1940</option>
							<option>1940</option>
							<option>1940</option>
							<option>1940</option>
							<option>1940</option>
							<option>1940</option>
							<option>1940</option>
							<option>1940</option>
							<option>1940</option>
							<option>1940</option>
							<option>1940</option>
							<option>1940</option>
							<option>1940</option>
							<option>1940</option>
							<option>1940</option>
							<option>1940</option>
							<option>1940</option>
							<option>1940</option>
							<option>1940</option>
							<option>1940</option>
							<option>1940</option>
							<option>1940</option>
							<option>1940</option>
							<option>1940</option>
							
						</select>년 
				
						<input type="text"/>월 <input type="text"/>일  <!-- 추후 옵션으로 변경하기 -->
				성별 : <input type="checkbox" name="gender" value="M" checked/>남자
					 <input type="checkbox" name="gender" value="F" checked/>여자<br>
				
			<legend>추가정보</legend>
			
				주소 : <input type="address" name="address" id="sample5_address" onclick="sample5_execDaumPostcode()"/>  <input type="button" onclick="sample5_execDaumPostcode()" value="주소 검색"><br>
				상세 주소 : <input type="text" name="detailAddress"/><br>
				휴대폰 : <input type="text"/> - <input type="text"/> - <input type="text"/> <br>
				이메일 : <input type="text"/> @ <input type="text"/><br>
				뉴스레터 및 SMS수신동의 : <input type="checkbox" name="sms" value="agreement"/>동의합니다.
									<input type="checkbox" name="sms" value="agreement"/>동의하지 않습니다.<br>
			
		</fieldset>
		
		<input type="rset" value="취소"/> <input type="submit" value="가입 완료" id="joinBtn"/>
		
	</form>
	
	
	<script> 
		function idCheck(){
			
			window.open("/views/member/idCheck.jsp", "_blank", "width=300px, height=300px");
			
		};
	</script>
	
	
	
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

	<script>
	    
	    function sample5_execDaumPostcode() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	                var addr = data.address; // 최종 주소 변수
	
	                // 주소 정보를 해당 필드에 넣는다.
	                document.getElementById("sample5_address").value = addr;
	               
	            }
	        }).open();
	    }
	</script>
	
	
</body>
</html>