// 

$(document).ready( function() {
    


    // calendar 관련
    setCalendar();
});

function setCalendar() {
    let date = new Date();
    var max = new Date(date.getFullYear(), date.getMonth() + 1, 0).gatDate();
    // var max = 20;

    $('#year_month').text(date.getFullYear() + '.' + (date.getMonth() + 1) + '.');
    console.log(date.getDate() % 7 == 7 - date.getDay());

    $('.days li').each( (index, element) => {
        var day = $(element).text();
        (day % 7 == date.getDay()) && $(element).addClass('hollyday');
        (day > max) && element.setAttribute('style', 'display: none');
    });
}

