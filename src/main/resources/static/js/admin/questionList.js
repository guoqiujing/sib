/**
 * Created by Administrator on 2018/6/9.
 */
layui.use('table', function() {

    var table = layui.table;
    table.render({
        elem: '#tableElem',
        url: '/admin/question/list',
        request: {
            pageName: 'page' //页码的参数名称，默认：page
            ,limitName: 'size' //每页数据量的参数名，默认：limit
        },
        page: true,
        cols: [
            [
                {type:'checkbox'},
                { field: 'question', title: '题干', width:300, sort: true },
                { field: 'title', title: '所属题库', width:80, sort: true },
                { field: 'userId', title: '创建者' ,  sort: true },
                { field: 'answer', title: '答案', sort: true },
                { field: 'analysis', title: '分析', sort: true },
                { field: 'frequency', title: '练习人次', width:100, sort: true },
                { field: 'starLevel', title: '综合评级', width:100, sort: true },
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
