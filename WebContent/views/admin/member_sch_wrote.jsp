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
	<title>회원 작성글 조회</title>
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
#content2 {
	flex: 1 0 auto;
}

</style>
</head>

<body id="page-top">


	<%
		//페이징 처리되어 넘어온 데이터를 가져와야 함

		HashMap<String, Object> pageDataMap = (HashMap<String, Object>) request.getAttribute("pageDataMap");

		ArrayList<csBoard> list = (ArrayList<csBoard>) pageDataMap.get("list");
		String pageNavi = (String)pageDataMap.get("pageNavi");
		int currentPage = (int)request.getAttribute("currentPage");

		String keyword = (String) request.getAttribute("keyword");
	%>




	<div id="wrapper">

		 <!--사이드 네비바 include-->
        <%@include file="/views/adminCommon/yj_side_navi.jsp" %>
        		
       
		<div class="d-flex flex-column" id="content-wrapper">
			<div id="content1">

				<!--상단 네비바 include-->
        		<%@include file="/views/adminCommon/top_navi.jsp" %>

				<div class="content-div">
					

						<!-- content 시작 -->


						<div class="container-fluid">
							<div class="card shadow"></div>
						</div>
					</div>


					<div id="content2">

						<div class="container-fluid">
							<!-- <h3 class="text-dark mb-4">회원관리</h3> -->
							<div class="card shadow" width="900px">
								<div class="card-header py-3">
									<p class="text-primary m-0 fw-bold">작성글 관리</p>
								</div>
								<div class="card-body" style="border-radius: 5px;">
									<div class="row">
										<div class="col-md-6 text-nowrap">
											
										</div>
										
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

												<%
													for (csBoard b : list) {
												%>
											<tr>
												<td><img class="rounded-circle me-2" width="30"
													height="30" src="/assets/images/memberPicture.jpg" /><%=b.getCsWriter()%></td>

												
												<td><%=b.getCsTitle()%></td>
												<td>CS</td>
												<td><%=b.getCsDate()%></td>
												
											</tr>

												<%
													}
												%>
										</tbody>

									</table>
								</div>
								<div class="row">
									<div class="col-md-6 align-self-center">
										<!-- <p id="dataTable_info" class="dataTables_info" role="status"
											aria-live="polite">Showing 1 to 10 of 27</p> -->
									</div>
									<div class="col-md-6">
										<nav
											class="d-lg-flex justify-content-lg-end dataTables_paginate paging_simple_numbers">
										<ul class="pagination">
											<!-- <li class="page-item disabled"><a class="page-link"
												href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
											<li class="page-item active"><a class="page-link"
												href="#">1</a></li>
											<li class="page-item"><a class="page-link" href="#">2</a></li>
											<li class="page-item"><a class="page-link" href="#">3</a></li>
											<li class="page-item"><a class="page-link" href="#"
												aria-label="Next"><span aria-hidden="true">»</span></a></li> -->
												<%=pageNavi %>
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
				<span><br> <br>webmaster :&nbsp;<a
					href="mailto:artsuwon@artsuwon.or.kr">artsuwon@artsuwon.or.kr</a><br>Copyrightⓒ2015
					Suwon Philhamonic Orchestra &amp; Suwon City Chorale &amp; Suwon
					Civic Troupe<br> <br></span>
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