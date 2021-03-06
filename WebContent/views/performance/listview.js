// JavaScript for listview.html
const IMAGE_PATH = '/upload/show/';
const ALT_IMAGE = '/upload/show/default.gif';
var source;

window.addEventListener("load", function () {
    // initialize the listview
    createPrefData();
    // console.log(source);
});

/**
 * ajax를 통하여 공연데이터를 가져온다.
 * @param {number} month 
 * @param {number} year 
 */
function createPrefData(month = new Date().getMonth() + 1, year = new Date().getFullYear()) {
    $.ajax({
        url: "/performance/recentByCategory.do",
        type: 'GET',
        data: {
            month: month,
            year: year
        },
        dataType: 'JSON',
        success: out => {
            source = out;
            resetCategory();
        },
        error: () => console.log('ajax 통신 에러')
    });
}

/**
 * 공연아이템을 생성하는 함수
 * @param {object} data 공연정보객체. (perf_no, schedule_no, location, day, weekeday, time, 
*                                   photo, category, title, conductor, collaborator, program, price)
 * @author 신현진
 */
function createPrefItem(data) {
    const scheduleNo = data['schedule_no'];

    let detailBtn = document.createElement('div');                      // 자세히 보기 버튼
    detailBtn.classList.add('detailBtn');
    var span = document.createElement('span');
    span.innerText = "자세히 보기";
    detailBtn.appendChild(span);
    detailBtn.setAttribute('onclick', 'showDetail(' + scheduleNo + ')');

    let reserveBtn = document.createElement('div');                     // 예매하기 버튼
    reserveBtn.classList.add('reserveBtn');
    var span = document.createElement('span');
    span.innerText = "예매하기";
    reserveBtn.appendChild(span);
    reserveBtn.setAttribute('onclick', 'showReservePage(' + scheduleNo + ')');


    let buttonsDiv = document.createElement('div');                     // 버튼들을 담는 div
    buttonsDiv.classList.add('buttons');
    buttonsDiv.appendChild(detailBtn);
    buttonsDiv.appendChild(reserveBtn);


    let tableDiv = document.createElement('div');                      // 세부정보를 담는 div
    tableDiv.classList.add('perf-table');
    let dl = document.createElement('dl');

    // 지휘자
    var dt = document.createElement('dt');
    dt.innerText = "지휘자";
    var dd = document.createElement('dd');
    dd.innerText = data['conductor'].split('/')[0];
    dl.appendChild(dt);
    dl.appendChild(dd);

    // 협연자
    var dt = document.createElement('dt');
    dt.innerText = "협연자";
    var dd = document.createElement('dd');
    dd.innerHTML = data['collaborator'].split('/').filter( (value, index) => index % 2 == 0).join('<br />');
    dl.appendChild(dt);
    dl.appendChild(dd);

    // 프로그램
    var dt = document.createElement('dt');
    dt.innerText = "프로그램";
    var dd = document.createElement('dd');
    dd.innerHTML = data['program'].split('/').filter( (value, index) => index %2 == 0).join('<br />');
    dl.appendChild(dt);
    dl.appendChild(dd);

    // 가격 TODO: 수정필요
    var dt = document.createElement('dt');
    dt.innerText = "가격";
    var dd = document.createElement('dd');
    dd.innerText = data['price'];
    dl.appendChild(dt);
    dl.appendChild(dd);

    tableDiv.appendChild(dl);


    let subtitle = document.createElement('div');                          // 공연제목 담는 div
    subtitle.classList.add('perf-title');
    var span = document.createElement('span');
    span.innerHTML = '<h2>' + data['title'] + '</h2>';
    subtitle.appendChild(span);


    var tag = document.createElement('div');                               // 카테고리 담는 div
    var tags = data['category'].split('/');
    var span = document.createElement('span');
    span.innerText = tags[0];
    tag.appendChild(span);
    var span = document.createElement('span');
    span.innerText = tags[1];
    tag.appendChild(span);
    tag.classList.add('tag');

    (tags[0] === "정기공연") && tag.classList.add('regular-tag');
    (tags[0] === "시민공연") && tag.classList.add('citizen-tag');
    (tags[0] === "순회공연") && tag.classList.add('tour-tag');
    (tags[0] === "외부공연") && tag.classList.add('outside-tag');
    (tags[0] === "교육공연") && tag.classList.add('education-tag');

    let content = document.createElement('div');                          // 공연정보내용을 담는 div
    content.classList.add('content');
    content.appendChild(tag);
    content.appendChild(subtitle);
    content.appendChild(tableDiv);
    content.appendChild(buttonsDiv);

    let imgDiv = document.createElement('div');                           // 공연사진을 담는 div
    imgDiv.classList.add('image');
    let img = document.createElement('img');
    img.src = IMAGE_PATH + data['photo'];
    img.setAttribute('onerror', "this.src='" + ALT_IMAGE + "'");
    imgDiv.appendChild(img);

    let detail = document.createElement('div');                          // 공연정보를 담는 div
    detail.classList.add('detail');
    detail.appendChild(imgDiv);
    detail.appendChild(content);


    let title = document.createElement('div');                           // 타이틀바
    title.classList.add('title');
    var span = document.createElement('span');
    span.innerText = data['day'];
    title.appendChild(span);
    var span = document.createElement('span');
    span.innerText = data['weekday'];
    title.appendChild(span);
    var span = document.createElement('span');
    span.innerText = data['time'];
    title.appendChild(span);
    var span = document.createElement('span');
    span.innerText = data['location'];
    title.appendChild(span);

    var div = document.createElement('div');                            // 최종 div
    div.classList.add('perf-item');
    div.appendChild(title);
    div.appendChild(detail);

    return div;
}

/**
 * 자세히 보기 버튼을 클릭했을 때 실행되는 함수
 * @param {*} scheduleNo 
 */
function showDetail(scheduleNo) {
    location.replace("/performance/detailInfo.do?scheduleNo=" + scheduleNo);
}

function showReservePage(scheduleNo) {
    var win = window.open(`/views/reservation/book.jsp?scheduleNo=${scheduleNo}`, '_popup', "height: 620px, width: 1000px");
}

/**
 * 공연목록을 갱신
 */
function resetCategory() {
    let div = document.getElementsByClassName('performance')[0];
    div.innerHTML = '';
    source.forEach(value => div.appendChild(createPrefItem(value)));

    resetCategoryClass('ALL');
}
/**
 * 카테고리 선택에 따른 공연목록 갱신
 * @param {string} category 카테고리명
 */
function filterByCategory(category) {
    let div = document.getElementsByClassName('performance')[0];
    div.innerHTML = '';
    source.filter( value => (value['category'].split('/')[0] === category)
    ).forEach(value => div.appendChild(createPrefItem(value)));

    resetCategoryClass(category);
}
/**
 * 카테고리 선택에 따른 버튼 색상 변경
 * @param {string}} category 카테고리명
 */
function resetCategoryClass(category) {
    let $lis = $('.content-type li');
    $lis.removeClass();
    $lis.each((index, li) => {
        var value = li.getAttribute('category');
        li.classList.add(value + '-border-color');
        (li.innerText == category) && li.classList.add(value + '-invert-color');
    });
}