<%@page import="kr.or.artsuwon.board.model.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <link rel="stylesheet" href="/assets/css/boardFrame.css">
     <link rel="stylesheet" href="/assets/style/contentframe.css">
<!-- boostrap5 라이브러리-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<!-- Font Awesome CSS -->
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>

<!-- jQuery 라이브러리 -->
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<title>동영상 게시판</title>
</head>



<body>


<%
	// 페이징 처리되어 넘어온 데이터를 가져와야 함
	HashMap<String,Object> pageDataMap = (HashMap<String,Object>)request.getAttribute("pageDataMap");
	
	ArrayList<Board> list = (ArrayList<Board>)pageDataMap.get("list");
	String pageNavi = (String)pageDataMap.get("pageNavi");
	int currentPage = (int)request.getAttribute("currentPage");

	String keyword = (String)request.getAttribute("keyword");
	
%>


<!-- Local Navi Bar-->
   <content>
        <div class="nav_div">
            <nav id="LNB" class="LNB">
                <ul class="nav-menu">
                    <li class="menu-item menu-img">
                        <a href=""><img src="/assets/icon/home.svg" alt=""></a>
                    </li>
                    <li class="menu-item">
                        <a href=""><strong>공연/예매</strong></a>
                        <ul class="nav-submenu">
                            <li class="submenu-item"><a href=""><strong>공연/예매</strong></a></li>
                            <li class="submenu-item"><a href="">교육</a></li>
                            <li class="submenu-item"><a href="">오케스트라</a></li>
                            <li class="submenu-item"><a href="">시향소식</a></li>
                            <li class="submenu-item"><a href="">기관소개</a></li>
                        </ul>
                    </li>
                    <li class="menu-item">
                        <a href=""><strong>공연일정</strong></a>
                        <ul class="nav-submenu">
                            <li class="submenu-item"><a href=""><strong>공연일정</strong></a></li>
                            <li class="submenu-item"><a href="">공연소개</a></li>
                            <li class="submenu-item"><a href="">예매안내</a></li>
                        </ul>
                    </li>
                    <li class="menu-item hide">
                        <a href="">test</a>
                        <ul class="nav-submenu">
                            <li class="submenu-item"><a href=""><strong>공연일정</strong></a></li>
                            <li class="submenu-item"><a href="">공연소개</a></li>
                            <li class="submenu-item"><a href="">예매안내</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>
        <div class="wrapper">

        </div>
       
<!-- 게시판 -->
<article class="common_wrap">
     <h3 class="title">동영상 게시판</h3>


       
<!-- 검색창 -->
<form class="search_form" action="/board/VideoPostSearch.do" method="get">
	<div class="search_box">
		<input class="search_content" type="text" name="keyword" placeholder=" 검색어를 입력하세요."/><button class="search_button" type="submit"><img src="/assets/icon/search_button.png" style="width:20px"></button>
	</div>
</form>

<div style="text-align:center">
<%if(keyword != null){ %>
	[<%=keyword %>]로 검색한결과
<%} %>
</div>





<!-- 게시판 내용 -->

	<!-- 테이블 내용 -->
     <table class="table table-hover" id="tbl" >
            <thead class="table_head">   
                   <tr>
                        <th style="width:10%">번호</th>
                        <th style="width:80%">제목</th>
                        <th style="width:10%">등록일</th>
                   </tr>
			</thead>
              
            <tbody>
				<%for(Board board : list) {%>
				<tr style="height:60px">
					<td><%=board.getVideoNo() %></td>
					<td><a href="/board/VideoSelectContent.do?boardNo=<%=board.getVideoNo()%>&currentPage=<%=currentPage%>"><%=board.getVideoTitle() %></a></td>
					<td><%=board.getRegDate() %></td>
				</tr>
            </tbody>
                <%} %>
      </table>


<!-- 페이지 네비 -->
	
			
			<div class="page_wrap">
				   <div class="page_nation">
				      
				    	 <%=pageNavi %>
				      
				   </div>
			</div>
			

	</article>
    </content>
        

</body>







<!-- footer -->
<footer>

</footer>
</html>