/*
* @Author: Mines
* @Date:   2018-03-26 10:33:40
* @Last Modified by:   Mines
* @Last Modified time: 2018-03-30 09:30:19
*/

$(document).ready(function () {
    var height = $('#login_main').height();
    $('#login_bg').css('height', height);
    var bgImg = new Array();
    $.ajax({

        url: "/img/getBGList",
        success: function (data) {
            for (var i = 0; i < data.list.length; i++) {
                bgImg.push(data.list[i]);
            }
            $('#bg').attr('src', "../" + data.list[0].imgUrl);
            $('#BGName').html(data.list[0].imgName);
            $("#userName").html(data.list[0].userName);
            $('#userLogoImg').attr('src',data.list[0].userLogoUrl);

        },
        error: function (data) {
            alert(data.list)
           alert("网络异常，请联系维护人员", function () {
            });
        }
    });
    var flag = 1;
    setInterval(function () {
        changeBGImg(bgImg[flag]);
        if (flag >= bgImg.length-1) {
            flag = 0;
        } else {
            flag+=1;
        }

    },10000);

})


function changeBGImg(imgObj) {
    $('#bg').fadeOut(1000);
    $('#user').fadeOut(1000);
    setTimeout(function(){
        $('#bg').attr('src', "../" + imgObj.imgUrl);
        $('#BGName').html(imgObj.imgName);
        $("#userName").html(imgObj.userName);
        $('#userLogoImg').attr('src',imgObj.userLogoUrl);
    },1000);

    $('#bg').fadeIn(1000);
    $('#user').fadeIn(1000);

}


function login() {
    var username = $('#account').val();
    var password = $('#password').val();
    $.ajax({
        data:{userName:username,password:password},
        url: "/login",
        success: function (data) {
            if(data.msg == 1) {
                location.href = "/goIndex";
            }else  if(data.msg == 2){
                alert("密码错误");
            }else if(data.msg == 3){
                alert("帐号不存在或者帐号错误");
            }

        },
        error: function (data) {
            alert(data.msg)

            alert("密码错误", function () {
            });
        }

    })




}


function register(e) {


        $(".login_bt").text("注册");
        $(e).text( "返回");
        $(".login_bt").attr("onclick","insert()");
        $(".register_bt").attr("onclick","back(this)");
        $("#account").attr("placeholder","请输入你的用户名");
        $("#password").attr("placeholder","请输入你的密码");





}

function insert() {
    var userName = $("#account").val();
    var password = $("#password").val();
    $.ajax({
        url: "/register",
        data: {userName: userName, password: password},
        success: function (data) {
            if (data.result === true) {
                location.href = "/";
            }
        }

    })
}

function back(e) {
    $(".login_bt").text("登录");
    $(e).text( "注册");
    $(".login_bt").attr("onclick","login()");
    $(".register_bt").attr("onclick","register(this)");
    $("#account").attr("placeholder","帐号");
    $("#password").attr("placeholder","密码");

}

