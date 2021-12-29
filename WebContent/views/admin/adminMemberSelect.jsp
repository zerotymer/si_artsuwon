<%@page import="kr.or.artsuwon.member.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



	<meta charset="utf-8">
	<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>회원관리 페이지</title>
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="/assets/fonts/fontawesome-all.min.css">
    <link rel="stylesheet" href="/assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="/assets/fonts/fontawesome5-overrides.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
    
    <style>
    	.content-div {
    		display: flex;
    			flex-direction: row;
    	}
    </style>
</head>

<body id="page-top">

	<%
		ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
		int adminNo = (int)request.getAttribute("adminNo");
		
		
	%>
	
	
	


    <div id="wrapper">
    	
       	 <!--사이드 네비바 include-->
        <%@include file="/views/adminCommon/yj_side_navi.jsp" %>
        		
       
        <div class="d-flex flex-column" id="content-wrapper">
            
            <div id="content">
        		
        		
		<!--상단 네비바 include-->
        <%@include file="/views/adminCommon/top_navi.jsp" %>
        		
        		<div class="content-div">
        		
       
        	
        		<div class="container-fluid">
    <!-- <h3 class="text-dark mb-4">회원관리</h3> -->
    <div class="card shadow">
        <div class="card-header py-3">
            <p class="text-primary m-0 fw-bold">전체 사용자 관리</p>
        </div>
        <div class="card-body">
        
        	<!-- 검색옵션 & 검색창 시작 -->
            <div class="row"> 
            	
                <div class="col-md-6" style="width: 250px;border-radius: 5px;">
                <span>
                	<span class="input-group mb-3 edtFormMarg">
                		<span class="input-group-prepend">
                			<label class="input-group-text" for="inputGroupSelect01">Options</label>
                			</span>
                			
                		<form action="/admin/adminMemberPostSch.do" method="get">	
                			<select name="type" class="custom-select">
                                <option selected>검색옵션</option>
                                <option value="memberId">ID</option>
                                <option value="memberName">이름</option>
                            </select>
                     </span>
                  </span>
                  </div>
                <div class="col">
                	<input type="search" style="height: 38px; width: 620px;border-radius: 5px;" name="keyword"/>
                	<input class="btn btn-primary" type="submit" value="검색"/>
                </div>
                </form>
            </div>
            <!-- 검색옵션 & 검색창 끝 -->
            
            <div id="dataTable" class="table-responsive table mt-2" role="grid" aria-describedby="dataTable_info">
                <table id="dataTable1" class="table my-0">
                    <thead>
                        <tr>
                            <th style="width: 20px;"><input type="checkbox" /></th>
                            <th style="color: rgb(133, 135, 150);width: 300px;">이름(ID)</th>
                            <th style="color: rgb(133, 135, 150);width: 200px;">가입일</th>
                            <th style="color: rgb(133, 135, 150);width: 200px;">이메일</th>
                            <th style="color: rgb(133, 135, 150);width: 200px;">주소</th>
                            
                            <th style="width: 300px;text-align: center;">
                            <button class="btn btn-primary" type="button" style="height: 30px;">강제탈퇴</button>
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                    
                    	<%for(Member m : list) { %>
                        <tr>
                            <td><input type="checkbox" /></td>
                            <td><img class="rounded-circle me-2" width="30" height="30" src="/assets/images/memberPicture.jpg" /><%=m.getMemberName() %> (<%=m.getMemberId() %>)</td>
                            <td style="width: 200px;"><%=m.getEnrollDate() %></td>
                            <td style="width: 200px;"><%=m.getEmail() %></td>
                            <td style="width: 250px;"><%=m.getAddress() %></td>
                            <td style="width: 200px;text-align: center;">
                            <button class="btn btn-primary active" type="button" style="height: 30px;" onclick="location.href='/admin/memberEndYNChange.do?memberNo=<%=m.getMemberNo() %>&memberStatus=<%=m.getMemberStatus() %>';">강제탈퇴</button></td>
                        </tr>
                        <%} %>
                       
                    </tbody>
                    <tfoot>
                        <tr>
                            <td><strong></strong></td>
                            
                        </tr> 
                    </tfoot>
                </table>
            </div>
            <div class="row">
                <div class="col-md-6 align-self-center">
                    
                </div>
                <div class="col-md-6">
                    <nav class="d-lg-flex justify-content-lg-end dataTables_paginate paging_simple_numbers">
                        <ul class="pagination">
                            <!-- <li class="page-item disabled"><a class="page-link" href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
                            <li class="page-item active"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item"><a class="page-link" href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li> -->
                            
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</div>
            </div>
        		</div>
                
            <footer class="bg-white sticky-footer">
                <nav class="d-lg-flex justify-content-lg-end dataTables_paginate paging_simple_numbers">
                    <ul class="pagination"></ul>
                </nav>
                <div class="container my-auto">
                    <div class="text-center my-auto copyright"><span><br><br>webmaster :&nbsp;<a href="mailto:artsuwon@artsuwon.or.kr">artsuwon@artsuwon.or.kr</a><br>Copyrightⓒ2015 Suwon Philhamonic Orchestra &amp; Suwon City Chorale &amp; Suwon Civic Troupe<br><br></span></div>
                </div>
            </footer>
        </div><a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a>
    </div>
    <script src="/assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="/assets/js/theme.js"></script>
    <script id="bs-live-reload" data-sseport="12383" data-lastchange="1640435560295" src="/js/livereload.js"></script>

	<script>
		$('.btn btn-primary active').click(function(){
			return window.confirm("이 회원을 탈퇴처리 하겠습니까?");
		});
	
	</script>



</body>
</html>