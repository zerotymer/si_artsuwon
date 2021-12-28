<%@page import="kr.or.artsuwon.csBoard.vo.csBoard"%>
<%@page import="java.util.HashMap"%>
<%@page import="kr.or.artsuwon.member.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">





<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Table - Brand</title>
<link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
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
	//페이징 처리되어 넘어온 데이터를 가져와야 함
	
	HashMap<String,Object> pageDataMap = (HashMap<String,Object>)request.getAttribute("pageDataMap");

	ArrayList<csBoard> list = (ArrayList<csBoard>)pageDataMap.get("list");
	String pageNavi = (String)pageDataMap.get("pageNavi");
	int currentPage = (int)request.getAttribute("currentPage");

	String keyword = (String)request.getAttribute("keyword");
%>
			
			


	<div id="wrapper">

		<nav
			class="navbar navbar-dark align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0"
			style="background: rgb(255,255,255);color: #000000;font-size: 15px;border-style: none;">

		</nav>
		<div class="d-flex flex-column" id="content-wrapper">
			<div id="content1">

				<!--상단 네비바 include1234-->
				<%@include file="/views/adminCommon/top_navi.jsp"%>

				<div class="content-div">
					<!--  시작 -->
					<div>
						<div class="container-fluid d-flex flex-column p-0">
							<a
								class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0"
								href="#" style="background: rgb(162, 155, 145);">
								<div class="sidebar-brand-icon rotate-n-15"></div>
								<div class="sidebar-brand-text mx-3">
									<span style="color: rgb(0, 0, 0);">ADMIN PAGE</span>
								</div>
							</a>
							<hr class="sidebar-divider my-0">
							<ul class="navbar-nav text-light" id="accordionSidebar">
								<li class="nav-item"></li>
								<li class="nav-item"><a class="nav-link disabled active"
									href="table.html"
									style="text-align: center; background: #f7f7f7;"><span
										style="color: rgb(0, 0, 0);">통계&nbsp;관리</span></a>
									<div class="nav-item dropdown show visible"
										style="text-align: center;">
										<a class="active" aria-expanded="true"
											data-bs-toggle="dropdown" href="#"
											style="color: rgb(0, 0, 0); border-bottom-style: solid; border-bottom-color: rgb(225, 216, 212); font-size: 13px; font-weight: bold;">공연
											관리&nbsp;</a>
										<div class="dropdown-menu dropdown-menu-start show">
											<a class="dropdown-item" href="#"
												style="background: rgb(247, 247, 247);">공지사항</a><a
												class="dropdown-item" href="#"
												style="background: rgba(0, 0, 0, 0.03);">뉴스&amp;이슈</a>
										</div>
									</div>
									<div class="nav-item dropdown show visible"
										style="text-align: center; background: #ffffff;">
										<a aria-expanded="true" data-bs-toggle="dropdown" href="#"
											style="color: rgb(0, 0, 0); border-bottom-style: solid; border-bottom-color: rgb(225, 216, 212); font-size: 13px; font-weight: bold;">회원관리</a>
										<div class="dropdown-menu dropdown-menu-start show">
											<a class="dropdown-item" href="#"
												style="background: rgb(247, 247, 247);"></a><a
												class="dropdown-item" href="#"
												style="background: rgb(247, 247, 247);">전체 사용자 관리</a>
										</div>
									</div>
									<div class="nav-item dropdown show visible"
										style="text-align: center; font-size: 13px;">
										<a aria-expanded="true" data-bs-toggle="dropdown" href="#"
											style="color: rgb(0, 0, 0); border-bottom-style: solid; border-bottom-color: rgb(225, 216, 212); font-weight: bold;">게시판
											관리&nbsp;</a>
										<div class="dropdown-menu dropdown-menu-start show">
											<a class="dropdown-item" href="#"
												style="background: #f7f7f7;">공지사항</a><a
												class="dropdown-item" href="#" style="background: #f7f7f7;">뉴스&amp;이슈</a><a
												class="dropdown-item" href="#" style="background: #f7f7f7;">사진
												갤러리</a><a class="dropdown-item" href="#"
												style="background: #f7f7f7;">동영상 갤러리</a><a
												class="dropdown-item" href="#" style="background: #f7f7f7;">1
												:1 문의게시판</a>
										</div>
									</div></li>
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

					<!-- content 시작 -->

					<div id="content2" >
						
						<div class="container-fluid">
							<h3 class="text-dark mb-4">회원관리</h3>
							<div class="card shadow" >
								<div class="card-header py-3" >
									<p class="text-primary m-0 fw-bold">작성글 관리</p>
								</div>
								<div class="card-body" style="border-radius: 5px;">
									<div class="row">
										<div class="col-md-6 text-nowrap">
											<div id="dataTable_length" class="dataTables_length"
												aria-controls="dataTable">
												<label class="form-label">Show <select
													class="d-inline-block form-select form-select-sm">
														<option value="10" selected>10</option>
														<option value="25">25</option>
														<option value="50">50</option>
														<option value="100">100</option>
												</select></label>
											</div>
										</div>
										<!-- <div class="col-md-6">
											<div id="dataTable_filter"
												class="text-md-end dataTables_filter"
												style="border-radius: 5px;">
												<select style="height: 31px; border-radius: 3.2px;">
													<optgroup label="This is a group">
														<option value="12" selected>This is item 1</option>
														<option value="13">This is item 2</option>
														<option value="14">This is item 3</option>
													</optgroup>
												</select><label class="form-label"><input
													class="form-control form-control-sm" type="search"
													aria-controls="dataTable" placeholder="Search" /></label>
											</div> -->
										</div>
									</div>
									<div id="dataTable" class="table-responsive table mt-2"
										role="grid" aria-describedby="dataTable_info">
										<table id="dataTable" class="table my-0">
											<thead>
												<tr>
													<th>검색된 회원</th>
													<th>글제목</th>
													<th>게시판</th>
													<th>작성일</th>
												</tr>
											</thead>
											<tbody>
											
												
												<tr>
													<td><img class="rounded-circle me-2" width="30"
														height="30" src="/assets/images/memberPicture.jpg" /><%=keyword %></td>
													
													<%for(csBoard b : list){ %>
													<td><%=b.getCsTitle() %></td>
													<td>CS</td>
													<td><%=b.getCsDate() %></td>
													<%} %>
												</tr>
												
												<!-- <tr>
													<td></td>
													<td>그여자의 소설 감상평</td>
													<td>공연감상평<br /></td>
													<td>2021/04/15<br /></td>
												</tr>
												<tr>
													<td></td>
													<td>온라인 공연 감상 후기</td>
													<td>공연감상평</td>
													<td>2020/10/07</td>
												</tr>
												<tr>
													<td></td>
													<td>스쿨 클래식! 완전 좋아요!^^</td>
													<td>공연감상평</td>
													<td>2018/05/31<br /></td>
												</tr>
												<tr>
													<td></td>
													<td>안녕하세요 수원시립교향악단에 문의드립니다.</td>
													<td>관객제안 </td>
													<td>2020/08/05<br /></td>
												</tr>
												<tr>
													<td></td>
													<td>어제 클라리넷 앵콜곡 문의</td>
													<td>관객제안</td>
													<td>2020/07/01<br /></td>
												</tr>
												<tr>
													<td></td>
													<td></td>
													<td></td>
													<td><br /></td>
												</tr>
												<tr>
													<td></td>
													<td></td>
													<td></td>
													<td><br /></td>
												</tr>
												<tr>
													<td></td>
													<td></td>
													<td></td>
													<td><br /></td>
												</tr>
												<tr>
													<td></td>
													<td></td>
													<td></td>
													<td><br /></td>
												</tr> -->
											</tbody>
											
										</table>
									</div>
									<div class="row">
										<div class="col-md-6 align-self-center">
											<p id="dataTable_info" class="dataTables_info" role="status"
												aria-live="polite">Showing 1 to 10 of 27</p>
										</div>
										<div class="col-md-6">
											<nav
												class="d-lg-flex justify-content-lg-end dataTables_paginate paging_simple_numbers">
											<ul class="pagination">
												<li class="page-item disabled"><a class="page-link"
													href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
												<li class="page-item active"><a class="page-link"
													href="#">1</a></li>
												<li class="page-item"><a class="page-link" href="#">2</a></li>
												<li class="page-item"><a class="page-link" href="#">3</a></li>
												<li class="page-item"><a class="page-link" href="#"
													aria-label="Next"><span aria-hidden="true">»</span></a></li>
											</ul>
											</nav>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>


					<!-- content 끝 -->

				</div>
			</div>

			<footer class="bg-white sticky-footer"> <nav
				class="d-lg-flex justify-content-lg-end dataTables_paginate paging_simple_numbers">
			<ul class="pagination"></ul>
			</nav>
			<div class="container my-auto">
				<div class="text-center my-auto copyright">
					<span><br>
					<br>webmaster :&nbsp;<a href="mailto:artsuwon@artsuwon.or.kr">artsuwon@artsuwon.or.kr</a><br>Copyrightⓒ2015
						Suwon Philhamonic Orchestra &amp; Suwon City Chorale &amp; Suwon
						Civic Troupe<br>
					<br></span>
				</div>
			</div>
			</footer>
		</div>
		<a class="border rounded d-inline scroll-to-top" href="#page-top"><i
			class="fas fa-angle-up"></i></a>
	</div>
	<script src="/assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="/assets/js/theme.js"></script>
	<script id="bs-live-reload" data-sseport="12383"
		data-lastchange="1640435560295" src="/js/livereload.js"></script>



</body>
</html>