// Global Variable
var seatRestriction = 0;
var schedule;

window.addEventListener("load", function() {

    // OP
    drawSeatInLargeHall();
    initializeSeatInfo(73);
});

/**
 * 수원SK아트리움 대공연장의 좌석배치 생성
 */
function drawSeatInLargeHall() {
    // OP - L1P1
    let op = document.getElementById("large-area-OP");
    while (op.firstChild) 
        op.removeChild(op.firstChild);

    var pos = 1;
    // op.append(createSeatSpan());
    // Array.from({length: 18}, () => op.append(createSeatSpan('L1P' + pos, pos++)));
    // op.append(createSeatSpan());
    createSeatsSpanToArea(op, 'L1P', 18, 1, 1);
    createSeatsSpanToArea(op, 'L1P', 18, 1, 1, 19);
    createSeatsSpanToArea(op, 'L1P', 20, 0, 0, 37);

    // A B C: L1A1-1, L1B1-1, L1C1-1
    var acDefArr = [5, 6, 6, 7, 7, 8, 8, 9, 9];
    var areaA = document.getElementById("large-area-A9");
    var areaB = document.getElementById("large-area-B9");
    var areaC = document.getElementById("large-area-C9");

    for (i = 1; i <= 9; i++) {
        createSeatsSpanToArea(areaA, `L1A${i}-`, acDefArr[i-1], 9 - acDefArr[i-1]);
        areaB.append(createLabelSpan(`${i}열`));
        createSeatsSpanToArea(areaB, `L1B${i}-`, 14);
        areaB.append(createLabelSpan(`${i}열`));
        createSeatsSpanToArea(areaC, `L1C${i}-`, acDefArr[i-1], 0, 9 - acDefArr[i-1]);
    }

    // A B C: L1A10-1, L1B10-1, L1C10-1
    var areaA = document.getElementById("large-area-A12");
    var areaB = document.getElementById("large-area-B12");
    var areaC = document.getElementById("large-area-C12");

    for (i = 10; i <= 19; i++) {
        createSeatsSpanToArea(areaA, `L1A${i}-`, 11);
        areaB.append(createLabelSpan(`${i}열`));
        createSeatsSpanToArea(areaB, `L1B${i}-`, 14);
        areaB.append(createLabelSpan(`${i}열`));
        createSeatsSpanToArea(areaC, `L1C${i}-`, 11);
    }

    areaB.append(createLabelSpan(`${20}열`));
    createSeatsSpanToArea(areaB, '', 0, 14);
    areaB.append(createLabelSpan(`${20}열`));
    areaB.append(createLabelSpan(`${21}열`));
    createSeatsSpanToArea(areaB, '', 0, 14);
    areaB.append(createLabelSpan(`${21}열`));
    
    var areaA = document.getElementById("large-speicalarea-A2");
    Array.from({length: 5}, (v, i) => areaA.append(createSpecialSeatSpan(`L1A0-${i+1}`)));
    createSeatsSpanToArea(areaA, 'L1A20-', 2);
    createSeatsSpanToArea(areaA, 'L1A21-', 2);
    
    // SPECIAL
    var areaC = document.getElementById("large-speicalarea-C2");
    var span = createSeatSpan('L1C20-1', '1');
    span.style.setProperty('grid-row', '1/2');
    areaC.append(span);
    var span = createSeatSpan('L1C20-2', '2');
    span.style.setProperty('grid-row', '1/2');
    areaC.append(span);
    createSeatsSpanToArea(areaC, 'L1C21-', 2);
    Array.from({length: 5}, (v, i) => areaC.append(createSpecialSeatSpan(`L1C0-${i+1}`)));
}

/**
 * 일반 좌석 생성
 * @param {string} code 
 * @param {string} text 
 * @returns 
 */
function createSeatSpan(code, text) {
    let span = document.createElement("span");
    span.classList.add("seat");
    span.innerText = (text == undefined) ? '_' : text;
    (text == undefined) && span.classList.add('seat-disabled');
    (code == undefined) || (span.id = code);
    (code == undefined) || span.addEventListener('click', () => toggleSeat(code));
    // TODO: bubbling으로 처리 가능한지 확인
    return span;
}

/**
 * 라벨 생성
 * @param {string} text 
 * @returns 
 */
function createLabelSpan(text) {
    let span = document.createElement("span");
    span.classList.add("seat-label");
    span.innerText = text;
    return span;
}

/**
 * 특별좌석 생성(장애인용)
 * @param {string}} code 
 * @returns 
 */
function createSpecialSeatSpan(code) {
    let span = document.createElement("span");
    span.classList.add("seat");
    span.classList.add("seat-special");
    (code == undefined) || (span.id = code);
    (code == undefined) || span.addEventListener('click', () => toggleSeat(code));

    let img = document.createElement("img");
    img.src = "/assets/icon/icons8-wheelchair-24.png";
    span.append(img);
    // TODO: bubbling으로 처리 가능한지 확인
    return span;
}

/**
 * 좌석열 생성
 * @param {element} parent 
 * @param {string} codePrefix 
 * @param {number} seatsCount 
 * @param {number} startEmptyCount 
 * @param {number} endEmptyCount 
 * @param {number} startNumber 
 */
function createSeatsSpanToArea(parent, codePrefix, seatsCount = 1, startEmptyCount = 0, endEmptyCount = 0, startNumber = 1) {
    (startEmptyCount > 0) && Array.from({length: startEmptyCount}, () => parent.append(createSeatSpan()));
    Array.from({length: seatsCount}, (v, i) => parent.append(createSeatSpan(codePrefix + (i + startNumber), i + startNumber)));
    (endEmptyCount > 0) && Array.from({length: endEmptyCount}, () => parent.append(createSeatSpan()));
}


function toggleSeat(code) {
    // OP
    var seat = document.getElementById(code);
    if (seat.classList.contains("seat-reserved") || seat.classList.contains("seat-restrict")) {
        return;
    } else if (seat.classList.contains("seat-selected")) {
        seat.classList.remove("seat-selected");
    } else {
        seat.classList.add("seat-selected");
    }
}


/**
 * 좌석 정보 설정
 * @param {number} restrictGrade 0, 1, 5 제한없음
 */
function setSeatData(id, data) {
    let seat = document.getElementById(id);
    (seat == undefined) && console.log(id);
    (data['restriction'] >= seatRestriction ) && seat.classList.add('seat-restrict');
}

function setReservedSeat(id) {
    let seat = document.getElementById(id.trim());
    (seat == undefined) && console.log(id);
    seat.classList.add('seat-reserved');
}


/**
 * 좌석 기본정보 획득
 */
function initializeSeatInfo(scheduleNo) {

    
    // Ajax: 공연일정 호출
    $.ajax({
        url: '/performance/detailInfo.json',
        type: 'get',
        dataType: 'json',
        data: { scheduleNo: scheduleNo },
        success: (data) => {
            schedule = data;
            seatRestriction = data['restriction'];
        },
        error: () => console.log('ajax 통신 에러1')
    });

    // Ajax: 좌석 기본정보 호출
    $.ajax({
        url: '/seat/requestInfo.do',
        type: 'get',
        data: { restriction: 5},        // 5: 모든 정보 조회
        datatype: 'json', 
        success: (data) => {
            Object.keys(data).forEach( key => {
                setSeatData(key, data[key]);
            });
            console.log('ajax 통신 성공');
        },
        error: () => console.log('ajax 통신 에러2')
    });

    // Ajax: 좌석 예약정보 호출
    $.ajax({
        url: '/seat/requestReservedSeat.json',
        type: 'get',
        dataType: 'json',
        data: { scheduleNo: scheduleNo },
        success: (data) => {
            Object.keys(data).forEach( key => {
                setReservedSeat(key.trim());
            });
        },
        error: () => console.log('ajax 통신 에러3')
    });
}