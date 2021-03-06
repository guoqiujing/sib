/**
 * Created by xiraly on 2018/6/9.
 */
layui.use('table', function() {

    var table = layui.table;
    table.render({
        elem: '#tableElem',
        url: '/admin/message/getList',
        request: {
            pageName: 'page' //页码的参数名称，默认：page
            ,limitName: 'size' //每页数据量的参数名，默认：limit
        },
        page: true,
        cols: [
            [
                {type:'checkbox'},
                { field: 'nickname', title: '反馈者昵称', width:110, sort: true },
                { field: 'question', title: '题目', sort: true },
                { field: 'bankTitle', title: '题库标题', width:200 , sort: true },
                { field: 'message', title: '反馈信息', width:200 ,sort: true },
                { field: 'status', title: '状态', width:80, sort: true },
                { field: 'createTime', title: '反馈时间', width:150, sort: true },
            ]
        ],
        id: 'tableReload'
    });
    //监听表格复选框选择
    table.on('checkbox(demo)', function(obj){
        console.log(obj)
    });

    //自定義事件處理
    $(document).ready(function(e) {

        ///搜索反馈信息
        $("#bt_search").click(function(e) {
            var search_nickname = $('#search_nickname').val();
            var search_title = $('#search_title').val();
            var search_question = $('#search_question').val();
            //执行重载
            layui.table.reload('tableReload', {
                url: '/admin/message/getList',
                where:{
                    nickname:search_nickname,
                    bankTitle: search_title,
                    question: search_question
                }
            });
        });
        //刷新页面
        $("#bt_refresh").click(function(e) {
            window.location.reload()
        });

});
})
