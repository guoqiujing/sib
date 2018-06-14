var bankQuestion = ''
var userId = $.myPlugin.getUserId();
$(document).ready(function(e) {
    //查询题库列表
    $.ajax({
        type: "get",
        async: false,
        url: '/questionBank/list/way/user?id='+ userId,
        success: function(res) {
            console.log(res)
            $.each(res.data, function(index, item) {
                console.log(item)
                bankQuestion = bankQuestion + "<option  value='" + item.id + "'>" + item.title + "</option>";
            });
            //添加到下拉框
            $("#upload_bankId").append(bankQuestion)
            $("#add_bankId").append(bankQuestion)
        },
        error: function() {

        }
    });

    // 使用jquery.form的ajaxFrom得到提交表单后服务器返回的数据
    $("#upload_form").ajaxForm(function(res) {
        layer.alert(res.msg);
    });
}),
<!--layui表格相关处理-->
layui.use('table', function () {
    var table = layui.table;
    table.render({
        elem: '#tableElem',
        url: '/choice/list/way/user?id=' + userId,
        page: true,
        request: {
            pageName: 'page' //页码的参数名称，默认：page
            ,limitName: 'size' //每页数据量的参数名，默认：limit
        },
        cols: [
            [
                {type:'checkbox'},
                // {field: 'id', title: '编号', sort: true},
                {field: 'question', title: '题干', sort: true},
                {field: 'choiceA', title: '选项A', sort: true},
                {field: 'choiceB', title: '选项B', width: 150, sort: true},
                {field: 'choiceC', title: '选项C', sort: true},
                {field: 'choiceD', title: '选项D', sort: true},
                {field: 'answer', title: '答案', sort: true},
                {field: 'analysis', title: '解析', sort: true},
                {field: 'createTime', title: '创建时间', sort: true},
                {field: 'title', title: '所属题库', sort: true},
                {field: 'status', title: '状态', sort: true},
                {fixed: 'right', title: '操作', align: 'center', toolbar: '#table_bar', width: 200}
            ]
        ],
        id: 'tableReload'
    });
    //监听表格复选框选择
    table.on('checkbox(demo)', function (obj) {
        console.log(obj)
    });
    //监听工具条
    table.on('tool(demo)', function (obj) {
        var data = obj.data;
        if (obj.event === 'detail') {
            $("#select_id").val(data.id)
            $("#select_question").val(data.question)
            $("#select_choiceA").val(data.choiceA)
            $("#select_choiceB").val(data.choiceB)
            $("#select_choiceC").val(data.choiceC)
            $("#select_choiceD").val(data.choiceD)
            $("#select_analysis").val(data.analysis)
            $("#select_answer").val(data.answer)
            $("#select_createtime").val(data.createTime)
            $("#select_bankId").val(data.title)
            $("#select_status").val(data.status)
            layui.use('layer', function () {
                layer.open({
                    type: 1,
                    title: '查看题目详情',
                    shadeClose: true,
                    shade: 0,
                    offset: 't',
                    area: ['630px', '730px'],
                    content: $("#details_form_div"),
                });
            });
        } else if (obj.event === 'edit') {
            $("#edit_id").val(data.id)
            $("#edit_question").val(data.question)
            $("#edit_choiceA").val(data.choiceA)
            $("#edit_choiceB").val(data.choiceB)
            $("#edit_choiceC").val(data.choiceC)
            $("#edit_choiceD").val(data.choiceD)
            $("#edit_analysis").val(data.analysis)
            $("#edit_answer").val(data.answer)
            $("#edit_status").val(data.status)
            layui.use('layer', function () {
                layer.open({
                    type: 1,
                    title: '修改题目信息',
                    shadeClose: true,
                    shade: 0,
                    offset: 't',
                    area: ['630px', '720px'],
                    content: $("#edit_form_div"),
                });
            });
        } else if (obj.event === 'del') {
            layer.confirm('真的删除' + data.id + "?", {icon: 3, title: '提醒', shade: 0,offset: 't'}, function () {
                $.ajax({
                    type: "delete",
                    url: "/admin/question/info/" + data.id,
                    success: function (res) {
                        if (res.code == "0") {
                            obj.del();
                        }
                        layer.alert(res.msg, {offset: 't'});
                    }
                });
            });
        }
    });
    var $ = layui.$, active = {
        add: function () {
            layui.use('layer', function () {
                $("#add_name").val('')
                $("#add_intro").val('')
                layer.open({
                    type: 1,
                    title: '添加题目',
                    shadeClose: true,
                    shade: 0,
                    offset: 't',
                    area: ['630px', '660px'],
                    content: $('#add_form_div'),
                });
            });
        },
        upload: function() {
            layui.use('layer', function() {
                layui.form.render('select', 'upload_form');
                $("#upload_userId").val(userId)
                layer.open({
                    type: 1,
                    title: '批量添加题目',
                    shadeClose: true,
                    shade: 0,
                    offset: 't',
                    area: ['630px', '320px'],
                    content: $('#upload_form_div'),
                });
            });
        },
        batchDel: function () { //获取选中数据
            var checkStatus = table.checkStatus('tableReload')
            var data = checkStatus.data
            if (data.length <= 0) {
                layer.alert("请选择数据", {offset: 't'})
            } else {
                layer.confirm('真的要删除这' + data.length + '条数据吗？',
                    {icon: 3, title: '提醒', offset: 't'}
                    , function () {
                        for (var i in data) {
                            var id = data[i].id
                            $.ajax({
                                type: "delete",
                                url: "/choice/info/" + id,
                                success: function (res) {
                                    if (res.code == "0") {
                                        console.log(res.msg)
                                    } else {
                                        layer.alert(res.msg, {icon: 2, offset: 't'})
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
    $('.demoTable .layui-btn').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
});

layui.use(['form'], function () {
    var form = layui.form,
        layer = layui.layer;
    // 提交修改到后台
    form.on('submit(edit_sub)', function (data) {
        $.ajax({
            url: '/choice/info',
            type: 'put',
            contentType: "application/json",
            data: JSON.stringify(data.field),
            async: false,
            success: function (res) {
                layer.alert(res.msg, {icon: 1, offset: 't'}, function () {
                    //执行重载
                    layui.table.reload('tableReload', {});
                    layer.closeAll();
                });
            },
            fail: function (res) {
                layer.alert(res, {icon: 2, offset: 't'})
            }
        })
        return false;
    });
    // 提交add事件到后台
    form.on('submit(add_sub)', function (data) {
        $.ajax({
            url: '/choice/info',
            type: 'post',
            contentType: "application/json",
            data: JSON.stringify(data.field),
            async: false,
            success: function (res) {
                console.log("success");
                if (res.code == '0') {
                    layer.alert(res.msg, {icon: 1, offset: 't'}, function (index) {
                        //刷新表格,执行重载
                        layui.table.reload('tableReload', {});
                        //关闭弹出层
                        layer.closeAll();
                    });
                } else {
                    layer.alert(res.msg, {icon: 2, offset: 't'})
                }
            },
            fail: function () {
                layer.alert("请求失败，请重试", {icon: 2, offset: 't'})
            }
        })
        return false;
    });
})
