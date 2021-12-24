///// JavaScript for calendar-mini.js

// Need to import jQurey

window.addEventListener("load", function () {
    createTbody(2021, 12);
});

function createTbody(month = new Date().getMonth() + 1, year = new Date().getFullYear()) {
    let tbody = document.getElementById("miniCalendar-tbody");
    // remove all tbody child
    while (tbody.firstChild) 
        tbody.removeChild(tbody.firstChild);

    var firstDay = new Date(year, month - 1, 1);
    var lastDays = new Date(year, month - 1, 0).getDate();

    for (i = 0; i < lastDays;) {
        var tr = document.createElement('tr');
        for (j = 0; j < 7; j++) {
            var td = document.createElement('td');
            ((firstDay.getDay() + i ) % 7 == j ) && (td.innerText = ++i);
            (i > lastDays) && (td.innerText = "");
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
 function createPrefData(month = new Date().getMonth() + 1, year = new Date().getFullYear()) {
    var data = $.ajax({
        url: "/performance/recentByCategory.do",
        type: 'GET',
        data: {
            month: month,
            year: year
        },
        dataType: 'JSON',
        success: out => {
            out.forEach(value => {
                var day = value
            });
        },
        error: () => console.log('ajax 통신 에러')
    });
}