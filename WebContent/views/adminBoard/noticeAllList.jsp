<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<<<<<<< HEAD
<%@page import="vo.Notice"%>
<%@page import="vo.Admin"%>
=======
<%@ page import="kr.or.artsuwon.adminMngm.model.vo.Admin" %>
<%@ page import="kr.or.artsuwon.adminBoard.model.vo.Notice" %>
>>>>>>> 53fdcb91b1146cc383c8528d72825908e003e2a7


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Table - Brand</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/untitled.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/fonts/fontawesome-all.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/fonts/font-awesome.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/fonts/fontawesome5-overrides.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
</head>

<body id="page-top">
	<%
		ArrayList<Admin> adminList = (ArrayList<Admin>) request.getAttribute("adminList");
	%>
	<%
		//페이징처리되어 넘어온 데이터를 가져와야한다.

		HashMap<String, Object> pageDataMap = (HashMap<String, Object>) request.getAttribute("pageDataMap");

		ArrayList<Notice> list = (ArrayList<Notice>) pageDataMap.get("list");
		String pageNavi = (String) pageDataMap.get("pageNavi");
		int currentPage = (int) request.getAttribute("currentPage");

		String keyword = (String) request.getAttribute("keyword");
	%>


	<div id="wrapper">
		<!--사이드 네비바 include-->
		<%@include file="/views/admin/side_navi.jsp"%>

		<!-- 컨텐츠 영역 -->
		<div class="d-flex flex-column" id="content-wrapper">
			<div id="content">
				<!--상단 네비바 include-->
				<%@include file="/views/admin/top_navi.jsp"%>



				<body id="page-top">
					<div id="wrapper">
						<div class="d-flex flex-column" id="content-wrapper">
							<div id="content">
								<div class="container-fluid">
									<div class="card shadow"
										style="margin: 0; margin-bottom: 0px; padding-bottom: 200px;">
										<div class="card-header py-2">
											<div class="btn-group" role="group"
												style="margin-left: 10px; height: 36px; border-right-style: none; border-right-color: rgb(133, 135, 150); margin-bottom: 0px; padding-bottom: 0px;"></div>
											<span
												style="margin-right: 0px; margin-left: 44%; font-size: 25px; font-weight: bold; color: rgb(0, 0, 0);">공지사항</span>
										</div>
										<div class="col-xxl-1">
											<div id="page" class="page"></div>
										</div>
										<div class="btn-toolbar">
											<div class="btn-group" role="group"></div>
											<div class="btn-group" role="group"></div>
										</div>






										<div>
											<div class="btn-group" role="group"
												style="margin-right: 0px; margin-left: 90%; margin-top: 3%">
												<button class="btn btn-primary" id="deleteBtn" type="button"
													style="width: 70px; height: 35px; color: #000000; background: rgb(255, 255, 255); border-style: solid; 
													border-top-style: solid; border-top-color: rgb(126, 126, 126); border-right-style: solid; border-right-color: rgb(126, 126, 126); border-bottom-style: solid; border-bottom-color: rgb(126, 126, 126); 
													border-left-style: solid; border-left-color: rgb(126, 126, 126);">삭제</button>
												<button class="btn btn-primary"
													onclick="location.replace('/views/board/NoticeWriteForm.jsp');"
													type="button"
													style="width: 75px; height: 35px; color: #000000; background: rgb(255, 255, 255); border-style: solid; border-top-style: solid; border-top-color: rgb(126, 126, 126); border-right-style: 
													solid; border-right-color: rgb(126, 126, 126); border-bottom-style: solid; border-bottom-color: rgb(126, 126, 126); border-left-style: 
													solid; border-left-color: rgb(126, 126, 126);">글쓰기</button>
											</div>
										</div>
										<div>





											<div class="card-body" style="width: 926; height: 826.59;">
												<div>
													<div class="table-responsive">
														<table class="table">
															<thead>
																<tr style="width: 700px;">
																	<th style="width: 100px;">No</th>
																	<th style="width: 50px; border-top-style: solid;"><input
																		type="checkbox" /></th>
																	<th class="boardName"
																		style="text-align: center; width: 70%; border-top-style: solid; border-top-color: rgb(0, 0, 0); 
																		padding-left: 140px;">제목</th>
																	<th style="width: 80px;">조회수</th>
																	<th
																		style="text-align: center; border-top-style: solid; border-top-color: rgb(0, 0, 0); width: 200px;">등록</th>
																	<th style="text-align: center;""width: 80px;" >중요/삭제</th>
																</tr>




															</thead>
															<tbody>
																<tr></tr>
																<tr>
																	<%
																		for (Notice notice : list) {
																	%>
																
																<tr>
																	<td><%=notice.getNoticeNo()%></td>
																	<td><input type="checkbox" /></td>
																	<td style="text-align: center; padding-left: 140px;"><a
																		href="/notice/noticeOneSelectContent.do?noticeNo=<%=notice.getNoticeNo()%>"><%=notice.getNoticeTitle()%></a></td>
																	<td style="text-align: center;"><%=notice.getViewCount()%></td>
																	<td style="text-align: center;"><%=notice.getRegDate()%></td>
																	<td><div class="btn-group" role="group"
																			style="width: 110px;"
																			"height: 36px;border-right-style:
																			none;border-right-color:rgb(130, 135, 130);" "text-align:center;">
																			<button class="btn btn-light btn-sm" type="button"
																				style="height: 36px; border-style: solid; border-color: rgb(130, 130, 130); border-style: none;">
																				<i class="fa fa-star"
																					style="color: rgb(130, 130, 130);"></i>
																			</button>
																			<button class="btn btn-sm" id="deleteBtn"
																				type="button" style="color: rgb(130, 135, 130);"
																				"height: 36px;border-style: solid;border-color:
																				rgb(130,130,130);border-style:none;">
																				<i class="fas fa-trash"
																					style="color: rgb(130, 130, 130);"></i>
																			</button>
																		</div></td>
																</tr>

																<%
																	}
																%>
															</tbody>
														</table>
													</div>
												</div>


												</script>



												<style>
												.page-item.active .page-link {
													z-index: 3;
													color: #fff;
													background-color: #B0B0B0;
													border-color: #B0B0B0;
													}
												</style>





												<script src="/js/jquery.twbsPagination.js"></script>

												<script src="/js/bootstrap.min.js"></script>
												<link rel="stylesheet" href="/css/bootstrap.min.css" />


												<div class="pagination-wrapper clearfix">
													<nav
														style="text-align: left; margin-top: 5px; margin-left: 85%;">
														<ul class="pagination float--right" id="pages">
															<%=pageNavi%>
														</ul>
													</nav>
												</div>







												<div style="margin-bottom: 24px; padding-right: 0px;">
												
												
												<form action="/board/noticePostSearch.do" method="get"> 
												
												<div style="margin-bottom: -26px;padding-right: 0px;margin-left: 42%;">
		<select class="form-select-sm" name="type" style="width: 100px;height: 30px;margin-right: 13px;">
         <option value="noticeTitle" selected>제목</option>
        <option value="noticeContent" selected>내용</option>
        <option value="noticeTiCo" selected>제목+내용</option>
    </select><input class="form-control-sm" type="text" name="keyword" style="width: 175px;margin: 69px 0px 0px;margin-right: 0;margin-top: 30px;padding-bottom: 0px;height: 38px;border-top-style: none;border-right-style: none;border-bottom-style: 
    solid;border-bottom-color: rgb(0,0,0);border-left-style: none;margin-left: px;" placeholder="검색어를 입력하세요" /><button class="btn" type="button" style="margin-left: 3px;border-right-style: none;font-size: 15px;margin-top: 37px;padding-bottom: 35px;
    padding-left: 3px;"><i class="fa fa-remove"></i></button>
    <button class="btn" value="검색" type="submit" style="margin-left: 3px;border-right-style: none;font-size: 15px;margin-top: 37px;padding-bottom: 35px;padding-left: 3px;"><i class="fa fa-search"></i></button></div>
												
										
													</form>
												</div>
											</div>
										</div>
									</div>
									<footer class="bg-white sticky-footer">
										<div class="container my-auto">
											<div class="text-center my-auto copyright">
												<span><br>
												<br>webmaster :&nbsp;<a
													href="mailto:artsuwon@artsuwon.or.kr">artsuwon@artsuwon.or.kr</a><br>Copyrightⓒ2015
													Suwon Philhamonic Orchestra &amp; Suwon City Chorale &amp;
													Suwon Civic Troupe<br>
												<br></span>
											</div>
										</div>
									</footer>
								</div>
								<a class="border rounded d-inline scroll-to-top"
									href="#page-top"><i class="fas fa-angle-up"></i></a>
							</div>
							<script
								src="//<%=request.getContextPath()%>/assets/js/bootstrap.min.js"></script>
							<script src="<%=request.getContextPath()%>/assets/js/theme.js"></script>
				</body>
</html>