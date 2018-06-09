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
                { field: 'sender', title: '发送者', width:300, sort: true },
                { field: 'questionId', title: '题目编号', width:80, sort: true },
                { field: 'bankId', title: '题库编号' ,  sort: true },
                { field: 'message', title: '反馈信息', sort: true },
                { field: 'status', title: '状态', width:80, sort: true },
                { field: 'createTime', title: '创建时间', width:200, sort: true },
                { fixed: 'right', title: '操作',  align: 'center', toolbar: '#table_bar' }
            ]
        ],
        id: 'tableReload'
    });
    //监听表格复选框选择
    table.on('checkbox(demo)', function(obj){
        console.log(obj)
    });

})
