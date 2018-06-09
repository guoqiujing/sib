
var userId = '82e705688305435382df908076ba3e66';
<!--layui表格相关处理-->
layui.use('table', function() {
    var table = layui.table;
    table.render({
        elem: '#tableElem',
        url: '/answerSheet/list/' + userId,
        cols: [
            [
                {type: 'checkbox'},
                {field: 'question', title: '题目题干', sort: true},
                {field: 'bankTitle', title: '所属题库', sort: true},
                {field: 'answer', title: '答题答案',  sort: true},
                {field: 'istrue', title: '答题结果', sort: true},
                {field: 'createTime', title: '答题时间',  sort: true},
                {fixed: 'right', title: '操作', width: 200, align: 'center', toolbar: '#table_bar'}
            ]
        ],
        id: 'tableReload'
    });
})