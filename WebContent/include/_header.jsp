<%@ page import="kr.or.artsuwon.member.model.vo.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<link rel="stylesheet" type="text/css" href="/assets/style/header.css" />

<!-- Header -->
<div class="header-noti">
  <!-- 공지사항 -->
  공지사항 작성란
</div>
<!-- Header Navi-->
<div class="header">
  <div class="header-nav">
    <div class="header-logo">
      <a href="/">
        <img
        style="width: 60px; filter: invert(100%)"
        src="/assets/images/logo.jpg" />
      </a>
    </div>
    <nav id="gnb" class="gnb">
      <ul>
        <li class="menu">
          <a href="">공연/예매</a>
          <ul>
            <li class="submenu">
              <a href="/views/performance/listview.jsp">공연일정</a>
            </li>
            <li class="submenu"><a href="/views/performance">공연소개</a></li>
            <li class="submenu"><a href="/views/performance">예매안내</a></li>
          </ul>
        </li>
        <li class="menu">
          <a href="">교육</a>
        </li>
        <li class="menu">
          <a href="">오케스트라</a>
          <ul>
            <li class="submenu"><a href="1">음악감독</a></li>
            <li class="submenu"><a href="1">단원</a></li>
            <li class="submenu"><a href="1">수석객원지휘자</a></li>
            <li class="submenu"><a href="1">부지휘자</a></li>
            <li class="submenu"><a href="1">공연기획자문역</a></li>
          </ul>
        </li>
        <li class="menu">
          <a href="">시향소식</a>
          <ul>
            <li class="submenu"><a href="/board/NoticeAllSelect.do">공지사항</a></li>
            <li class="submenu"><a href="/board/NewsAllSelect.do">뉴스</a></li>
            <li class="submenu"><a href="/board/PhotoAllSelect.do">갤러리</a></li>
            <li class="submenu"><a href="/board/VideoAllSelect.do">동영상</a></li>
          </ul>
        </li>
        <!--                    <li>후원</li>-->
      </ul>
    </nav>
    <div class="icons">
      <span class="my-span" id="mypageIcon">
        <img class="icon" src="/assets/icon/member.svg" />
        <ul class="my-ul" id="mypageSubmenu">
          <li id="login" class="loginCheck">
            <a href="/memberIndex.jsp" >로그인</a>
          </li>
          <li class="loginCheck">
            <a href="/memberJoinus.jsp" >회원가입</a>
          </li>
          <li class="loginCheck">
            <a href="/member/memberMyPage.do">마이페이지</a>
          </li>
          <li class="loginCheck">
            <a href="/member/logout.do">로그아웃</a>
          </li>
        </ul>
      </span>
      <span>
        <a href="">
          <img class="icon" src="/assets/icon/schedule1.svg" />
        </a>
      </span>
      <span>
        <a href="">
          <img class="icon" src="/assets/icon/search_icon.svg" />
        </a>
      </span>
      <span class="icon_box">
        <a href="">기관소개</a>
      </span>
      <span class="icon_box">
        <a href="https://www.open.go.kr/">정보공개</a>
      </span>
    </div>
  </div>
  <div class="header-subnav"></div>
</div>
<script src="/assets/js/header.js"></script>
<script>
  var login = ${sessionScope['member'] != null}; // EL tag로 회원이름 가져오기
  window.addEventListener('load', function () {
    let loginCheck = document.querySelectorAll('.loginCheck');
    if (login) {
      loginCheck[0].style.display = 'none';
      loginCheck[1].style.display = 'none';
    } else {
      loginCheck[2].style.display = 'none';
      loginCheck[3].style.display = 'none';
    }
  });

</script>