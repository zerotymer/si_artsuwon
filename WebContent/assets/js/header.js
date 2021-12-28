window.addEventListener('load', function() {

    // myPageIcon Mouse Over Event
    let mypageSubmenu = document.getElementById('mypageSubmenu');
    let myPageIcon = document.getElementById('mypageIcon');
    myPageIcon.addEventListener('mouseover', function() {
        mypageSubmenu.classList.add('func-mypageOver');
    });
    mypageSubmenu.addEventListener('mouseover', function() {
        this.classList.add('func-mypageOver');
    }).addEventListener('mouseout', function() {
        this.classList.remove('func-mypageOver');
    });
});