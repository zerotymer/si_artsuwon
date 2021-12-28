// DOM 요소가 로드 된 후 실행
window.addEventListener('load', function() {
    
    // jsp로 생성된 데이터 다시 정렬
    let conductor = document.getElementById('conductor');
    let collaborator = document.getElementById('collaborator');
    let program = document.getElementById('program');
    reformattingDD(conductor);
    reformattingDD(collaborator);
    reformattingDD(program);

    // 카테고리 css 설정
    let tag = document.getElementById('tag');
    setCategoryCSS(tag);
});



/**
 * 클릭시 보여줄 노트를 변경
 * @param {string} noteId 보여줄 노트 아이디
 */
function changeNote(element, noteId) {
    // active 변경
    let btns = document.getElementsByClassName('noteBtn');
    Array.from(btns).forEach( btn => {
        btn.classList.remove('active');
    });
    element.classList.add('active');

    // 전체 노트를 숨긴다.
    let notes = document.getElementsByClassName('note');
    Array.from(notes).forEach( note => {
        note.classList.add('disable');
    });
    let note = document.getElementById(noteId)
    note.classList.remove('disable');
}

/**
 * jsp로 생성된 데이터를 다시 정렬
 * @param {HTMLElement} element 
 */
function reformattingDD(element) {
    var text = element.innerText;
    var html = text.split('/').map( (item, index) => {
        return (index % 2 == 1) ? item : '<b>' + item + '</b>';
    }).join('<br>');
    element.innerHTML = html;
}

/**
 * 카테고리 css 설정
 * @param {HTMLElement} element tagElement
 */
function setCategoryCSS(element) {
    var tag = element.innerText.substring(0,4);
    switch (tag) {
        case '정기공연': element.classList.add('regular-invert-color'); break;
        case '시민공연': element.classList.add('citizen-invert-color'); break;
        case '순회공연': element.classList.add('tour-invert-color'); break;
        case '외부공연': element.classList.add('outside-invert-color'); break;
        case '교육공연': element.classList.add('education-invert-color'); break;
    }
}

function reserve(scheduleNo){
    var win = window.open(`/views/reservation/book.jsp?scheduleNo=${scheduleNo}`, '_popup', "height: 620px, width: 1000px");
}