<%@page import="kr.or.artsuwon.member.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



	
	<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Table - Brand</title>
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="/fonts/fontawesome-all.min.css">
    <link rel="stylesheet" href="/untitled.css">
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
    	
        <nav class="navbar navbar-dark align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0" style="background: rgb(255,255,255);color: #000000;font-size: 15px;border-style: none;">
            
        </nav>
        <div class="d-flex flex-column" id="content-wrapper">
            <div id="content">
        		
        		<!--상단 네비바 include1234-->
				<%@include file="/views/adminCommon/top_navi.jsp"%>
        		
        		<div class="content-div">
        		<!--  시작 -->
        		<div>
        		<div class="container-fluid d-flex flex-column p-0"><a class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0" href="#" style="background: rgb(162,155,145);">
                    <div class="sidebar-brand-icon rotate-n-15"></div>
                    <div class="sidebar-brand-text mx-3"><span style="color: rgb(0,0,0);">ADMIN PAGE</span></div>
                </a>
                <hr class="sidebar-divider my-0">
                <ul class="navbar-nav text-light" id="accordionSidebar">
                    <li class="nav-item"></li>
                    <li class="nav-item"><a class="nav-link disabled active" href="table.html" style="text-align: center;background: #f7f7f7;"><span style="color: rgb(0,0,0);">통계&nbsp;관리</span></a>
                        <div class="nav-item dropdown show visible" style="text-align: center;"><a class="active" aria-expanded="true" data-bs-toggle="dropdown" href="#" style="color: rgb(0,0,0);border-bottom-style: solid;border-bottom-color: rgb(225,216,212);font-size: 13px;font-weight: bold;">공연 관리&nbsp;</a>
                            <div class="dropdown-menu dropdown-menu-start show"><a class="dropdown-item" href="#" style="background: rgb(247,247,247);">공지사항</a><a class="dropdown-item" href="#" style="background: rgba(0,0,0,0.03);">뉴스&amp;이슈</a></div>
                        </div>
                        <div class="nav-item dropdown show visible" style="text-align: center;background: #ffffff;"><a aria-expanded="true" data-bs-toggle="dropdown" href="#" style="color: rgb(0,0,0);border-bottom-style: solid;border-bottom-color: rgb(225,216,212);font-size: 13px;font-weight: bold;">회원관리</a>
                            <div class="dropdown-menu dropdown-menu-start show"><a class="dropdown-item" href="#" style="background: rgb(247,247,247);"></a><a class="dropdown-item" href="#" style="background: rgb(247,247,247);">전체 사용자 관리</a></div>
                        </div>
                        <div class="nav-item dropdown show visible" style="text-align: center;font-size: 13px;"><a aria-expanded="true" data-bs-toggle="dropdown" href="#" style="color: rgb(0,0,0);border-bottom-style: solid;border-bottom-color: rgb(225,216,212);font-weight: bold;">게시판 관리&nbsp;</a>
                            <div class="dropdown-menu dropdown-menu-start show"><a class="dropdown-item" href="#" style="background: #f7f7f7;">공지사항</a><a class="dropdown-item" href="#" style="background: #f7f7f7;">뉴스&amp;이슈</a><a class="dropdown-item" href="#" style="background: #f7f7f7;">사진 갤러리</a><a class="dropdown-item" href="#" style="background: #f7f7f7;">동영상 갤러리</a><a class="dropdown-item" href="#" style="background: #f7f7f7;">1 :1 문의게시판</a></div>
                        </div>
                    </li>
                    <li class="nav-item"></li>
                </ul>
                <div class="collapse navbar-collapse"></div>
                <div class="text-center d-none d-md-inline"></div>
            </div>
            <div class="container-fluid">
                    <div class="card shadow"></div>
                </div>
            </div>
        		<!--  끝 -->
        		
        		
        		
        		<div class="container-fluid">
    <h3 class="text-dark mb-4">회원관리</h3>
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
                            <th style="color: rgb(133, 135, 150);width: 300px;">닉네임(ID)</th>
                            <th style="color: rgb(133, 135, 150);width: 200px;">가입일</th>
                            <th style="width: 100px;text-align: center;">게시글수</th>
                            <th style="width: 300px;text-align: center;"><button class="btn btn-primary" type="button" style="height: 30px;">강제탈퇴</button><a class="btn btn-primary" role="button" href="mail2.html" style="height: 30px;">메일</a></th>
                        </tr>
                    </thead>
                    <tbody>
                    
                    	<%for(Member m : list) { %>
                        <tr>
                            <td><input type="checkbox" /></td>
                            <td><img class="rounded-circle me-2" width="30" height="30" src="/assets/images/memberPicture.jpg" /><%=m.getMemberName() %> (<%=m.getMemberId() %>)</td>
                            <td style="width: 200px;"><%=m.getEnrollDate() %></td>
                            <td style="text-align: center;"><a href="/views/admin/member_sch_wrote.jsp">5</a></td>
                            <td style="width: 200px;text-align: center;"><button class="btn btn-primary active" type="button" style="height: 30px;" href="/admin/memberEndYNChange.do?memberNo=<%=m.getMemberNo() %>&memberStatus=<%=m.getMemberStatus() %>">강제탈퇴</button><a class="btn btn-primary" role="button" href="mail2.html" style="height: 30px;">메일</a></td>
                        </tr>
                        <%} %>
                        <!-- <tr>
                            <td><input type="checkbox" /></td>
                            <td><img class="rounded-circle me-2" width="30" height="30" src="avatars/user_f.jpg" />오연주 (oyj123)</td>
                            <td>2018/01/05<br /></td>
                            <td style="text-align: center;"><a href="#">20</a><br /></td>
                            <td style="width: 200px;text-align: center;"><button class="btn btn-primary" type="button" style="height: 30px;">강제탈퇴</button><a class="btn btn-primary" role="button" href="mail2.html" style="height: 30px;">메일</a></td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" /></td>
                            <td><img src="user_m.jpg" style="width: 30px;" /> 신현진 (shj123)</td>
                            <td>2018/01/05<br /></td>
                            <td style="text-align: center;"><a href="#">2</a></td>
                            <td style="width: 200px;text-align: center;"><button class="btn btn-primary" type="button" style="height: 30px;">강제탈퇴</button><a class="btn btn-primary" role="button" href="mail2.html" style="height: 30px;">메일</a></td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" /></td>
                            <td><img class="rounded-circle me-2" width="30" height="30" src="avatars/user_f.jpg" />이다원 (ldw123)</td>
                            <td>2018/01/05<br /></td>
                            <td style="text-align: center;"><a href="#">31</a><br /></td>
                            <td style="width: 200px;text-align: center;"><button class="btn btn-primary" type="button" style="height: 30px;">강제탈퇴</button><a class="btn btn-primary" role="button" href="mail2.html" style="height: 30px;">메일</a></td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" /></td>
                            <td><img src="user_m.jpg" style="width: 30px;" /> 김동현 (kdh123)</td>
                            <td>2018/01/05<br /></td>
                            <td style="text-align: center;"><a href="#">5</a><br /></td>
                            <td style="width: 200px;text-align: center;"><button class="btn btn-primary" type="button" style="height: 30px;">강제탈퇴</button><a class="btn btn-primary" role="button" href="mail2.html" style="height: 30px;">메일</a></td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" /></td>
                            <td><img class="rounded-circle me-2" width="30" height="30" src="avatars/user_f.jpg" />김영주 (kyj123)</td>
                            <td>2018/01/05<br /></td>
                            <td style="text-align: center;"><a href="#">1</a><br /></td>
                            <td style="width: 200px;text-align: center;"><button class="btn btn-primary" type="button" style="height: 30px;">강제탈퇴</button><a class="btn btn-primary" role="button" href="mail2.html" style="height: 30px;">메일</a></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td><br /></td>
                            <td><br /></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td><br /></td>
                            <td><br /></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td><br /></td>
                            <td><br /></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td><br /></td>
                        </tr> -->
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
                    <p id="dataTable_info" class="dataTables_info" role="status" aria-live="polite">Showing 1 to 10 of 6</p>
                </div>
                <div class="col-md-6">
                    <nav class="d-lg-flex justify-content-lg-end dataTables_paginate paging_simple_numbers">
                        <ul class="pagination">
                            <li class="page-item disabled"><a class="page-link" href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
                            <li class="page-item active"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item"><a class="page-link" href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
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