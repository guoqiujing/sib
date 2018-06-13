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
            , limitName: 'size' //每页数据量的参数名，默认：limit
        },
        page: true,
        cols: [
            [
                {type: 'checkbox'},
                {field: 'question', title: '题干', width: 300, sort: true},
                {field: 'title', title: '所属题库', width: 200, sort: true},
                {field: 'userId', title: '创建者', sort: true},
                {field: 'answer', title: '答案', sort: true},
                {field: 'analysis', title: '分析', sort: true},
                {field: 'starLevel', title: '综合评级', width: 100, sort: true},
                {field: 'status', title: '状态', width: 80, sort: true},
                {field: 'createTime', title: '创建时间', width: 200, sort: true},
                {fixed: 'right', title: '操作', align: 'center', toolbar: '#table_bar'}
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
        }
        else if (obj.event === 'del') {
            layer.confirm('真的下线这条题目' + data.id + "?", {icon: 3, title: '提醒', shade: 0, offset: 't'}, function () {
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
//自定義事件處理
    $(document).ready(function(e) {

        ///搜索题库
        $("#bt_search").click(function(e) {
            var search_question = $('#search_question').val();
            var search_title = $('#search_title').val();
            var search_userId = $('#search_userId').val();
            //执行重载
            layui.table.reload('tableReload', {
                url: '/admin/question/info',
                where:{
                    question: search_question,
                    title: search_title,
                    userId: search_userId
                }
            });
        });
        //刷新页面
        $("#bt_refresh").click(function(e) {
            window.location.reload()
        });

    });
});
