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
    <title>운영진 정보</title>
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
	
    <div id="wrapper">
		<!--사이드 네비바 include-->
         <%@include file="/views/adminCommon/side_navi.jsp" %>
    
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
               
                 <div class="col-lg-6" style="margin-left: 6%;">
                   <div class="p-5" style="width:180%;">
                     <div class="text-center">
                         <h4 class="text-dark mb-4"><b>운영진 수정</b></h4>
                     </div>
                      <hr>
                      <form action="/adminMngm/updateAdminInfo.do" method="post">
	                      <div class="mb-3">
	                         <input class="form-control form-control-user" type="text" name="adminId" value="${requestScope.admin.adminId }" readonly>
	                      </div>
	                                      
	                      <%--일반관리자 본인만 비번 변경 가능 (최고관리자가 변경 불가)--%>
	                      <c:if test="${String.valueOf(sessionScope.admin.superAdminYN) eq 'N'}">
		                      <div class="mb-3">
			                       <button class="btn btn-primary d-block btn-user w-100" type="button" id="changePwdBtn">비밀번호 변경</button>
		                      </div>
	                      </c:if>  
	                      
	                      <div class="mb-3">
		                      <input class="form-control form-control-user" type="text" name="adminName" id="adminName" value="${requestScope.admin.adminName }">
	                      </div> 
	                          
		                  <div class="mb-3">
		                      <input class="form-control form-control-user" type="text" name="adminEmail" id="adminEmail" value="${requestScope.admin.adminEmail }">
	                      </div> 
	                      
	                      <%--일반 관리자는 비밀번호만 변경 가능 --%> 
	                      <c:if test="${String.valueOf(sessionScope.admin.superAdminYN) eq 'Y'}">
	                      	<button class="btn btn-primary d-block btn-user w-100" id="editBtn" type="submit">수정하기</button>
	                      </c:if>
	                 </form>
                     <hr>
                     	   <script>
                     	   		window.onload = function(){
                     	   		var superAdminYN = "${String.valueOf(sessionScope.admin.superAdminYN)}"
                     	   		if (superAdminYN == 'N'){
                     	   			$("b").text("프로필");
                     	   			$('#adminName').attr('readonly',true);
                     	   			$('#adminEmail').attr('readonly',true);
                     	   		}
                     	   		
                     	   		$('#changePwdBtn').click(function(){
                     	   			location.href = '/views/adminMngm/updateAdminPwd.jsp';
                     	   		})
                   	   		}
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

