/*
* @Author: Mines
* @Date:   2018-05-14 09:13:59
* @Last Modified by:   Mines
* @Last Modified time: 2018-05-15 14:36:18
*/

var list = null;

var addNum = $(".section_header").height;

function checkAll() {
    $(".conllect").attr("checked", true);

}

function getIds() {
    var list = new Array();
    var conllectList = $(".conllect");
    for (var i = 0; i < conllectList.length; i++) {
        if (conllectList[i].checked == true) {
            list.push(conllectList[i].name);
        }
    }

    return list;
}


function deleteAjax() {
    var type;
    if ($(".section_header_title").text() == "管理作品") {
        type = 1;
    } else {
        type = 2;
    }
    var list = getIds().toString();
    $.ajax({
        url: '/img/delete',
        data: {ids: list, type: type},
        success: function (data) {
            if(data.result > 0){
            location.href = "/img/toManage?type="+type;
            }else{
                alert("删除失败")
            }
        }
    })


}


function checkCannel() {
    $(".conllect").attr("checked", false);

}

$(document).ready(function () {

    var type = 0;
    if ($(".section_header_title").text() == "管理作品") {
        type = 1;
    } else {
        type = 2;
    }
    $.ajax({
        data: {type: type},
        url: "/img/getImgList",
        success: function (data) {
            list = data.imgList;
            appendRow(index, index + 2);
        }

    })

    $(".section_mid_label").click(function () {
        appendRow(index);
    })


})

var index = 0;
var flag = false;

function appendRow(beginIndex, endIndex) {
    $('.section_mid_label').remove();
    if (index != 0) {
        beginIndex = index + 1;

    } else {
        beginIndex = index;
    }

    endIndex = beginIndex + 2;
    if (endIndex >= list.length) {
        endIndex = list.length - 1;
    } else {
        endIndex = beginIndex + 2;
    }
    var context = "<div class='row'>";
    for (var i = beginIndex; i <= endIndex; i++) {
        context += setDate(list[i]);
        if (i == endIndex) {

            context += "</div>";
            if (endIndex == list.length - 1) {
                context += "<div class=\"section_mid_label\" '><label>已经没有更多内容了</label>";
            } else {
                context += "<div class=\"section_mid_label\" onclick='appendRow(index)'><label>更新更多</label>";
            }

        }
    }
    $(".section_mid").append(context);

    index = endIndex;


}

function setDate(img) {
    if (img.img_size <= 1) {
        var width = img.img_size * 100;
        var height = 100;
    } else {
        var width = 100;
        var height = (1 / img.img_size) * 100;
    }

    var String = "<div  class=\"img_content\">\n" +
        "   \t               <div  class=\"paihang_img\" style='width: 300px;height: 300px;line-height: 295px;'>\n" +
        "\n" +
        "                      <img alt=\"\" class=\"paihang_image\" src=\"" + img.imgUrl + "\" style=\"width:" + width + "%;height:" + height + "%\">\n" +
        "\n" +
        "                      <input type=\"checkbox\" id=\"checkbox\" class=\"conllect\"  name=\"" + img.id + "\" />\n" +
        "\n" +
        "   \t                   \n" +
        "\n" +
        "   \t               </div>\n" +
        "\n" +
        "                      <ul style=\"width:300px;\">\n" +
        "                          <li>" + img.imgName + "</li>\n" +
        "                          <li>" + img.userName + "</li>\n" +
        "                      </ul>\n" +
        "                  </div>";


    return String;

}