/**
 * Created by xiraly on 2018/6/13.
 */
var userId = '82e705688305435382df908076ba3e66';
layui.use('table', function() {

    var table = layui.table;
    table.render({
        elem: '#tableElem',
        url: '/message/getMessage?userId=' + userId,
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

})