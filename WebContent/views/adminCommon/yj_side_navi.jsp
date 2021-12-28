<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

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
		                    <a class="nav-link active" href="/adminPfmc/selectAllPfmcList.do">
			                    <i class="fa fa-music"></i>
			                    <span style="font-size:17px;">공연현황</span>
		                    </a>
	                    </c:if>
	                    
	                    <a class="nav-link active" href="/admin/adminCheck.do">
		                    <i class="fa fa-users"></i>
		                    <span style="font-size:17px;">회원 관리</span>
	                    </a>
	                    
	                    <a class="nav-link active" href="/views/admin/member_sch_wrote.jsp">
		                    <i class="fa fa-users"></i>
		                    <span style="font-size:17px;">작성글 관리</span>
	                    </a>
	                    
	                    <a class="nav-link active" href="table.html">
		                    <i class="fa fa-signal"></i>
		                    <span style="font-size:17px;">통계</span>
	                    </a>
	                    
            <a class="nav-link active" >
		                    <i class="fa fa-th-large">
		                    </i>

	                    <a class="nav-link active" href="/adminNotice/adminNoticeAllList.do">
		                    <i class="fa fa-th-large"></i>

		                    <span style="font-size:17px;">게시판 관리</span>
	                    </a>
	                    
	                    <%-- 최고관리자만 운영진관리 탭 나타남 --%>
	                    <c:if test="${String.valueOf(sessionScope.admin.superAdminYN) eq 'Y'}">
		                    <a class="nav-link active" href="/adminMngm/selectAllSubAdminList.do" id="adminMngm">
			                    <i class="fa fa-user"></i>
			                    <span style="font-size:17px;">운영진 관리</span>
		                    </a>
	                    </c:if>
                    </li>
                </ul>
                
                <div class="text-center d-none d-md-inline">
                	<button class="btn rounded-circle border-0" id="sidebarToggle" type="button"></button>
                </div>
            </div>
        </nav>
        
        
        
      

