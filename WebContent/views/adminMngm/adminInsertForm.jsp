<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.artsuwon.adminMngm.model.vo.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>운영진 등록</title>
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="/assets/fonts/fontawesome-all.min.css">
    <link rel="stylesheet" href="/assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="/assets/fonts/fontawesome5-overrides.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
    <script src="https://code.jquery.com/jquery-3.5.1.js" 
integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
</head>

<body id="page-top">
	<%
		Admin admin = (Admin)session.getAttribute("admin");
		ArrayList<Admin> adminList = (ArrayList<Admin>)request.getAttribute("adminList");
	%>
	
	
    <div id="wrapper">
		<!--사이드 네비바 include-->
         <%@include file="/views/adminCommon/yj_side_navi.jsp" %>
    
        <!-- 컨텐츠 영역 -->
        <div class="d-flex flex-column" id="content-wrapper">
            <div id="content">
                <!--상단 네비바 include-->
       			 <%@include file="/views/adminCommon/top_navi.jsp" %>
                
      <!-- 컨테이너 -->
      <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-9 col-lg-12 col-xl-10" style="width:40%;">
                <div class="card shadow p-3 mb-5 bg-white rounded">
                    <div class="card-body p-0">
                        
                            <div class="col-lg-6" style="margin-left:6%;">
                                <div class="p-5" style="width:180%;">
                                    <div class="text-center">
                                        <h4 class="text-dark mb-4"><b>새 운영진 등록</b></h4>
                                    </div>
                                    <hr>
                                    
                                    <form class="user" action="/adminMngm/insertAdmin.do" method="post">
                                        <div class="mb-3">
	                                        <input class="form-control form-control-user" type="text" id="adminId" placeholder="아이디를 입력하세요" name="adminId" autocomplete="off">
	                                        <span id="idMsg" style="font-size:12px;"></span>
                                        </div>
                                        
                                        <div class="mb-3">
	                                        <input class="form-control form-control-user" type="password" id="adminPwd1" placeholder="비밀번호를 입력하세요" name="adminPwd">
	                                    	<span id="pwdMsg1" style="font-size:12px;"></span>
	                                    </div>
	                                    
	                                    <div class="mb-3">
	                                        <input class="form-control form-control-user" type="password" id="adminPwd2" placeholder="비밀번호를 재입력하세요" name="adminRePwd">
	                                    	<span id="pwdMsg2" style="font-size:12px;"></span>
	                                    </div>
	                                    
	                                    <div class="mb-3">
	                                        <input class="form-control form-control-user" type="text" id="adminName" placeholder="이름을 입력하세요" name="adminName">
	                                    </div>
	                                    
	                                    <div class="mb-3"> 
	                                        <input class="form-control form-control-user" type="email" id="adminEmail" placeholder="이메일을 입력하세요" name="adminEmail">
                                        </div>
                                        
                                        <div class="mb-3">
                                            <div class="custom-control custom-checkbox small"></div>
                                        </div><button class="btn btn-primary d-block btn-user w-100" type="submit" onclick="return check();">등록하기</button>
                                        <hr>
                                    </form>
                                    
                                    <script>
                                    	//id 중복체크
                                    	$('#adminId').focusout(function(){
											var adminId = $('#adminId').val();
											var exp = /^[a-z][a-z0-9]{3,11}$/; 
											
											if(exp.test(adminId)){
	                                    		$.ajax({
	                                    			url : "/adminMngm/adminIdCheck.do",
	                                    			data : {"adminId" : adminId},
	                                    			type : "get",
	                                    			success : function(result){
	                                    				if(result=="true"){
	                                    					$('#idMsg').html("이미 사용 중인 아이디입니다").css('color','red');
	                                    				}else{
	                                    					$('#idMsg').html("사용 가능한 아이디입니다").css('color','blue');
	                                    				}
	                                    			},
	                                    			error : function(){
	                                    				console.log('ajax 통신 실패');
	                                    			}
	                                    		});
                                    	
											}else{
												$('#idMsg').html("소문자 및 숫자 4~12글자 입력바랍니다").css('color','red');
											}
                                    	});
                                    </script>
                                   
                                   <script>
                                 	//비밀번호 일치 여부 체크
                                 	$("#adminPwd2").blur(function(){
                                 		var pw1 = $('#adminPwd1').val();
                                 		var pw2 = $('#adminPwd2').val();
                                 		var rule = /[a-zA-Z0-9]{8,12}$/;
                                 		
                                   		if(!(rule.test(pw1)) && !(rule.test(pw2))){
                                   			$('#pwdMsg1').html("대소문자 또는 숫자 8~12글자로 입력하세요").css('color','red');
                                   			$('#pwdMsg2').html("대소문자 또는 숫자 8~12글자로 입력하세요").css('color','red');
                                   		}else if(pw1 != pw2){
                                   			$('#pwdMsg2').html("비밀번호가 서로 일치하지 않습니다").css('color','red');
                                   		}else{
                                   			$('#pwdMsg1').html("");
                                   			$('#pwdMsg2').html("");
                                   		}
									});
                                   </script>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
   
    
             <footer class="bg-white sticky-footer">
                <div class="container my-auto">
                    <div class="text-center my-auto copyright"><span>Copyright © Brand 2021</span></div>
                </div>
            </footer>
            
        </div><a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a>
    </div>
    
    <script src="/assets/js/bootstrap.min.js"></script>
    <script src="/assets/js/theme.js"></script>
</body>
</html>

