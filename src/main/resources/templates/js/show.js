$(document).ready(function () {
    var userId = $('#user').attr("value");
    $.ajax({
        data:{id:userId},
        url:"/img/findImgByUserId",
        success:function (data) {
            var context = "<div class=\"display_imgs\">\n" +
                "<label>作品展示</label>\n" +
                "<ul>";
            for(var i=0;i<data.list.length;i++){
                var width = 0;
                var height = 0;
                if(data.list[i].img_size >=1){
                    width = 100;
                    height = (1/data.list[i].img_size)*100;
                }else {
                    width = 100*data.list[i].img_size;
                    height = 100;
                }

                context+="<li><a href='/show/showImg?imgId="+data.list[i].id+"'> <img src=\""+data.list[i].imgUrl+"\" style='width: "+width+"%;height: "+height+"%;'  ></a></li>"
            }
            context+="</ul>\n" +
                "</div>";
            $('.show_section_right').append(context);
        }


    })


})


function insertComment() {
    var imgId = $(".show_img").attr("name");
    var comment =$("#text_txt1").val();
    $.ajax({
        data:{imgId:imgId,comment:comment},
        url:"/show/insertComment",
        success:function (data) {
            if(data.result == true ){
                location.href="/show/showImg?imgId="+imgId;
            }
        }
    })
    
}