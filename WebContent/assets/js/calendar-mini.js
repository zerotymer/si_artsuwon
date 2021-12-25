///// JavaScript for calendar-mini.js
// Need to import jQurey



function createTbody(month = new Date().getMonth(), year = new Date().getFullYear()) {
    let tbody = document.getElementById("miniCalendar-tbody");
    // remove all tbody child
    while (tbody.firstChild) 
        tbody.removeChild(tbody.firstChild);

    var firstDay = new Date(year, month, 1);
    var lastDays = new Date(year, month + 1, 0).getDate();

    for (i = 0; i < lastDays;) {
        var tr = document.createElement('tr');
        for (j = 0; j < 7; j++) {
            var td = document.createElement('td');
            ((firstDay.getDay() + i ) % 7 == j ) && (td.innerText = ++i);
            (i > lastDays) && (td.innerText = "");
            td.setAttribute('day', i);
            tr.appendChild(td);
        }
        tbody.appendChild(tr);
    }
}


/**
 * ajax를 통하여 공연데이터를 가져온다.
 * @param {number} month 
 * @param {number} year 
 */
 function getPrefData(month = new Date().getMonth(), year = new Date().getFullYear()) {
    let trArr = $('td');
    $.ajax({
        url: "/performance/recentByCategory.do",
        type: 'GET',
        data: {
            month: month + 1,
            year: year
        },
        dataType: 'JSON',
        success: out => {
            if (out.length == 0) 
                return;

            out.forEach( value => {
                var day = value['day'].split('.')[1];
                var category = value['category'].split('/')[0];
                let $tr = $('td[day=' + day + ']');

                (category === "정기공연") && $tr.addClass('regular');
                (category === "시민공연") && $tr.addClass('citizen');
                (category === "순회공연") && $tr.addClass('tour');
                (category === "외부공연") && $tr.addClass('outside');
                (category === "교육공연") && $tr.addClass('education');
            });
        },
        error: () => console.log('ajax 통신 에러')
    });
}

function setCurDate() {
    // initialize
    var cur_date = new Date();

    // use closer function
    return function (value) {
        cur_date.setMonth(cur_date.getMonth() + value);

        let title = document.getElementById('miniCalendar-title');
        title.innerText = cur_date.getFullYear() + '년 ' + (cur_date.getMonth() + 1) + '월';
        
        createTbody(cur_date.getMonth(), cur_date.getFullYear());
        getPrefData(cur_date.getMonth(), cur_date.getFullYear());
    };
}



window.addEventListener("load", function () {
    var curdate = setCurDate();
    this.document.getElementsByClassName('curBtn')[0].onclick = curdate(-1);
    this.document.getElementsByClassName('curBtn')[1].onclick = curdate(1);
});