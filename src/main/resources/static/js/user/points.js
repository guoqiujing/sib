
var userId = '7561211f988441a18ca50f7678eb7ac1';
<!--layui表格相关处理-->
layui.use('table', function() {
    var table = layui.table;
    table.render({
        elem: '#tableElem',
        url: '/points/list?userId=' + userId,
        cols: [
            [
                {field: 'note', title: '记录',  sort: true},
                {field: 'value', title: '分值', sort: true},
                {field: 'createTime', title: '时间',  sort: true},
            ]
        ],
        id: 'tableReload'
    });
})