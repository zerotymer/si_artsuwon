<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="/assets/style/contentframe.css">
    <style>
        :root {
            --darkblue-color: #1F2C5C;
            --reserve-color: #EF4C49;
        }
        article {
            width: 100%;
            margin-top: 30px;
        }

        hr {
            border: 1px solid lightgray;
        }
        /* notes */
        .perfBtns {

        }
        .perfBtns ul {
            display: flex;
            flex-direction: row;
            justify-content: center;
            list-style: none;
            padding: 0;
            margin: 0;
        }
        .perfBtns h3 {
            padding: 0 20px 0 20px;
            color: #666;
            border-right: 3px solid #F0F0F0;
            cursor: pointer;
        }
        .perfBtns li:last-child > h3 {
            border-right: none;
        }

        /* .active */
        .perfBtns .active {
            border-bottom: 2px solid var(--reserve-color);
        }
        .perfBtns .active h3 {
            color: var(--reserve-color);
        }

        /* detail-note */
        .note-area {
            width: 80%;
            margin: 0 auto;
            min-height: 300px;
            text-align: center;
        }
        .note-area > h3 {
            text-align: center;
        }
        .note-area .disable {
            display: none;
        }
        .scheduleBtn {
            margin-top: 30px;
            box-sizing: border-box;
            display: inline-block;
            width: 120px;
            height: 50px;
            border: 2px solid darkblue;
            font-size: 20px;
            line-height: 50px;
            text-align: center;
            color: darkblue;
        }
        .scheduleBtn a {
            text-decoration: none;
        }
    </style>
</head>
<body>
    <!-- Header -->
    <%@ include file="/include/_header.jsp" %>

    <content>
        <!-- Local Navi Bar-->
        <div class="nav_div">
            <nav id="LNB" class="LNB">
                <ul class="nav-menu">
                    <li class="menu-item menu-img">
                        <a href=""><img src="/assets/icon/home.svg" alt=""></a>
                    </li>
                    <li class="menu-item">
                        <a><strong>공연/예매</strong></a>
                        <ul class="nav-submenu">
                            <li class="submenu-item"><a ><strong>공연/예매</strong></a></li>
                            <li class="submenu-item"><a href="">교육</a></li>
                            <li class="submenu-item"><a href="">오케스트라</a></li>
                            <li class="submenu-item"><a href="">시향소식</a></li>
                            <li class="submenu-item"><a href="">기관소개</a></li>
                        </ul>
                    </li>
                    <li class="menu-item">
                        <a><strong>공연소개</strong></a>
                        <ul class="nav-submenu">
                            <li class="submenu-item"><a href="">공연일정</a></li>
                            <li class="submenu-item"><a><strong>공연소개</strong></a></li>
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
        <article>
            <div class="perfBtns">
                <ul>
                    <li class="perfBtn active"><h3>정기공연</h3></li>
                    <li class="perfBtn "><h3>시민공연</h3></li>
                    <li class="perfBtn "><h3>순회공연</h3></li>
                </ul>
            </div>
            <hr>
            <div class="note-area">
                <div id="regular" class="detail-note">
                    <h3>정기공연</h3>
                    <div>서울시향은 시민들에게 수준 높은 음악을 선보이기 위한 노력을 다하고 있습니 다. 국내외 최고의 지휘자, 협연자들과 고전부터 현대에 이르는 걸작들을 최고 의 연주로 만나는 기회입니다.</div>
                    <span class="scheduleBtn"><a href="/views/performance/listview.jsp">공연일정</a></span>
                </div>
                <div id="citizen" class="detail-note disable">
                    <h3>시민공연</h3>
                    <div>서울시향은 전문 공연장의 콘서트 외에도 다양한 시민공연을 펼치며 서울시민과 호흡하고 있습니다. 병원, 복지관 등을 방문하는 ‘우리동네 음악회’, 광복의 기쁨을 함께 누리는 ‘광복절 기념 음악회’, 한강변에서 펼쳐지는 대규모 야외공연 ‘강변음악회’ 등 서울시민의 클래식 음악 향유의 기회를 다양하게 제공하고 있습니다.</div>
                    <span class="scheduleBtn"><a href="/views/performance/listview.jsp">공연일정</a></span>
                </div>
                <div id="tour" class="detail-note disable">
                    <h3>순회공연</h3>
                    <div>해외공연을 통해 서울시향은 그 이름을 국제무대에 알리고 해외의 관객들에게 문화예술의 도시 서울의 이미지를 심고 있습니다. 또한 해외공연은 정기공연과 는 다른 환경에서 연주하고 여행을 함께 함으로써 연주력과 화합을 키우는 데에도 도움이 됩니다.</div>
                    <span class="scheduleBtn"><a href="/views/performance/listview.jsp">공연일정</a></span>
                </div>
            </div>
        </article>
    </content>

    <!-- footer -->
    <%@ include file="/include/_footer.jsp" %>

<script>
    window.addEventListener('load', function() {
        document.querySelectorAll('.perfBtn').forEach(element => {
            element.addEventListener('click', function(value, i) {
                document.querySelectorAll('.perfBtn').forEach(e => {
                    e.classList.remove('active');
                })
                document.querySelectorAll('.detail-note').forEach( (e, j) => {
                    e.classList.add('disable');
                    (i == j) && e.classList.remove('disable');
                })
                value.classList.add('active');
            });
        });
    });
</script>
</body>
</html>