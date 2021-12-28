<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.artsuwon.member.model.vo.Member"%>
<%@page import="kr.or.artsuwon.member.model.vo.Reservation"%>
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
		ArrayList<Reservation> list = (ArrayList<Reservation>)request.getAttribute("list");
		System.out.println(list);
	%>
	
	
	<%if(list !=null){ %>
	
	<form>
		<fieldset>
			<legend>예매확인/취소</legend>
			
			
			<% for (Reservation r : list) {%>
			
			예약번호 : <%= r.getReservationNo() %><br>
			공연번호 : <%= r.getPerformanceNo() %><br>
			공연이름 : <%= r.getTitle() %><br>
			결제번호 : <%= r.getInvoiceNo() %><br>
			결제방법 : <%= r.getPayMethod() %><br>
			예약자 ID : <%= r.getReservationId() %><br>
			예약일자 : <%=r.getReservationDate() %><br>
			결제금액 : <%=r.getReservationPrice() %><br>
			예약좌석 : <%=r.getSeatCode() %><br>
			
			<% }%>
			
			<%if(list.isEmpty()) {%>
				<h4>현재 예약 정보가 없습니다.</h4>
			<%} %>
		</fieldset>
	</form> 
	
	<%} %>
	
	<form action="/member/memberUpdate.do" method="post">
		<fieldset>
			<legend>기본 정보</legend>
			이름 : <%=m.getMemberName() %> <br>
			생년월일 : <%=m.getBirthDate() %> <br>
			성별 :  <%if(m.getGender()=='M'){ %>
					남자
				  <%}else{ %>
				  	여자
				  <%} %> 
				  
			<br>
			비밀번호 변경 : <input type="button" id="pwdChangeBtn" value="비밀번호 변경"/><br>
		</fieldset>
		
		<fieldset>
			<legend>추가 정보</legend>
			주소 : <input type="address" name="address" id="sample5_address" onclick="sample5_execDaumPostcode()"/>  <input type="button" onclick="sample5_execDaumPostcode()" value="주소 검색"><br>
			상세주소 : <input type="text" name="detailAddress"/><br>
			핸드폰 : <select name="phone1">
							<option>010</option>
							<option>011</option>
							<option>016</option>
							<option>017</option>
							<option>018</option>
							<option>019</option>
					</select> - <input type="text" name="phone2" maxlength="4" size="4"/> - <input type="text" name="phone3" maxlength="4" size="4"/> <br>
			이메일 : <input type="text" name="email1"/> @ <input type="text"  name="email2"/> <br>
			SMS 수신동의 : <input type="radio" name="smsYN" value="Y" checked/>동의합니다.
						 <input type="radio" name="smsYN" value="N"/>동의하지 않습니다.<br>
		
		</fieldset>
		
		<input type="reset" value="취소" id="reset"/> <input type="submit" id="submitBtn" value="변경하기"/>     
	
	</form>
	
	<button id="withDrawBtn">회원탈퇴</button><br>
	
	
	
	
	
	
	<%--비밀번호 변경 --%>
	<script>
	$('#pwdChangeBtn').click(function(){
		window.open("/views/member/memberPasswordChangeWindow.jsp","_blank","width=400px, height=300px");
	});
	</script>	
	
	
	<%--주소 검색 API --%>
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
	
	
	<%--변경 재확인 --%>
	<script>
		$('#submitBtn').click(function(){
			
			var result = window.confirm("회원정보를 변경하시겠습니까?");
			
				if(result)
				{
					return true;
				}else
				{
					return false;
				}
				
		});
	</script>
	
	
	<%--회원 탈퇴 버튼 --%>
	<script>
		$('#withDrawBtn').click(function(){
			
			
			// 1. 탈퇴를 진행하시겠습니까?
			// 2. 탈퇴를 하시게 되면, 데이터는 절대 복구 불가능합니다.
			
			if(window.confirm("탈퇴를 진행하시겠습니까?") && window.confirm("탈퇴 후 데이터 복구는 불가능합니다. 진행하시겠습니까?"))
			{
				location.replace("/member/memberWithDraw.do");				
			}else
			{	
				alert('탈퇴를 취소하였습니다.');

			}

			
			
		});
	
	</script>
	
	
	<%--취소 후 메인화면으로 이동 --%>
	<script>
		$('#reset').click(function(){
			
			location.replace("/");
			return false;
			
		});
	</script>
	
	
</body>
</html>