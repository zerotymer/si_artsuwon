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
    note.remove('disable');
}