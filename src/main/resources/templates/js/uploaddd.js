$(function () {
    tabs('#oauthTabs', 'click');
    // 标题字数
    $('#text_txt1').on('keyup',function(){
        var txtval = $('#text_txt1').val().length;
        console.log(txtval);
        var str = parseInt(32-txtval);
        txtval = parseInt(txtval);
        console.log(str);
        if(str > 0 ){
            $('#num_txt1').html(txtval+'/32');
        }else{
            $('#num_txt1').html('32/32');
            $('#text_txt1').val($('#text_txt1').val().substring(0,32)); //这里意思是当里面的文字小于等于0的时候，那么字数不能再增加，只能是600个字
        }
        //console.log($('#num_txt').html(str));
    });
    // 说明文字数
    $('#text_txt2').on('keyup',function(){
        var txtval = $('#text_txt2').val().length;
        console.log(txtval);
        var str = parseInt(3000-txtval);
        txtval = parseInt(txtval);
        console.log(str);
        if(str > 0 ){
            $('#num_txt2').html(txtval+'/3000');
        }else{
            $('#num_txt2').html('3000/3000');
            $('#text_txt2').val($('#text_txt2').val().substring(0,3000)); //这里意思是当里面的文字小于等于0的时候，那么字数不能再增加，只能是600个字
        }
        //console.log($('#num_txt').html(str));
    });

    $("input[type='file']").change(function(){
        var file = this.files[0];
        if (window.FileReader) {
            var reader = new FileReader();
            reader.readAsDataURL(file);
            //监听文件读取结束后事件
            reader.onloadend = function (e) {
               alert(e.target.result);    //e.target.result就是最后的路径地址
            };
        }
    });
});

//Tab控制选项卡
function tabs(tabObj, event) {
    //绑定事件
    var tabItem = $(tabObj).find(".tab-head div[name=tabName]");
    tabItem.bind(event, function () {
        //设置点击后的切换样式
        tabItem.removeClass("selected");
        $(this).addClass("selected");
        //设置点击后的切换内容
        // var tabNum = tabItem.parent().index($(this).parent());
        if ($("#paint").hasClass("selected")) {
            $("#tabNum").val(0);
        }
        if ($("#gif").hasClass("selected")) {
            $("#tabNum").val(1);
        }
        if ($("#manga").hasClass("selected")) {
            $("#tabNum").val(2);
        }
        if ($("#novel").hasClass("selected")) {
            $("#tabNum").val(3);
        }
        var tabNum = $("#tabNum").val();
        $(tabObj).find(".tab-content").hide();
        $(tabObj).find(".tab-content").eq(tabNum).show();
    });
}


var imgurl = "";
function getPhoto(node) {
    var imgURL = "";
    var realURL = null;
    try{
        var file = null;
        if(node.files && node.files[0] ){
            file = node.files[0];
        }else if(node.files && node.files.item(0)) {
            file = node.files.item(0);
        }
        //Firefox 因安全性问题已无法直接通过input[file].value 获取完整的文件路径
        try{
            imgURL =  file.getAsDataURL();
        }catch(e){
            imgRUL = window.URL.createObjectURL(file);
        }
    }catch(e){
        if (node.files && node.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                imgURL = e.target.result;
            };
            reader.readAsDataURL(node.files[0]);
        }
    }
    if (window.FileReader) {
        var reader = new FileReader();
        reader.readAsDataURL(file);
        //监听文件读取结束后事件
        reader.onloadend = function (e) {
            realURL = e.target.result;
            creatImg(imgRUL,realURL);    //e.target.result就是最后的路径地址
        };
    }


    return imgURL;
}

function creatImg(imgRUL,name){
    var textHtml = "<div  class='imgItem'><button class='imgItemBtn' type='button' onclick='removeSelf(this)' >X</button><img src='"+imgRUL+"'width='100%' name='"+name+"' /></div>";
    $(".imgs").append(textHtml);
}

function removeSelf(e) {
    $(e).parent().remove();
    $('xFile').value = null;



}
var ImgList ;
function getImgList() {
    ImgList = new Array();
    var list = $('#imgs').find('.imgItem');
    for(var i=0;i<list.length;i++){
        var img = new Object();
        img.imgUrl = $(list[i]).find('img').attr('name');
        img.imgName = $('#text_txt1').val();
        img.imgContent = $('#text_txt2').val();

        ImgList.push(img);
        

    }
}

function getObjectURL(file) {
    var url = null;
    if (window.createObjcectURL != undefined) {
        url = window.createOjcectURL(file);
    } else if (window.URL != undefined) {
        url = window.URL.createObjectURL(file);
    } else if (window.webkitURL != undefined) {
        url = window.webkitURL.createObjectURL(file);
    }
    return url;
}

function upload() {
    getImgList();
    var data = JSON.stringify(ImgList);
    $.ajax({
        url:"/img/upload",
        data:{imgList:data},
        success:function () {
            alert("上传成功");
        }

    })

}





