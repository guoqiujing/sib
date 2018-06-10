/**
 * Created by Administrator on 2018/6/9.
 */
layui.use('table', function() {

    var table = layui.table;
    table.render({
        elem: '#tableElem',
        url: '/admin/points/info/User',
        request: {
            pageName: 'page' //页码的参数名称，默认：page
            ,limitName: 'size' //每页数据量的参数名，默认：limit
        },
        page: true,
        cols: [
            [
                {type:'checkbox'},
                { field: 'userId', title: '创建者' ,width:400,  sort: true },
                { field: 'value', title: '变动值',sort: true },
                { field: 'note', title: '变动说明', width:900,sort: true },
                { field: 'createTime', title: '创建时间', width:200, sort: true },
            ]
        ],
        id: 'tableReload'
    });
    //监听表格复选框选择
    table.on('checkbox(demo)', function(obj){
        console.log(obj)
    });

})
/**
 * Created by Administrator on 2018/6/10.
 */
