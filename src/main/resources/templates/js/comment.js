$(function () {
    $('#text_txt1').on('keyup', function () {
        var txtval = $('#text_txt1').val().length;
        console.log(txtval);
        var str = parseInt(150 - txtval);
        txtval = parseInt(txtval);
        console.log(str);
        if (str > 0) {
            $('#num_txt1').html(txtval + '/140');
        } else {
            $('#num_txt1').html('140/140');
            $('#text_txt1').val($('#text_txt1').val().substring(0, 140)); //这里意思是当里面的文字小于等于0的时候，那么字数不能再增加，只能是600个字
        }
        //console.log($('#num_txt').html(str));
    });
});

var setting = {
    view: {
        showIcon: showIconForTree,
        fontCss: getFont
    },
    data: {
        simpleData: {
            enable: true
        }
    }
};

var zNodes = [
    {id: 1, pId: 0, name: "大家的动态", url: "https://www.baidu.com/", target: "_self", font: {'color': '#5CACEE'}},
    {id: 2, pId: 0, name: "全部动态", url: "https://www.bilibili.com/", target: "_self", font: {'color': '#5CACEE'}},
    {id: 3, pId: 0, name: "关注的用户的动态", url: "https://www.qq.com/", target: "_self", font: {'color': '#5CACEE'}},
    {id: 4, pId: 0, name: "好P友的动态", url: "", target: "_self", font: {'color': '#5CACEE'}},
    {id: 5, pId: 0, name: "你的动态", url: "", target: "_self", font: {'color': '#5CACEE'}}
];

function showIconForTree(treeId, treeNode) {
    return !treeNode.isParent;
};

function getFont(treeId, node) {
    return node.font ? node.font : {};
}

$(document).ready(function () {
    $.fn.zTree.init($("#treeDemo"), setting, zNodes);
});


function pushContext() {
    var text = $('#text_txt1').val();
    $.ajax({
        data: {context: text},

        url: "/active/pushContext",
        success: function (data) {
            if (data.result === true) {
                alert("发表成功");
                location.href = "/active/getlist3";
            }
        },
        error:function () {
            alert("网络故障，请联系管理员");
        }
    })

}


function findContextByUserId(e) {
    $('.outer').remove();

    changeClass(e);
    $.ajax({
        url:"/active/getListByUserId",
        success:function (data) {
            for(var i = 0 ;i<data.list.length;i++) {
                appendContext(data.list[i]);
            }
        }
    })
    


    function findByCareIds(e) {
        $('.outer').remove();
            changeClass(e);

            $.ajax({
                url: "/active/getlist1",
                success: function (data) {
                    if (data.list != null) {
                        for (var i = 0; i < data.list.length; i++) {
                            appendContext(data.list[i]);
                        }
                    }
                }
            })
    }
    
    
    function appendContext(context) {
        $('.divleft').append("<div class=\"outer\">\n" +
            "            <div class=\"infoBox\" style=\"flex-direction: row;\">\n" +
            "\n" +
            "            <div class=\"info1\">\n" +
            "            <div class=\"authorInfo\" style=\"flex-direction: row; align-items: flex-end;\">\n" +
            "            <div class=\"title\">"+context.context+"</div>\n" +
            "\n" +
            "            </div>\n" +
            "            <div class=\"info2\" style=\"flex-direction: row;\">\n" +
            "            <div><img src=\""+context.userLogoUrl+"\" class=\"headPhoto\"></div>\n" +
            "            <div class=\"info4\">\n" +
            "            <div class=\"info3\" style=\"flex-direction: row; align-items: flex-end\">\n" +
            "            <div style=\"font-size: 15px; color: #6B6B6B; margin-left: 0px;\">"+context.userName+"</div>\n" +
            "\n" +
            "            </div>\n" +
            "            <div class=\"info5\" style=\"flex-direction: row; align-items: center;\">\n" +
            "            <div class=\"fontStyle\" style=\"margin-left: 0px;\">"+context.date+"</div>\n" +
            "\n" +
            "        </div>\n" +
            "        </div>\n" +
            "        </div>\n" +
            "        <div class=\"checkMore\">\n" +
            "\n" +
            "            </div>\n" +
            "            </div>\n" +
            "            </div>\n" +
            "            </div>");


    }
    
    function  changeClass(e) {
        $(".newsTitle").attr("class","newsTitle");
        $(".newsTitle selected").attr("class","newsTitle");
        $(e).attr("class","newsTitle selected");
        
    }

    
}
