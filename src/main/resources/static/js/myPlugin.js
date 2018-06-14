/**
 * Created by Administrator on 2018/6/14.
 */
//全局函数
jQuery.myPlugin={
    //获取userId
    getUserId:function () {
        var userId = null;
        $.ajax({
            url: '/session/user',
            type: 'get',
            contentType: "application/json",
            async: false,
            success: function(res) {
                console.log(res)
                if(res.code == '0'){
                    userId = res.data.id;
                }
            },
        })
        return userId;
    }
};