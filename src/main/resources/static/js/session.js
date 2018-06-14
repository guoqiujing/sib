/**
 * Created by Administrator on 2018/6/14.
 */
$(function (){
    $.ajax({
        url: '/session/user',
        type: 'get',
        contentType: "application/json",
        async: false,
        success: function(res) {
            console.log(res)
            if(res.code == '0'){
                $("#user_name").text(res.data.name);
                $('#user_icon').attr("src", res.data.icon);
            }
        },
        fail: function(res) {
            layer.alert(res,{icon: 2,offset:'t'})
        }
    })
})
