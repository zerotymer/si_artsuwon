window.addEventListener('load', () => {
    let calendar = document.querySelector('.calendar');
    var date = new Date();
    
    // set color
    
    /// action
    let tds = document.querySelectorAll('.calendar tr>td');
    tds.forEach(function (element) {
        (element.innerText == "") || (element.addEventListener('click', function() {
            console.log(this.style.borderColor);
            this.style.backgroundColor = this.style.borderColor;
        }));
    });
//    console.log(tdss);
    
    
});

