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
				영문소문자, 숫자 10~30자리 이내<br>
				비밀번호 : <input type="password" name="memberPwd"/><br>
				영문대/소, 숫자, 특수문자 2가지 이상 조합, 10~20자리 이내<br>
				비밀번호 확인 : <input type="password" name="memberPwd_re"/><br>
				동일한 비밀번호를 한 번 더 입력해주시기 바랍니다.<br>
				생년월일 : <select name="birthDate">
							<option>1940</option>
							<option>1941</option>
							<option>1941</option>
							<option>1942</option>
							<option>1943</option>
							<option>1944</option>
							<option>1945</option>
							<option>1946</option>
							<option>1947</option>
							<option>1948</option>
							<option>1949</option>
							<option>1950</option>
							<option>1951</option>
							<option>1952</option>
							<option>1953</option>
							<option>1954</option>
							<option>1955</option>
							<option>1956</option>
							<option>1957</option>
							<option>1958</option>
							<option>1959</option>
							<option>1960</option>
							<option>1961</option>
							<option>1962</option>
							<option>1963</option>
							<option>1964</option>
							<option>1965</option>
							<option>1966</option>
							<option>1967</option>
							<option>1968</option>
							<option>1969</option>
							<option>1970</option>
							<option>1971</option>
							<option>1972</option>
							<option>1973</option>
							<option>1974</option>
							<option>1975</option>
							<option>1976</option>
							<option>1977</option>
							<option>1978</option>
							<option>1979</option>
							<option>1980</option>
							<option>1981</option>
							<option>1982</option>
							<option>1983</option>
							<option>1984</option>
							<option>1985</option>
							<option>1986</option>
							<option>1987</option>
							<option>1988</option>
							<option>1989</option>
							<option>1990</option>
							<option>1991</option>
							<option>1992</option>
							<option>1993</option>
							<option>1994</option>
							<option>1995</option>
							<option>1996</option>
							<option>1997</option>
							<option>1998</option>
							<option>1999</option>
							<option>2000</option>
							<option>2001</option>
							<option>2002</option>
							<option>2003</option>
							<option>2004</option>
							<option>2005</option>
							<option>2006</option>
							<option>2007</option>
							<option>2008</option>
							<option>2009</option>
							<option>2010</option>
							<option>2011</option>
							<option>2012</option>
							<option>2013</option>
							<option>2014</option>
							<option>2015</option>
							<option>2016</option>
							<option>2017</option>
							<option>2018</option>
							<option>2019</option>
							<option>2020</option>
							<option>2021</option>
						</select>년 
						
						<select name="birthDate">
							<option>01</option>
							<option>02</option>
							<option>03</option>
							<option>04</option>
							<option>05</option>
							<option>06</option>
							<option>07</option>
							<option>08</option>
							<option>09</option>
							<option>10</option>
							<option>11</option>
							<option>12</option>
						</select>월
						
						<select>
							<option>01</option>
							<option>02</option>
							<option>03</option>
							<option>04</option>
							<option>05</option>
							<option>06</option>
							<option>07</option>
							<option>08</option>
							<option>09</option>
							<option>10</option>
							<option>11</option>
							<option>12</option>
							<option>13</option>
							<option>14</option>
							<option>15</option>
							<option>16</option>
							<option>17</option>
							<option>18</option>
							<option>19</option>
							<option>20</option>
							<option>21</option>
							<option>22</option>
							<option>23</option>
							<option>24</option>
							<option>25</option>
							<option>26</option>
							<option>27</option>
							<option>28</option>
							<option>29</option>
							<option>30</option>
							<option>31</option>
						</select>일
						<br>
				성별 : <input type="checkbox" name="gender" value="M" checked/>남자
					 <input type="checkbox" name="gender" value="F" />여자<br>
				
			<legend>추가정보</legend>
			
				주소 : <input type="address" name="address" id="sample5_address" onclick="sample5_execDaumPostcode()"/>  <input type="button" onclick="sample5_execDaumPostcode()" value="주소 검색"><br>
				상세 주소 : <input type="text" name="detailAddress"/><br>
				휴대폰 : <select name="phone">
							<option>010</option>
							<option>011</option>
							<option>016</option>
							<option>017</option>
							<option>018</option>
							<option>019</option>
						</select> - <input type="text" name="phone" maxlength="4"/> - <input type="text" name="phone" maxlength="4"/> <br>
				이메일 : <input type="text" name="email"/> @ <input type="text"  name="email"/> 
						<select>
							<option>직접입력</option>
							<option>naver.com</option>
							<option>daum.net</option>
							<option>nate.com</option>
							<option>gmail.com</option>
							<option>hanmail.net</option>
							<option>hotmail.com</option>
						</select>
						<br>
				뉴스레터 및 SMS수신동의 : <input type="checkbox" name="smsYN" value="agreement" checked/>동의합니다.
									<input type="checkbox" name="smsYN" value="notAgreement"/>동의하지 않습니다.<br>
			
		</fieldset>
		
		<input type="reset" value="취소"/> <input type="submit" value="가입 완료" id="joinBtn"/>
		
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