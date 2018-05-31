var AnwserList;

$(document).ready(function () {
    var userId = $('#user').attr("value");
    $.ajax({
        data: {id: userId},
        url: "/img/findImgByUserId",
        success: function (data) {
            var context = "<div class=\"display_imgs\">\n" +
                "<label>作品展示</label>\n" +
                "<ul>";
            for (var i = 0; i < data.list.length; i++) {
                var width = 0;
                var height = 0;
                if (data.list[i].img_size >= 1) {
                    width = 100;
                    height = (1 / data.list[i].img_size) * 100;
                } else {
                    width = 100 * data.list[i].img_size;
                    height = 100;
                }

                context += "<li><a href='/show/showImg?imgId=" + data.list[i].id + "'> <img src=\"" + data.list[i].imgUrl + "\" style='width: " + width + "%;height: " + height + "%;'  ></a></li>"
            }
            context += "</ul>\n" +
                "</div>";
            $('.show_section_right').append(context);
        }


    })

     getAnwserList();




})


function insertComment() {
    var imgId = $(".show_img").attr("name");
    var comment = $("#text_txt1").val();
    $.ajax({
        data: {imgId: imgId, comment: comment},
        url: "/show/insertComment",
        success: function (data) {
            if (data.result == true) {
                location.href = "/show/showImg?imgId=" + imgId;
            }
        }
    })

}

var anwserId;
var commentId;
function showAnswer(e) {
    $('#anwserText').remove();
    anwserId = $(e).parent().find('a').attr('name');
    commentId=$(e).parent().attr('name');
    var anwserName = $(e).parent().find('a').html();

        $(e).parent().append(" <div id='anwserText' style=\"flex-direction: row; align-items: center;margin:0px;width: 100%;background: white\" class=\"titleBox\" >\n" +
            "                     <div class=\"tip\">\n" +
            "                         <span>回复:"+anwserName+"</span>\n" +
            "                     </div>\n" +
            "\n" +
            "                     <div class=\"textBox\">\n" +
            "                         <textarea maxlength=\"140\" id=\"text_txt1\" class=\"textInput\"></textarea>\n" +
            "                     </div>\n" +
            "                     <div class=\"buttonBox\">\n" +
            "                         <button type=\"button\" class=\"buttonStyle\" onclick=\"insertAnwser(this)\">发表</button>\n" +
            "                     </div>\n" +
            "                 </div>");

}

function showAnswer_second(e) {
    $('#anwserText').remove();
    anwserId = $(e).parent().attr('name');
    commentId=$(e).parent().parent().attr('name');
    var anwserName = $(e).parent().attr('value');

        $(e).parent().append(" <div id='anwserText' style=\"flex-direction: row; align-items: center;margin:0px;width: 96%;background: white;padding: 2%\" class=\"titleBox\" >\n" +
            "                     <div class=\"tip\">\n" +
            "                         <span>回复:"+anwserName+"</span>\n" +
            "                     </div>\n" +
            "\n" +
            "                     <div class=\"textBox\">\n" +
            "                         <textarea maxlength=\"140\" id=\"text_txt1\" class=\"textInput\"></textarea>\n" +
            "                     </div>\n" +
            "                     <div class=\"buttonBox\">\n" +
            "                         <button type=\"button\" class=\"buttonStyle\" onclick=\"insertAnwser(this)\">发表</button>\n" +
            "                     </div>\n" +
            "                 </div>");

}

function insertAnwser(e) {
    var comment = $(e).parent().parent().find('.textBox').find('#text_txt1').val();
    if (anwserId == null) {
        return;
    }
    var imgId = $("#showImg").attr('name');
    $.ajax({
        data: {imgId: imgId, anwserId: anwserId, comment: comment,commentId:commentId},
        url: "/show/anwser",
        success: function (data) {
            if(data.result == "1"){
                alert("不能够自我回复");
            }else if (data.result == true) {
                location.reload();

            }

                },
        error: function () {
            alert("请联系管理员")
        }
    })
}

function getAnwserList() {
    var imgId = $("#showImg").attr('name');
    var list;
    $.ajax({
        data: {imgId: imgId},
        url: "/show/getAnwserList",
        success: function (data) {
            AnwserList = data.AnwserList;
            appendAnwserList(AnwserList);
        }
    })
}

function appendAnwser(obj, e) {

    $(e).append("<div value='"+obj.userName+"' name='"+obj.userId+"' class='anwserComment' style=\"padding: 5px;background: white\">\n" +
        "                     <span style=\"margin-left: 50px\">" + obj.userName + "回复" + obj.anwserName + " :</span>  <span >" + obj.comment + "</span>     <span style=\"right: 0;position: absolute;margin-right: 15%;\"> " + obj.stringDate + "</span>  <span onclick='showAnswer_second(this)' class=\"anwser\" style=\"margin-top:0 \">回复</span>\n" +
        "                 </div>")

}


function appendAnwserList(AnwserList) {
    var ul = $('.comment li');
    for (var j = 0; j < ul.length; j++) {
        var number = $(ul[j]).attr('number');
        if (number == 3) {
            var flag = 0;
        } else {
            $('.anwserComment').remove();
            $('#more').remove();
            var flag = 0;
        }
        var bool = true;
        var commentId = $(ul[j]).attr('name');
        for (var i = 0; i < AnwserList.length ; i++) {

            if (AnwserList[i].commentId == commentId) {
                // appendAnwser(AnwserList[i], ul[j]);
                flag += 1;
                if (flag > number) {
                    flag += 2;
                    $(ul[j]).attr('number',flag);
                    if(bool) {
                        $(ul[j]).append("<div id='more' onclick='appendAnwserList(AnwserList)' style='padding:10px;text-align: center;cursor: pointer'>显示更多</div>")
                        bool = false;
                    }
                }else{
                    appendAnwser(AnwserList[i], ul[j]);
                }
            }


        }
    }

}