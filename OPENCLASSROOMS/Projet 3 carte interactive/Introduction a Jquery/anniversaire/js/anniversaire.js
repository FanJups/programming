

$(document).ready(function(){ 


    $("#para0").click(function(){

        $("#para1").show(1000);

    });

    $("#para1").click(function(){

        $("#para2").show(2000); 

    });

    $("#para2").click(function(){

        $("#para3").show(3000);

    });

    $("#para3").click(function(){

        $('#son')[0].play();

        $("body").css("background-image", 'url(imganniv.jpg)');

        $("#para0").css("color", '#e74c3c');

        $("#para1").css("color", '#e67e22');

        $("#para2").css("color", '#f39c12');

        $("#para3").css("color", '#16a085');

        $("#para0 , #para1 , #para2 , #para3").css("background-color", 'rgba(236, 240, 241,1)');


    });
});