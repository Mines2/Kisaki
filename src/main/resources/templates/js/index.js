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

                "<div class=\"tag\">\n" +
                "\t\t\t\t\t\t\t\tcss3气泡框\n </div>" );

        },
        function () {

        })

    $('.mid_content_item_users li ').mouseleave(
       function () {
        $(this).find(".tag").remove();

    });
    var style;
    $('.right_top_nav_img').hover(
        function  (e) {
            var index = $(this).parent('li').index();
            style = $(this).attr('style');
            if(index == 0){
                $(this).parent().append('<div class="right_top_nav_img_code"><img src="../image/code01.jpg" style="width: 100%"></div>');
                // $(this).attr('style',' background: url(\'image/icons.png\') -851px -50px;background-size: 2500%;' +
                //     'border: 1px solid cornflowerblue;border-bottom: white solid 1px;')
            }else if (index == 1) {
                $(this).parent().append('<div class="right_top_nav_img_code"><img src="../image/code01.jpg" style="width: 100%"></div>');

                // $(this).attr('style',' background: url(\'image/icons.png\') -851px -250px;background-size: 2500%;' +
                //     'border: 1px solid cornflowerblue;border-bottom: white solid 1px;')
            }else {

                $(this).parent().append('<div class="right_top_nav_img_code"><ul><li >个人中心</li><li  onclick="loginOut()">' +
                    '注销</li></ul></div>');

            }


        });
        $('.left_nav_content li').mouseleave(function () {
            $('.right_top_nav_img_code').remove();
            // ($(this).find("div"))[0].attr("style",style);
            // $(this).find("div").attr('class',"right_top_nav_img_code")
// alert(($(this).find("div"))[0].style);
// alert(style);
// ($(this).find("div"))[0].style =style;
            // alert($(this).find("div"))

        });






});


function loginOut() {
    $.ajax({
        url:"/out",
        success:function () {
            location.href="/"
        }
    })
    
}


function Collect(e) {

    var imgId = e.value;
    var imgUserId = e.name;
    $.ajax({
        data:{imgId:imgId,imgUserId:imgUserId},
        url:"/img/addCollect",
        success: function (data) {
           if(data.result == true){
               alert("收藏成功");
           }

        },
        error: function () {
            alert("网络异常，请联系维护人员", function () {
            });
        }




    })
    
}


