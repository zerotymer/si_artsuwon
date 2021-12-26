<%@ page import="kr.or.artsuwon.performance.model.vo.PerformanceInfomation" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="/assets/style/contentframe.css">
    <link rel="stylesheet" href="/assets/style/tag-color.css">
    <link rel="stylesheet" href="/views/performance/detailview.css">
</head>
<body>
    <!-- Header -->
    <%@ include file="/include/_header.jsp" %>

    <!-- Content -->
    <content>
        <!-- Local Navi Bar-->
        <div class="nav_div">
            <nav id="LNB" class="LNB">
                <ul class="nav-menu">
                    <li class="menu-item menu-img">
                        <a href=""><img src="/assets/icon/home.svg" alt=""></a>
                    </li>
                    <li class="menu-item">
                        <a href=""><b>공연/예매</b></a>
                        <ul class="nav-submenu">
                            <li class="submenu-item"><a href=""><strong>공연/예매</strong></a></li>
                            <li class="submenu-item"><a href="">교육</a></li>
                            <li class="submenu-item"><a href="">오케스트라</a></li>
                            <li class="submenu-item"><a href="">시향소식</a></li>
                            <li class="submenu-item"><a href="">기관소개</a></li>
                        </ul>
                    </li>
                    <li class="menu-item">
                        <a href=""><b>공연일정</b></a>
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

        <!-- details -->
        <div class="detailView">
            <a href="">공연일정 화면으로 이동</a>
            <div class="title">
                <span class="tag" id="tag">${ requestScope.info.category }</span>
                <h2>${ requestScope.info.title }</h2>
            </div>
            <div class="content">
                <article>
                    <div class="graybox">
                        <div class="schedule">
                            <img src="/assets/icon/icons8-calendar-64.png">
                            <dl>
                                <dt>공연일정</dt>
                                <dd class="date">${ requestScope.date }</dd>
                            </dl>
                            <img src="/assets/icon/icons8-location-64.png">
                            <dl>
                                <dt>장소</dt>
                                <dd class="location">${ requestScope.location }</dd>
                            </dl>
                        </div>
                        <div class="feature">
                            <dl>
                                <div>
                                    <dl>
                                        <dt>지휘자</dt>
                                        <dd id="conductor">${ requestScope.info.conductor }</dd>
                                        <dt>협연자</dt>
                                        <dd id="collaborator"><b>피아노, 보리스 길트버그</b><br>Boris Giltburg, Piano</dd> <!-- for -->
                                    </dl>
                                </div>
                            </dl>
                            <dl>
                                <dt>프로그램</dt>
                                <dd id="program">${ requestScope.info.programs }</dd>
                            </dl>
                            <dl>
                                <dt>가격</dt>
                                <dd>${ requestScope.price }</dd>
                            </dl>
                        </div>
                        <div class="reserveDiv">
                                <span class="reserveBtn">
                                    예약하기
                                </span>
                            <div>
                                <b><pre>※ 공연 당일 티켓은 각 공연장 콜센터와 현장 매표소에서 구입하실 수 있습니다.
            관련 문의
            - 예술의전당 02-580-1300(09:00~20:00)
            - 롯데콘서트홀 1544-7744(평일 10:30 ~ 19:00, 주말,공휴일 휴무)
            - 세종문화회관 02-399-1000(09:00~20:00)
            ※ 본 연주회의 일정과 장소 출연진과 곡목 등은 사정에 따라 변경될 수 있습니다.
            ※ 예매 또는 취소와 관련해서는 "예매안내" 메뉴를 참고하시기 바랍니다.</pre></b>
                            </div>
                        </div>
                    </div>
                    <div class="notes">
                        <div class="notes-btns">
                            <ul>
                                <li class="noteBtn active" onclick="changeNote(this, 'note1');"><h3>공연소개</h3></li>
                                <li class="noteBtn" onclick="changeNote(this, 'note2');"><h3>프로그램 노트</h3></li>
                                <li class="noteBtn" onclick="changeNote(this, 'note3');"><h3>연관패키지</h3></li>
                            </ul>
                        </div>
                        <div class="detail-note">
                            <div class="note" id="note1">${ requestScope.info.introduction }</div>
                            <div class="note disable" id="note2">${ requestScope.info.programNote }</div>
                            <div class="note disable" id="note3">${ requestScope.info.relatedPackage }</div>
                        </div>
                    </div>
                </article>
                <div class="poster">
                    <img src="/upload/show/${ requestScope.info.photo }" onerror="this.src='/upload/show/default.gif">
                </div>
            </div>
        </div>

    </content>
    <script src="/views/performance/detailview.js"></script>

    <!-- Footer -->
    <%@ include file="/include/_footer.jsp" %>

</body>
</html>