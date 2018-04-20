/*
* @Author: Mines
* @Date:   2018-03-30 11:12:24
* @Last Modified by:   Mines
* @Last Modified time: 2018-04-09 21:59:37
*/
$(document).ready(function () {

    $('.mid_content_item_users li  img').hover(
        function (e) {
            var index =  $(this).parent("li").index() ;
            $(this).parent().append(
                "\t\t\t\t\t\t\t <style>.tag{\n" +
                "\twidth:300px;\n" +
                "\theight:100px;\n" +
                "\tborder:5px solid #09F;\n" +
                "\tposition:absolute;\n" +
                "\tbackground-color:#FFF;\n" +
                "\tmargin-top: -160px;\n" +
                "margin-left:"+(-index*150)+"px"+"}\n" +
                // ".tag:before ,.tag:after{\n" +
                // "\tcontent:\"\";\n" +
                // "\tdisplay:block;\n" +
                // "\tborder-width:20px;\n" +
                // "\tposition:absolute;\n" +
                // "\tbottom:-40px;\n" +
                // "\tleft:"+index*50+"px;\n" +
                // "\tborder-style:solid dashed ;\n" +
                // "\tborder-color:#09F transparent transparent;\n" +
                // "\tfont-size:0;\n" +
                // "\tline-height:0;\n" +
                // "}\n" +
                // ".tag:after{\n" +
                // "\tbottom:-33px;\n" +
                // "\tz-index: 989;\n" +
                // "\tborder-color:#FFF transparent transparent;\n" +
                // "}" +
                "</style>"+
                "<div class=\"tag\">\n" +
                "\t\t\t\t\t\t\t\tcss3气泡框\n </div>" );
                $(".tag").css("margin-left",-125+"px");

        },
        function () {

        })

    $('.mid_content_item_users li ').mouseleave(
       function () {
        $(this).find(".tag").remove();

    });





});


