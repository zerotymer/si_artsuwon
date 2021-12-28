<%@page import="kr.or.artsuwon.board.model.vo.Board"%>
<%@page import="kr.or.artsuwon.board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/assets/css/boardFrame.css">
<link rel="stylesheet" href="/assets/style/contentframe.css">
<!-- boostrap5 라이브러리-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>

<!-- Font Awesome CSS -->
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>

<!-- jQuery 라이브러리 -->
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
<title>공지사항 글작성</title>
</head>
<body>


<content>
		<div class="nav_div">
		<nav id="LNB" class="LNB">
		<ul class="nav-menu">
			<li class="menu-item menu-img"><a href=""><img
					src="/assets/icon/home.svg" alt=""></a></li>
			<li class="menu-item"><a href=""><strong>공연/예매</strong></a>
				<ul class="nav-submenu">
					<li class="submenu-item"><a href=""><strong>공연/예매</strong></a></li>
					<li class="submenu-item"><a href="">교육</a></li>
					<li class="submenu-item"><a href="">오케스트라</a></li>
					<li class="submenu-item"><a href="">시향소식</a></li>
					<li class="submenu-item"><a href="">기관소개</a></li>
				</ul></li>
			<li class="menu-item"><a href=""><strong>공연일정</strong></a>
				<ul class="nav-submenu">
					<li class="submenu-item"><a href=""><strong>공연일정</strong></a></li>
					<li class="submenu-item"><a href="">공연소개</a></li>
					<li class="submenu-item"><a href="">예매안내</a></li>
				</ul></li>
			<li class="menu-item hide"><a href="">test</a>
				<ul class="nav-submenu">
					<li class="submenu-item"><a href=""><strong>공연일정</strong></a></li>
					<li class="submenu-item"><a href="">공연소개</a></li>
					<li class="submenu-item"><a href="">예매안내</a></li>
				</ul></li>
		</ul>
		</nav>
		</div>
</content>

<!-- 게시판 헤더 -->
<article class="common_wrap">
	<div class="board_view_box">
		<form action="/board/noticeWrite.do" method="post">
		<div class="view_header">
			<span class="cate"> 공지사항 </span><br>
			
			<textarea rows="1" cols="50" style="resize:none" placeholder="제목을 작성하세요" name="subject"></textarea>
		</div>
		
		<!-- 파일첨부 -->
		<div class="file_link">파일첨부</div>
		
			<!-- 게시판 내용 -->
		<article class="view_content"> 

			
				<textarea placeholder="내용을 작성하세요" name="content" class="content_area"></textarea>
				<div style="text-align:center; margin-top:15px">
					<span>
						<input type="submit" value="작성" class="confirm"/>
						<input type="reset" value="초기화" class="reset" />
					</span>
				</div>
		</form>
	
<!-- 풋터 -->
		<div class="view_footer">
			<div class="btn_box">
				
					
				
				<input type="button" class="list" value="목록" onclick="location.replace('/board/NoticeAllSelect.do')" style="background-color:transparent"/>
			</div>
		</div>
	</div>
			
		

</article>


</body>
</html>






