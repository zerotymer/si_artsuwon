<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <style>
        body {
            background-color: #DDD;
        }
        .flex-row {
            display: flex;
            flex-direction: row;
        }
        .perf-title {
            width: 1000px;
            padding: 0px 40px;
            border: 1px solid #888;
            box-sizing: border-box;
        }
        .perf-side {
            width: 270px;
            height: 550px;
            border: 1px solid #888;
            box-sizing: border-box;
        }

        fieldset dt {
            margin: 0;
            padding: 2px 6px;
            background-color: #444;
            color: white;
        }
        fieldset dd{
            margin: 0;
            padding: 2px 6px;
            background-color: #DDD;
        }
        fieldset input {
            height: 40px;
            width: 100%;
            margin-top: 6px;
            border: none;
            color: white;
            cursor: pointer;
        }
        

    </style>
</head>
<body>

    <div>
        <div class="perf-title"><h3 id="title">예매하기 (여긴 제목입니다.)</h3></div>
        <div class="flex-row">
            <%@ include file="/views/reservation/seat/_seatTable.jsp" %>
            <div class="perf-side">
                <form action="/reservation/book.do" method="post" id="bookForm">
                    <fieldset>
                        <legend>예매하기</legend>
                        <dl>
                            <dt>예약자이름</dt><dd id="buyer">${sessionScope["member"].getUserName()} (${sessionScope["member"].getUserId()})</dd>
                            <dt>공연이름</dt><dd id="perf-title"></dd>
                            <dt>공연일시</dt><dd id="perf-date">DDD</dd>
                            <dt>공연장소</dt><dd id="perf-location">LOL</dd>
                            <dt>선택된 좌석</dt><dd id="perf-selected">A블럭 7열 23</dd>
                            <dt>가격</dt><dd id="perf-price">20000원</dd>
                        </dl>
                        <input type="hidden" name="price" id="priceInput" value="0">
                        <input type="hidden" name="scheduleNo" id="scheduleNoInput" value="${requestScope.scheduleNo}">
                        <input type="hidden" name="invoiceNo" id="uidInput" value="">
                        <input type="hidden" name="seatCode" id="seatCodeInput" value="">
                        <input type="button" value="결제하기" style="background-color: red;" onclick=""> <br>
                        <input type="reset" value="취소하기" style="background-color: #666;">
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
    <script src="./book.js"></script>
    <script src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js" type="text/javascript"></script>
</body>
</html>