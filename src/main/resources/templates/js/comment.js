$(function(){
    $('#text_txt1').on('keyup',function(){
        var txtval = $('#text_txt1').val().length;
        console.log(txtval);
        var str = parseInt(150-txtval);
        txtval = parseInt(txtval);
        console.log(str);
        if(str > 0 ){
            $('#num_txt1').html(txtval+'/140');
        }else{
            $('#num_txt1').html('140/140');
            $('#text_txt1').val($('#text_txt1').val().substring(0,140)); //这里意思是当里面的文字小于等于0的时候，那么字数不能再增加，只能是600个字
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

var zNodes =[
    { id:1, pId:0, name:"大家的动态", url:"https://www.baidu.com/", target:"_self",font:{'color':'#5CACEE'}},
    { id:2, pId:0, name:"全部动态", url:"https://www.bilibili.com/", target:"_self",font:{'color':'#5CACEE'}},
    { id:3, pId:0, name:"关注的用户的动态", url:"https://www.qq.com/", target:"_self",font:{'color':'#5CACEE'}},
    { id:4, pId:0, name:"好P友的动态", url:"", target:"_self", font:{'color':'#5CACEE'}},
    { id:5, pId:0, name:"你的动态", url:"", target:"_self", font:{'color':'#5CACEE'}}
];

function showIconForTree(treeId, treeNode) {
    return !treeNode.isParent;
};

function getFont(treeId, node) {
    return node.font ? node.font : {};
}

$(document).ready(function(){
    $.fn.zTree.init($("#treeDemo"), setting, zNodes);
});
