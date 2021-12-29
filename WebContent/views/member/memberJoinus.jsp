<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- jQuery 라이브러리 -->
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 page</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

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
    .wrapper{
        box-sizing: border-box;
        width: 70%;
        height: 1300px;
        margin: 0 auto;
    }
    .info{
        box-sizing: border-box;
        width: 100%;
        height: 180px;
        float: left;
        background-color: #F6F6F6;
        padding: 20px;
    }
    .join{
        box-sizing: border-box;
        width: 100%;
        height: 820px;
        float: left;
        text-align: center;
    }
    .moveBtn{
        margin: auto;
        display: block;
    }
    .address{
        width: 350px;
    }
    
    
</style>

</head>
<body>

<!-- Header -->
<%@ include file="/include/_header.jsp" %>


<div class="wrapper">
        <div class="info">
            <H2>회원가입</H2><br>
            세계 최고의 교향악단으로 거듭나기 위한 수원시향은 늘 대중에게 한걸음 가까이 다가서기 위해 노력하고 있습니다.<br>
            클래식 음악을 사랑하는 서울시향의 모든 회원님들께 공연정보와 다양한 혜택을 제공해 드립니다.
        </div>
        
        <br><br><br>
        
    <form action="/member/memberJoin.do" method="post" onsubmit="return mustHave();">
        <div class="join">
           <br><br>
            <table class="table">
                  <thead>
                    <tr>
                        <th scope="col" colspan="4"><h4>기본정보</h4> <p style="color: orangered">※원활한 서비스를 위해 정확히 기재해주세요</p></th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <th scope="row"> 이름＊</th>
                      <td colspan="3"><input type="text" name="memberName" id="memberName" maxlength="5"/></td>
                    </tr>
                    <tr>
                      <th scope="row"> 아이디＊ </th>
                      <td colspan="3"><input type="text" name="memberId" id="memberId"> <button class="btn btn-primary" id="idCheckBtn" style="background-color: #ED4C00;" >중복확인</button><br>
                        <p style="font-size: 0.9em; color: darkgray;">아이디는 영문 소문자,숫자 8~10 글자 이내로 입력하세요.</p>
					   <span id="msg"></span></td>
                    </tr>
                    <tr>
                      <th scope="row"> 비밀번호＊ </th>
                      <td colspan="3"><input type="password" name="memberPwd" id="memberPwd"/><br>
				        <p style="font-size: 0.9em; color: darkgray;">소문자,대문자,숫자를 포함한 8~12 글자 이내로 입력하세요.</p></td>
                    </tr>
                    <tr>
                      <th scope="row"> 비밀번호 확인＊</th>
                      <td colspan="3"><input type="password" name="memberPwd_re" id="memberPwd_re"/><br>
				        <p style="font-size: 0.9em; color: darkgray;">동일한 비밀번호를 한 번 더 입력하세요.</p></td>
                    </tr>
                    <tr>
                      <th scope="row"> 생년월일＊ </th>
                      <td colspan="3">
                      <select name="birthDate1">
							<option value="1940">1940</option>
							<option value="1941">1941</option>
							<option value="1942">1942</option>
							<option value="1943">1943</option>
							<option value="1944">1944</option>
							<option value="1945">1945</option>
							<option value="1946">1946</option>
							<option value="1947">1947</option>
							<option value="1948">1948</option>
							<option value="1949">1949</option>
							<option value="1950">1950</option>
							<option value="1951">1951</option>
							<option value="1952">1952</option>
							<option value="1953">1953</option>
							<option value="1954">1954</option>
							<option value="1955">1955</option>
							<option value="1956">1956</option>
							<option value="1957">1957</option>
							<option value="1958">1958</option>
							<option value="1959">1959</option>
							<option value="1960">1960</option>
							<option value="1961">1961</option>
							<option value="1962">1962</option>
							<option value="1963">1963</option>
							<option value="1964">1964</option>
							<option value="1965">1965</option>
							<option value="1966">1966</option>
							<option value="1967">1967</option>
							<option value="1968">1968</option>
							<option value="1969">1969</option>
							<option value="1970">1970</option>
							<option value="1971">1971</option>
							<option value="1972">1972</option>
							<option value="1973">1973</option>
							<option value="1974">1974</option>
							<option value="1975">1975</option>
							<option value="1976">1976</option>
							<option value="1977">1977</option>
							<option value="1978">1978</option>
							<option value="1979">1979</option>
							<option value="1980">1980</option>
							<option value="1981">1981</option>
							<option value="1982">1982</option>
							<option value="1983">1983</option>
							<option value="1984">1984</option>
							<option value="1985">1985</option>
							<option value="1986">1986</option>
							<option value="1987">1987</option>
							<option value="1988">1988</option>
							<option value="1989">1989</option>
							<option value="1990">1990</option>
							<option value="1991">1991</option>
							<option value="1992">1992</option>
							<option value="1993">1993</option>
							<option value="1994">1994</option>
							<option value="1995">1995</option>
							<option value="1996">1996</option>
							<option value="1997">1997</option>
							<option value="1998">1998</option>
							<option value="1999">1999</option>
							<option value="2000">2000</option>
							<option value="2001">2001</option>
							<option value="2002">2002</option>
							<option value="2003">2003</option>
							<option value="2004">2004</option>
							<option value="2005">2005</option>
							<option value="2006">2006</option>
							<option value="2007">2007</option>
							<option value="2008">2008</option>
							<option value="2009">2009</option>
							<option value="2010">2010</option>
							<option value="2011">2011</option>
							<option value="2012">2012</option>
							<option value="2013">2013</option>
							<option value="2014">2014</option>
							<option value="2015">2015</option>
							<option value="2016">2016</option>
							<option value="2017">2017</option>
							<option value="2018">2018</option>
							<option value="2019">2019</option>
							<option value="2020">2020</option>
							<option value="2021">2021</option>
						</select>년 
						
						<select name="birthDate2">
							<option value="01">01</option>
							<option value="02">02</option>
							<option value="03">03</option>
							<option value="04">04</option>
							<option value="05">05</option>
							<option value="06">06</option>
							<option value="07">07</option>
							<option value="08">08</option>
							<option value="09">09</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
						</select>월
						
						<select name="birthDate3">
							<option value="01">01</option>
							<option value="02">02</option>
							<option value="03">03</option>
							<option value="04">04</option>
							<option value="05">05</option>
							<option value="06">06</option>
							<option value="07">07</option>
							<option value="08">08</option>
							<option value="09">09</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
							<option value="13">13</option>
							<option value="14">14</option>
							<option value="15">15</option>
							<option value="16">16</option>
							<option value="17">17</option>
							<option value="18">18</option>
							<option value="19">19</option>
							<option value="20">20</option>
							<option value="21">21</option>
							<option value="22">22</option>
							<option value="23">23</option>
							<option value="24">24</option>
							<option value="25">25</option>
							<option value="26">26</option>
							<option value="27">27</option>
							<option value="28">28</option>
							<option value="29">29</option>
							<option value="30">30</option>
							<option value="31">31</option>
						</select>일</td>
                      <tr>
                      <th scope="row"> 성별＊ </th>
                      <td colspan="3"><input type="radio" name="gender" value="M" checked/>남자
					 <input type="radio" name="gender" value="F" />여자</td>
                  </tbody>
                </table>
                <br><br>
                <table class="table">
                  <thead>
                    <tr>
                      <th scope="col" colspan="4"><h4>추가정보</h4></th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <th scope="row"> 주소＊ </th>
                      <td colspan="3"><input type="address" name="address" id="sample5_address" onclick="sample5_execDaumPostcode()" class="address"/>  <input type="button" onclick="sample5_execDaumPostcode()" value="주소 검색"></td>
                    </tr>
                    <tr>
                      <th scope="row"> 상세주소＊ </th>
                      <td colspan="3"><input type="text" name="detailAddress" id="detailAddress" class="address"/></td>
                    </tr>
                    <tr>
                      <th scope="row"> 휴대폰＊ </th>
                      <td colspan="3"><select name="phone1" id="phone1">
							<option>010</option>
							<option>011</option>
							<option>016</option>
							<option>017</option>
							<option>018</option>
							<option>019</option>
						</select> - <input type="text" name="phone2" id="phone2" maxlength="4" size="4"/> - <input type="text" name="phone3" id="phone3" maxlength="4" size="4"/></td>
                    </tr>
                    <tr>
                      <th scope="row"> 이메일＊ </th>
                      <td colspan="3"><input type="text" name="email1" id="email1"/> @ <input type="text" name="email2" id="email2"/></td>
                    </tr>
                    <tr>
                      <th scope="row"> SMS 수신동의＊ </th>
                      <td colspan="3"><input type="radio" name="smsYN" value="Y" checked/>동의합니다.
							 <input type="radio" name="smsYN" value="N"/>동의하지 않습니다.</td>
                    </tr>
                  </tbody>
                </table>
               <br><br>
               <span id="message"></span> <br><br><br>
            <button class="btn btn-primary" id="loginBtn" type="reset" style="background-color: #D8D8D8; width: 90px; height: 50px" class="moveBtn" >취소</button> &nbsp;
            <button class="btn btn-primary" id="joinBtn" class="moveBtn" type="submit" style="background-color: #ED4C00; width: 90px; height: 50px" >가입하기</button>
             
        </div>
    </form>
</div>

	
	
	
	
	
	
	
	<%-- 아이디 중복 체크 Script --%>
	<script>
		$('#idCheckBtn').click(function(){
			
			var memberId = $('#memberId').val();
			
			$.ajax({
				url : "/member/memberIdCheck.do",
				data : {"memberId": memberId},
				type : "get",
				success : function(result){
					
					if(result=="true")
					{
						$('#msg').html("사용불가").css('color','red');
					}else{
						$('#msg').html("사용가능").css('color','blue');
					}
					
				},
				error : function(){
					console.log('ajax 통신 실패');
				}
			})
			
			
			
		});
	</script>
	
	
	
	
	<%-- 주소 검색 API --%>
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
	
	
	<%--reset 메인 이동 --%>
	<script>
		$('#reset').click(function(){
			
			location.replace("/");
			return false;
			
		});
	</script>
	

	
	
	
	
	<%--종합 검증 --%>
	
	<script>

            var message = document.getElementById("message");
            var memberName = document.getElementById("memberName");
            var memberId = document.getElementById("memberId");
            var memberPwd = document.getElementById("memberPwd");
            var memberPwd_re = document.getElementById("memberPwd_re");
            
            var sample5_address = document.getElementById("sample5_address");
            var detailAddress = document.getElementById("detailAddress");
            var email1 = document.getElementById("email1");
            var email2 = document.getElementById("email2");
            var phone1 = document.getElementById("phone1");
            var phone2 = document.getElementById("phone2");
            var phone3 = document.getElementById("phone3");


        function check() {
			
        	if (!(/[가-힣]+$/.test(memberName.value))) //이름 검사
            {
            	message.style.color = "red";
                message.innerHTML = "※이름은 한글(최소1글자)만 가능합니다.";
                return false;
                
            } 
			else if (!(/^[a-z][a-z0-9]{8,10}$/.test(memberId.value))) //아이디 검사
            {
            	message.style.color = "red";
                message.innerHTML = "※아이디는 영문 소문자,숫자 8~10 글자 이내로 입력";
                return false;
                
            } 
			else if (!(/[a-zA-Z0-9]{8,12}$/.test(memberPwd.value))) //비밀번호 검사
            {
            	message.style.color = "red";
                message.innerHTML = "※비밀번호는 소문자,대문자,숫자를 포함한 8~12 글자 이내로 입력";
                return false;
                
            } 
			else if (!(memberPwd.value == memberPwd_re.value)) //PW와 PW_RE 비교 검사
            {
            	message.style.color = "red";
                message.innerHTML = "※비밀번호가 일치하지 않습니다.";
                return false;
       			
            }
			else if ((/[a-z]+$/i).test(sample5_address.value) || sample5_address.value == "") //주소검사
            {
            	message.style.color = "red";
                message.innerHTML = "※주소 입력은 영어 사용이 불가합니다. (공백 불가)";
                return false;
                
            } 
			else if ((/[a-z]+$/i).test(detailAddress.value) || detailAddress.value == "") //주소검사
            {
            	message.style.color = "red";
                message.innerHTML = "※주소 입력은 영어 사용이 불가합니다. (공백 불가)";
                return false;
                
            } 
			else if (!((/^010$/.test(phone1.value)) && (/[0-9]{3,4}$/.test(phone2.value)) && (/[0-9]{4}$/.test(phone3.value)))) //폰 검사
            {
            	message.style.color = "red";
                message.innerHTML = "※전화번호 재확인 바랍니다.";
                return false;
            }
			else if (!(/^[a-z0-9]{4,12}/).test(email1.value)) //이메일 검사
            {
            	message.style.color = "red";
                message.innerHTML = "※이메일을 재확인해주세요.";
                return false;
            } 	
			else{
            	return true;	
            }
            
            
        }

      
   
    </script>
    
    
    <%--submit 이동 시 이벤트 --%>
	<script>

		function mustHave(){
			
			return check();
			
		}
	</script>
	
	

<!-- footer -->
<%@ include file="/include/_footer.jsp" %>
	
	
	
	
</body>
</html>