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

        url: "/background/getBGList",
        success: function (data) {
            for (var i = 0; i < data.list.length; i++) {
                bgImg.push(data.list[i]);
            }
            $('#bg').attr('src', "../" + data.list[0].imgUrl);
            $('#BGName').html(data.list[0].imgName);
            $("#userName").html(data.list[0].userName);
            $('#userLogoImg').attr('src',data.list[0].userLogoUrl);

        },
        error: function () {
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
        dataType:JSON,
        url: "/login",
        success: function (data) {
            alert("1111111111");

        },
        error: function () {
            alert("网络异常，请联系维护人员", function () {
            });
        }

    })

}


