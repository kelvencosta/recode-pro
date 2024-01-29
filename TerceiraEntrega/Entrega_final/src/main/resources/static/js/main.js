$(document).ready(function() {
    var headerHeight = $(".banner").outerHeight();

    $(window).on('scroll', function() {
        var scrollPosition = $(window).scrollTop();
        var activationOffset = headerHeight;

        if (scrollPosition >= activationOffset) {
            $('[data-toggle="counter-up"]').counterUp({
                delay: 10,
                time: 2300
            });
            $(window).off('scroll');
        }
    });
});