/**
 * Created by Administrator on 2018/6/9.
 */
layui.use('table', function() {

    var table = layui.table;
    table.render({
        elem: '#tableElem',
        url: '/admin/user/list',
        request: {
            pageName: 'page' //页码的参数名称，默认：page
            ,limitName: 'size' //每页数据量的参数名，默认：limit
        },
        page: true,
        cols: [
            [
                {type:'checkbox'},
                { field: 'id', title: '用户编号', width:300, sort: true },
                { field: 'name', title: '用户名', width:100, sort: true },
                { field: 'nickname', title: '用户昵称' ,  sort: true },
                { field: 'icon', title: '用户头像', sort: true },
                { field: 'phone', title: '用户手机', sort: true },
                { field: 'email', title: '用户邮箱', width:100, sort: true },
                { field: 'wxid', title: '用户微信编号', width:100, sort: true },
                { field: 'value', title: '用户积分', width:80, sort: true },
                { field: 'createTime', title: '用户创建时间', width:200, sort: true },
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
/**
 * Created by Administrator on 2018/6/10.
 */
