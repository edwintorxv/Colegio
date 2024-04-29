$(document).ready(function(){
    $('.menuVertical li:has(ul)').click(function(e){
        e.preventDefault();
        if ($(this).hasClass('activado')) {
            $(this).removeClass('activado');
            $(this).children('ul').slideUp();
        }else{
            $('.menuVertical li ul').slideUp();
            $('.menuVertical li').removeClass('activado');
            $(this).addClass('activado');
            $(this).children('ul').slideDown();
        }
    });
});

$(".menuVertical li ul li a").click(function (e) {
    window.location.href = $(this).attr("href");
 });
