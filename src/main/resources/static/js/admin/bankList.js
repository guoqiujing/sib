/**
 * Created by Administrator on 2018/6/9.
 */
var userId = '82e705688305435382df908076ba3e66';
<!--layui表格相关处理-->
layui.use('table', function() {
    var table = layui.table;
    table.render({
        elem: '#tableElem',
        url: '/admin/questionBank/list',
        request: {
            pageName: 'page' //页码的参数名称，默认：page
            ,limitName: 'size' //每页数据量的参数名，默认：limit
        },
        page: true,
        cols: [
            [
                {type:'checkbox'},
                { field: 'title', title: '标题', width:300, sort: true },
                { field: 'value', title: '分值', width:80, sort: true },
                { field: 'userId', title: '创建者' , width:400, sort: true },
                { field: 'categoryName', title: '所属类型', sort: true },
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
    //监听工具条
    table.on('tool(demo)', function(obj) {
        var data = obj.data;
        if (obj.event === 'detail') {
            $("#select_id").val(data.id)
            $("#select_title").val(data.title)
            $("#select_intro").val(data.intro)
            $("#select_createtime").val(data.createTime)
            // $("#select_userId").val(data.userId)
            $("#select_bankType").val(data.categoryName)
            $("#select_frequency").val(data.frequency)
            $("#select_count").val(data.count)
            $("#select_status").val(data.status)
            layui.use('layer', function() {
                layer.open({
                    type: 1,
                    title: '查看题库详情',
                    shadeClose: true,
                    shade: 0,
                    offset:'t',
                    area: ['630px', '600px'],
                    content: $("#details_form_div"),
                });
            });
        } else if (obj.event === 'edit') {
            $("#edit_id").val(data.id)
            $("#edit_title").val(data.title)
            $("#edit_intro").val(data.intro)
            $("#edit_status").val(data.status)
            layui.use('layer', function() {
                layer.open({
                    type: 1,
                    title: '修改题库信息',
                    shadeClose: true,
                    shade: 0,
                    offset:'t',
                    area: ['630px', '620px'],
                    content: $("#edit_form_div"),
                });
            });
        } else if (obj.event === 'del') {
            layer.confirm('真的删除' + data.id + "?",{icon:3,title:'提醒',offset:'t'}, function() {
                $.ajax({
                    type: "delete",
                    url: "/questionBank/info/"+data.id,
                    success: function(res) {
                        if (res.code == "0") {
                            obj.del();
                        }
                        layer.alert(res.msg,{icon:3,offset:'t'});
                    }
                });
            });
        }
    });
    var $ = layui.$, active = {
        add: function () {
            layui.use('layer', function() {
                $("#add_title").val('')
                $("#add_intro").val('')
                layui.form.render('select', 'add_form');
                layer.open({
                    type: 1,
                    title: '添加题库',
                    shadeClose: true,
                    shade: 0,
                    offset: 't',
                    area: ['630px', '520px'],
                    content: $('#add_form_div'),
                });
            });
        },
        batchDel: function(){ //获取选中数据
            var checkStatus = table.checkStatus('tableReload')
            var data = checkStatus.data
            if(data.length<=0){
                layer.alert("请选择数据",{offset:'t'})
            }else{
                layer.confirm('真的要删除这'+data.length+'条数据吗？',
                    {icon:3,title:'提醒',offset:'t'}
                    ,function () {
                        for(var i in data){
                            var id = data[i].id
                            $.ajax({
                                type: "delete",
                                url: "/questionBank/info/"+id,
                                success: function(res) {
                                    if (res.code == "0") {
                                        console.log(res.msg)
                                    }else{
                                        layer.alert(res.msg,{icon: 2,offset: 't'})
                                    }
                                }
                            });
                        }
                        table.reload('tableReload', {});
                    }
                )
            }
        }
    };
    $('.demoTable .layui-btn').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
});

layui.use(['form'], function() {
    var form = layui.form,
        layer = layui.layer;
    //自定义验证规则
    form.verify({
        name: function(value) {
            if (value.length < 3 || value.length > 12) {
                return '名称长度需控制在3-12内';
            }
        },
        intro: function(value) {
            if (value.length < 5 || value.length > 100) {
                return '介绍长度需控制在5-100内';
            }
        }
    });
    // 提交修改到后台
    form.on('submit(edit_sub)', function(data) {
        $.ajax({
            url: '/questionBank/info',
            type: 'put',
            contentType: "application/json",
            data: JSON.stringify(data.field),
            async: false,
            success: function(res) {
                layer.alert(res.msg, {icon: 1,offset:'t'},function() {
                    //执行重载
                    layui.table.reload('tableReload', {});
                    layer.closeAll();
                });
            },
            fail: function(res) {
                layer.alert(res,{icon: 2,offset:'t'})
            }
        })
        return false;
    });
    // 提交add事件到后台
    form.on('submit(add_sub)', function(data) {
        $.ajax({
            url: '/questionBank/info',
            type: 'post',
            contentType: "application/json",
            data: JSON.stringify(data.field),
            async: false,
            success: function(res) {
                console.log("success");
                if(res.code=='0'){
                    layer.alert(res.msg,{icon: 1,offset: 't'}, function(index) {
                        //刷新表格,执行重载
                        layui.table.reload('tableReload', {});
                        //关闭弹出层
                        layer.closeAll();
                    });
                }else{
                    layer.alert(res.msg,{icon: 2,offset: 't'})
                }
            },
            fail: function() {
                layer.alert("请求失败，请重试",{icon: 2,offset: 't'})
            }
        })
        return false;
    });
})
