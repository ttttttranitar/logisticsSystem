layui.use(['element', 'form', 'laydate', 'jquery', 'layer', 'table'], function() {
    var element = layui.element,
        form = layui.form,
        laydate = layui.laydate,
        layer = layui.layer,
        table = layui.table,
        $ = layui.jquery;

    var customerCode = window.location.href.split("=")[1];
    $.ajax({
        type: "get",
        dataType:"JSON",
        data:"customerCode="+customerCode,
        url: "../../../ClientServlet?method=show",
        success: function (result) {
            console.log(result);
            $("#customerCode").val(result.customer_id);
            $("#customer").val(result.customer_name);
            $("#phone").val(result.phone);
            $("#fax").val(result.faxed);
            $("#address").val(result.site);
            $("#postCode").val(result.postcode);
            $("#linkman").val(result.contacts);
            $("#linkmanMobile").val(result.contact_phone);
            $("#customerType").val(result.client_type);
            $("#enterpriseProperty").val(result.enterprise_property);
            $("#enterpriseSize").val(result.enterprise_scale);
            $("#email").val(result.email);
        }
    });

    form.on('submit(modifyCus)', function (data) {
        // console.log(data);
        $.ajax({
            type: 'post',
            url: "../../../ClientServlet?method=Update",
            data: data.field,
            dataType: "text",
            success: function (result) {
                console.log(result);
                if (result === "SUCCESS") {
                    layer.msg('更新成功', {
                        time: 800,
                        icon: 1
                    }, function () {
                        let index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index); //再执行关闭
                        window.parent.location.reload();//新增成功后刷新父界面
                    });
                } else {
                    layer.msg('更新失败', {
                        time: 800,
                        icon: 2
                    });
                }
            }

        });
        return false;
    });

    form.verify({
        fax: function(value, item){ //value：表单的值、item：表单的DOM对象
            if(!new RegExp("^([0-9]{3,4}-)?[0-9]{7,8}$").test(value)){
                return '传真号码格式不正确';
            }
        },
        postcode: function (value, item) {
            if(!new RegExp("^[0-9]{6}$").test(value)){
                return '邮编格式不正确';
            }
        }
    });

});