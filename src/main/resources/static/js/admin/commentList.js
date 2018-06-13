/**
 * Created by xiraly on 2018/6/13.
 */
layui.use('table', function() {

    var table = layui.table;
    table.render({
        elem: '#tableElem',
        url: '/admin/comment/comment',
        request: {
            pageName: 'page' //页码的参数名称，默认：page
            ,limitName: 'size' //每页数据量的参数名，默认：limit
        },
        page: true,
        cols: [
            [
                {type:'checkbox'},
                { field: 'nickname', title: '用户昵称', width:110, sort: true },
                { field: 'question', title: '题目', sort: true },
                { field: 'bankTitle', title: '题库标题', width:200 , sort: true },
                { field: 'content', title: '评论', width:200 ,sort: true },
                { field: 'available', title: '状态', width:80, sort: true },
                { field: 'createTime', title: '评论时间', width:150, sort: true },
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

        ///搜索评论信息
        $("#bt_search").click(function(e) {
            var search_nickname = $('#search_nickname').val();
            var search_title = $('#search_title').val();
            var search_question = $('#search_question').val();
            //执行重载
            layui.table.reload('tableReload', {
                url: '/admin/comment/comment',
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