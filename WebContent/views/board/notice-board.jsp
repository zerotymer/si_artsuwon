<%@page import="kr.or.artsuwon.board.model.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <title>공지사항</title>
    <link rel="stylesheet" type="text/css" href="/assets/css/boardFrame.css">
     <link rel="stylesheet" href="/assets/style/contentframe.css">
<!-- boostrap5 라이브러리-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<!-- jQuery 라이브러리 -->
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<title>공지사항</title>
</head>

<body>


   <content>
<!-- Local Navi Bar-->
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
        </content>
<!-- Board Content -->
 <div class="wrapper">
        <div class="title">
            <b>공지사항</b>
        </div>
      
        <div class="search">
            <input type="text" name="searchKeyword" id="searchKeyword" placeholder="검색어를 입력하세요." 
            title="공지사항명  검색"><button type="submit" class="searchform_submit" title="검색" onclick="fnSearchButton">검색</button>
        </div>

        <div class="table_box">
           	 테이블박스
        </div>

        <div class="default_info">
           <div class="align">
                <button type="button" class="on">최신순</button>
                <button type="button">등록순</button>
            </div>
        </div>

        <div id="notice-board">
           
            <table class="table table-hover">
                   <tr>
                        <th style="width:10%">번호</th>
                        <th style="width:80%">제목</th>
                        <th style="width:10%">등록일</th>
                   </tr>

              
                <tbody>
                   <tr>
                        <td>10</td>
                        <td>게시글 몇글자까요</td>
                        <td>2021.12.22</td>
                    </tr>
                    <tr>
                        <td>20</td>
                        <td>게시글 몇글자까요</td>
                        <td>2021.12.22</td>
                    </tr>
                    <tr>
                        <td>20</td>
                        <td>게시글 몇글까요</td>
                        <td>2021.12.22</td>
                    </tr>
                    <tr>
                        <td>20</td>
                        <td>게시글 몇글자까요</td>
                        <td>2021.12.22</td>
                    </tr>   
                </tbody>
            </table>
        </div>
        
<!-- 페이지 네비 -->
        <div class="board-page">
            <ul class="pagination">
               <li><a href="#">1</a></li>
               <li><a href="#">2</a></li>
               <li><a href="#">3</a></li>
               <li><a href="#">4</a></li>     
            </ul>
        </div>
        
    </div>


</body>
<!-- footer -->
<footer>

 <footer>
</html>