layui.use(['element', 'form', 'laydate', 'layer', 'table'], function () {
    let element = layui.element,
        form = layui.form,
        laydate = layui.laydate,
        layer = layui.layer,
        table = layui.table;

    function refreshRegion() {
        $.ajax({
            type: 'get',
            url: nginx_url + '/route/findAllRegions',
            dataType: 'json',
            async: false,
            success: function (result) {
                $.each(result, function (i, item) {
                    let option = '<option value="' + item.city + '">';
                    option += item.city;
                    option += '</option>';
                    $("#city").append(option);
                });
                form.render('select');
            }
        });
    }

    refreshRegion();

    element.on('tab(demo)', function (data) {

        if (data.index === 0) {
            refreshRegion();
        } else {
            table.render({
                elem: '#companyTable',
                height: 'full-170',
                url:"../../../TransferServlet?method=TransferList",
                limit: 10,
                limits: [10],
                page: true //开启分页
                , cellMinWidth: 60
                , cols: [[
                    { title: 'id', fixed: 'left', type: 'numbers', align: 'center' },
                    { field: 'city', title: '所在城市', align: 'center' },
                    { field: 'companyName', title: '公司名称', align: "center" },
                    { field: 'linkPhone', title: '联系方式', align: 'center' },
                    { field: 'detailAddress', title: "公司地址", align: "center", width: 400, fixed: 'right' }
                ]]
            });
        }

        // 监听工具条
    });

    form.on('submit(addCompany)', function () {
        $.ajax({
            type: 'post',
            url: "../../../TransferServlet?method=add",
            data: $("#transferComForm").serialize(),
            dataType: 'text',
            async: false,
            success: function (result) {
                if (result === "SUCCESS") {
                    layer.msg('中转公司添加成功', {
                        time: 800,
                        icon: 1
                    });
                    $("#resetForm").click();
                } else {
                    layer.msg('中转公司添加失败', {
                        time: 800,
                        icon: 2
                    });
                }
            }
        });
        return false;
    });
});