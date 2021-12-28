<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
   <script src="https://code.jquery.com/jquery-3.5.1.js" 
integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>


 	<nav class="navbar navbar-dark align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0">
            
            <div class="container-fluid d-flex flex-column p-0">
            	<a class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0" href="/views/adminMngm/adminMain.jsp">
                    <div class="sidebar-brand-icon rotate-n-15">
                    	<i class="far fa-edit"></i>
                    </div>
                    <div class="sidebar-brand-text mx-3">
                    	<span style="font-size:20px;">관리자 페이지</span>
                    </div>
                </a>
                
                <hr class="sidebar-divider my-0">
                <ul class="navbar-nav text-light" id="accordionSidebar">
                    <li class="nav-item">
                    	<%-- 최고관리자만 운영진관리 탭 나타남 --%>
	                    <c:if test="${String.valueOf(sessionScope.admin.superAdminYN) eq 'Y'}">
		                    <a class="nav-link active" href="/selectAllPfmcList.do">
			                    <i class="fa fa-music">
			                    </i>
			                    <span style="font-size:17px;">공연현황</span>
		                    </a>
	                    </c:if>
	                    
	                    <a class="nav-link active">
		                    <i class="fa fa-users">
		                    </i>
		                    <span style="font-size:17px;">회원 관리</span><br>
	                    </a>
	                    
	                     <a class="nav-link active" href="">
		                    <i class="fa fa-users">
		                    </i>
		                    <span style="font-size:17px;">- 사용자 관리</span><br>
	                    </a>
	                     <a class="nav-link active" href="">
		                    <i class="fa fa-users">
		                    </i>
		                    <span style="font-size:17px;">- 통계</span><br>
	                    </a>
	                    
	                    <a class="nav-link active">
		                    <i class="fa fa-users">
		                    </i>
		                    <span style="font-size:17px;">게시판 관리</span><br>
	                    </a>
	                    
	                    <a class="nav-link active" href="">
		                    <i class="fa fa-users">
		                    </i>
		                    <span style="font-size:17px;">- 공지사항</span><br>
	                    </a>
	                    
	                    <a class="nav-link active" href="">
		                    <i class="fa fa-users">
		                    </i>
		                    <span style="font-size:17px;">- CS게시판</span><br>
	                    </a>
	                    
	                    
	                    <%-- 최고관리자만 운영진관리 탭 나타남 --%>
	                    <c:if test="${String.valueOf(sessionScope.admin.superAdminYN) eq 'Y'}">
		                    <a class="nav-link active" href="/selectAllSubAdminList.do">
			                    <i class="fa fa-user">
			                    </i>
			                    <span style="font-size:17px;">운영진 관리</span>
		                    </a>
	                    </c:if>
                    </li>
                </ul>
             
                
				
                <!-- 네비바 줄이기 버튼 -->
                <div class="text-center d-none d-md-inline">
                	<button class="btn rounded-circle border-0" id="sidebarToggle" type="button"></button>
                </div>
            </div>
        </nav>
        
       
		
                
        