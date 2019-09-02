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

    $("#goToMod").click(function () {
        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        parent.layer.close(index); //再执行关闭

    })

});