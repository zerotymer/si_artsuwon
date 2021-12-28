window.addEventListener('load', function() {

    // myPageIcon Mouse Over Event
    let mypageSubmenu = document.getElementById('mypageSubmenu');
    let myPageIcon = document.getElementById('mypageIcon');
    myPageIcon.addEventListener('mouseover', function() {
        mypageSubmenu.classList.add('func-show');
    });
    mypageSubmenu.addEventListener('mouseover', function() {
        this.classList.add('func-show');
    });
    mypageSubmenu.addEventListener('mouseout', function() {
        this.classList.remove('func-show');
    });
    document.querySelectorAll('.menu').forEach(element => {
        element.addEventListener('mouseover', function() {
            mypageSubmenu.classList.remove('func-show');
        });
    });
});