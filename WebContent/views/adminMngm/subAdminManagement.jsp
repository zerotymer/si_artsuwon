<%@page import="java.util.HashMap"%>
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
    <title>관리자 페이지</title>
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
		HashMap<String,Object> adminListMap = (HashMap<String,Object>)request.getAttribute("adminListMap");
		
		ArrayList<Admin> adminList = (ArrayList<Admin>)adminListMap.get("adminList");
	    String pageNavi = (String)adminListMap.get("pageNavi");
	    int currentPage = (int)request.getAttribute("currentPage");
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
                <div class="container-fluid">
                	<div class="card shadow">
                        <div class="card-header py-3">
                        	<span><b>운영진 목록</b></span>
                        </div>
                        
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-6 text-nowrap">
                                    <div id="dataTable_length" class="dataTables_length" aria-controls="dataTable"></div>
                                    	<button onclick="location.href='/views/adminMngm/adminInsertForm.jsp';" class="btn btn-primary" >운영진 등록</button>
                                	</div>
                                
                                	<div class="col-md-6 text-nowrap">
                                    <div id="dataTable_length-1" class="dataTables_length" aria-controls="dataTable"></div>
                                	</div>
                            	</div>
                            
                           	 <div class="table-responsive table mt-2" id="dataTable" role="grid" aria-describedby="dataTable_info">
                                   <table class="table my-0" id="dataTable">
	                                    <thead>
	                                        <tr>
	                                            <th>No</th>
	                                            <th>아이디</th>
	                                            <th>이름</th>
	                                            <th>권한부여일</th>
	                                            <th>이메일</th>
	                                        </tr>
	                                    </thead>
                                    
	                                    <tbody>
	                                    <%for(Admin adList :adminList){ %>
	                                        <tr>
	                                            <td><%=adList.getNum() %></td>
	                                            <td>
		                                            <strong><a href="/adminMngm/showAdminInfo.do?adminNo=<%=adList.getAdminNo()%>" 
		                                            id="adminNo<%=adList.getAdminNo()%>"><%=adList.getAdminId() %> </a></strong>
	                                            </td>
	                                            <td><%=adList.getAdminName() %><br></td>
	                                            <td><%=adList.getAdminGrantDate() %></td>
	                                            <td><%=adList.getAdminEmail() %></td>
	                                            <td>
	                                            	<button type="button" onclick="deleteAdmin(this);" class="btn btn-danger" 
	                                            	 style="font-size:13px; padding-top:3px;padding-bottom:1px;" value=<%=adList.getAdminNo()%>>삭제
	                                            	</button>
	                                            </td>
	                                        </tr>
	                                    <%} %>
                                    	</tbody>
                                	</table>
                           		</div>
                            
		                            <!-- 운영진 삭제 -->
		                            <script>
		                                function deleteAdmin (e) {
		                                	var adminNo = $(e).attr('value');
		                                	var adminId = $('#adminNo'+adminNo).text();
		                                	var choice = confirm(adminId + "을 삭제하시겠습니까?");
		                                	
		                                	if(choice){
		                                		$.ajax({
		                                			url : "/adminMngm/deleteAdmin.do",
		                                			data : {"adminNo": adminNo},
		                                			type : "get",
		                                			success : function(resultRow){
		                                				if(resultRow>0){
		                                					alert('삭제되었습니다.');
		                                					location.reload(); //새로고침
		                                				}else{
		                                					alert('삭제에 실패했습니다.');
		                                				}
		                                			},
		                                			error : function(){
		                                				console.log('ajax 통신 실패');
		                                			}
		                                		});
		                                	    
		                                	}else{
		                                	    alert("삭제가 취소되었습니다.");
		                                	}
		                                }
		                            </script>
		                            
		                            <!-- 전체 건 수 -->
		                            <div class="row">
		                                <div class="col-md-6 align-self-center">
			                               <p id="recordQty" class="dataTables_info" role="status" aria-live="polite">총 <%=adminList.get(0).getTotalCount() %> 명</p>
		                                </div>
		                                
		                            <!-- 페이지 네비바 -->
		                                <div class="col-md-6">
		                                    <nav class="d-lg-flex justify-content-lg-end dataTables_paginate paging_simple_numbers">
		                                        <ul class="pagination">
		                                        	<%=pageNavi %>
		                                        </ul>
		                                    </nav>
		                                </div>
                           			</div>
                       </div>
                   </div>
              </div>
         </div>
                
            <!-- 푸터 -->
            <footer class="bg-white sticky-footer">
                <div class="container my-auto">
                    <div class="text-center my-auto copyright"><span>Copyright © Brand 2021</span></div>
                </div>
            </footer>
            
        </div>
        <a class="border rounded d-inline scroll-to-top" href="#page-top">
        	<i class="fas fa-angle-up"></i>
        </a>
    </div>
    
    <script src="<%=request.getContextPath()%>/assets/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/theme.js"></script>
</body>
</html>

