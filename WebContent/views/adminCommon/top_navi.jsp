<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<nav class="navbar navbar-light navbar-expand bg-white shadow mb-4 topbar static-top">
    <div class="container-fluid">
        <button class="btn btn-link d-md-none rounded-circle me-3" id="sidebarToggleTop" type="button">
         <i class="fas fa-bars">
         </i>
        </button>
                        
        <ul class="navbar-nav flex-nowrap ms-auto">
          <div class="d-none d-sm-block topbar-divider"></div>
             <li class="nav-item dropdown no-arrow">
                 <div class="nav-item dropdown no-arrow">
	                   <a class="dropdown-toggle nav-link" aria-expanded="false" data-bs-toggle="dropdown" href="#">
	                  	 <i class="fa fa-user"></i>&nbsp;&nbsp;
	                  	 <span class="d-none d-lg-inline me-2 text-gray-600 small"> ${sessionScope.admin.adminName }</span>
	                   </a>
                 
			           <div class="dropdown-menu dropdown-menu-end animated--grow-in">
				           <%-- 최고관리자는 프로필 수정탭 안나타남 --%>
							 <c:if test="${String.valueOf(sessionScope.admin.superAdminYN) eq 'N'}">	
					             <a class="dropdown-item" href="/showAdminInfo.do?adminNo=${sessionScope.admin.adminNo }">
					             	<i class="fas fa-cogs fa-sm fa-fw me-2 text-gray-400"></i>&nbsp;프로필
					             </a>
				        	 </c:if>
				                      
				           <div class="dropdown-divider"></div>
				            <a class="dropdown-item" href="/adminMngm/adminLogout.do">
				         	 <i class="fas fa-sign-out-alt fa-sm fa-fw me-2 text-gray-400"></i>&nbsp;로그아웃
				            </a>
			           </div>
          		  </div>
            </li>
        </ul>
     </div>
</nav>