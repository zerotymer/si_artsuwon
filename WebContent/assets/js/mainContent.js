/// FIELEs
// Global Variables
// 경로
const pathCardImage = '/upload/show/';              // 메인 공연목록 카드 이미지 경로 설정
const altCardImage = '/upload/show/default.gif';    // 대체 이미지 경로



/// EVENTs

window.addEventListener('load', function() {
    // calendar 관련
    setCalendar();
    initailize_card();
});



/// METHODs

function setCalendar() {
    let date = new Date();
    var max = new Date(date.getFullYear(), date.getMonth() + 1, 0).getDate();

    $('#year_month').text(date.getFullYear() + '.' + (date.getMonth() + 1) + '.');

    $('.days li').each( (index, element) => {
        var day = Number($(element).text());
        ((day + 1) % 7 == date.getDay()) && $(element).addClass('saturday');
        (day % 7 == date.getDay()) && $(element).addClass('sunday');
        (day > max) && element.setAttribute('style', 'display: none');
    });
}

function initailize_card() {
    let $cards = $('.card-item');

    // ajax 호출
    $.ajax({
        url: '/performance/recentList.do',
        type: 'GET',
        data: { count: 4 },
        dataType: 'json',
        success: out => {
            // console.log(out);
            let cards = $('.perf-cards');
            cards.children().remove();
            var map = out.forEach( item => {
                cards.append(createCard(item));
            });
            // console.log(map);
        },
        error: err => console.log('ajax 요청 실패: ', err)
    })
}

/**
 * 공연목록을 보여주기 위한 카드를 생성하는 함수
 * @param {number} scheduleNo 일정번호
 * @param {object} card 카드 정보 (perf_no, schedule_no, title, date, location, photo)
 * @author 신현진
 */
function createCard(card) {
    console.log(card);
    // 상세정보 - 내용
    let content = document.createElement('div');            // 상세정보 - 내용 div

    let $spanTag = $(document.createElement('span'));           // 상세정보 - 내용 span tag
    var tag = card['category'];                             // 공연 카테고리
    $spanTag.addClass('tag');
    $spanTag.text(tag);
    tag = tag.substring(0, 4);
    (tag === "정기공연") && $spanTag.addClass('regular-font-color');
    (tag === "시민공연") && $spanTag.addClass('citizen-font-color');
    (tag === "순회공연") && $spanTag.addClass('tour-font-color');
    (tag === "외부공연") && $spanTag.addClass('outside-font-color');
    (tag === "교육공연") && $spanTag.addClass('education-font-color');
    
    let $titleTag = $(document.createElement('h5'));            // 상세정보 - 내용 h5 tag
    $titleTag.text(card['title']);                           // 공연 제목

    let $dateTag = $(document.createElement('span'));           // 상세정보 - 내용 span tag
    $dateTag.text(card['date']);                             // 공연 날짜

    let $locationTag = $(document.createElement('span'));       // 상세정보 - 내용 span tag
    $locationTag.text(card['location']);                     // 공연 장소

    content.append($spanTag[0]);
    content.append($titleTag[0]);
    content.append($dateTag[0]);
    content.append($locationTag[0]);

    // 예약버튼
    let reserveBtn = document.createElement('div');         // 예약버튼
    $(reserveBtn).text("예매하기");
    $(reserveBtn).addClass('reserve-btn');
    reserveBtn.setAttribute('onclick', 'reservePerformance(' + card['schedule_no'] + ')');

    
    // 상세정보 속성
    let detail = document.createElement('div');             // 상세정보 div
    detail.setAttribute('class', 'card-detail');            // 상세정보 div 클래스 설정
    detail.append(content);                                 // 상세정보 div에 상세정보 - 내용 추가
    detail.append(reserveBtn);                              // 상세정보 div에 예약버튼 추가

    
    // 기본 이미지 관련 속성
    let img = document.createElement('img');                // 기본이미지 tag
    img.setAttribute('src', pathCardImage + card.photo);    // 기본이미지 설정
    img.setAttribute('onerror', "this.src='" + altCardImage + "'");   // 대체이미지 설정
    
    
    let div = document.createElement('div');                // 기본 div
    $(div).addClass('card-item');                           // 기본 div 클래스 설정
    div.append(img);                                        // 기본 div에 기본이미지 추가
    div.append(detail);                                     // 기본 div에 상세정보 추가
    return div;
}

/**
 * 공연예약페이지를 호출하는 함수
 * @param {number} perfId 공연번호(일정번호)
 * @author 신현진
 */
function reservePerformance(perfId) {

}