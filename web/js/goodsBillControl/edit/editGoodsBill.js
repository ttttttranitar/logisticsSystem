layui.use(['element', 'form', 'laydate', 'layer', 'table', 'jquery'], function() {
    var element = layui.element,
        form = layui.form,
        laydate = layui.laydate,
        layer = layui.layer,
        table = layui.table,
        $ = layui.jquery;

    lay('.test-item').each(function () {
        laydate.render({
            elem: this,
            trigger: 'click'
        })
    });

    laydate.render({
        elem: '#writeDate',
        value: new Date()
    });

    laydate.render({
        elem: '#sendGoodsDate',
        value: new Date()
    });

    var employeeId = $.cookie('loginId');
    $("#writeBillPerson").val(employeeId);
    $("#employeeCode").val(employeeId);

    $.ajax({
        type: "get",
        url: "../../../OrderServlet?method=show",
        data:'limit='+10,
        async: false,
        success: function (result) {
            $.each(result.data, function (i, item) {
                var  option = "<option value='" + item.customer_id + "'>";//从返回的用户表中得到每一个用户id
                option += item.customer_id;
                option += "</option>";
                $("#sendGoodsCustomerNo").append(option);
                $("#receiveGoodsCustomerNo").append(option);
                form.render();
            });
        }

    });


    form.on('select(changeSend)', function (data) {
        // ajax获取客户信息
        $.ajax({
            type: 'post',
            url: '../../../OrderServlet?method=get'+"&orderId="+$("#sendGoodsCustomerNo").val(),//请求servlet
            dataType:"JSON",
            success: function (result) {
                $("#sendGoodsCustomer").val(result.customer_name);//自动生成相关数据
                $("#sendGoodsCustomerTel").val(result.phone);
                $("#sendGoodsCustomerAddr").val(result.site);
            }
        });
    });

    form.on('select(changeSend2)', function (data) {
        // ajax
        $.ajax({
            type: 'post',
            dataType:"JSON",
            url: '../../../OrderServlet?method=get'+"&orderId="+ $("#receiveGoodsCustomerNo").val(),
            success: function (result) {
                $("#receiveGoodsCustomer").val(result.customer);
                $("#receiveGoodsCustomerTel").val(result.phone);
                $("#receiveGoodsCustomerAddr").val(result.address);
            }
        });
    });

    form.on('switch(checkSettle)', function(data){
        if (data.elem.checked === true) {
            $("#ifSettleAccounts").val('true');
        } else {
            $("#ifSettleAccounts").val('false');
        }
        // form.render();
    });

    // 货运单信息添加
    // $("#addGoodsBill").click(function () {
    form.on('submit(addGoodsBill)', function () {
/*
        $("#goodsBillForm :input").each(function () {
            $(this).removeAttr("disabled");
        });
        $("#factDealDate").attr("disabled", "disabled");
        $("#transferFee").attr("disabled", "disabled");
        $("#moneyOfChangePay").attr("disabled", "disabled");

        $.ajax({
            type: "post",
            url: nginx_url + "/goodsBill/add",
            data: $("#goodsBillForm").serialize(),
            dataType: "json",
            async: false,
            success: function (result) {
                if (result.status === "SUCCESS") {
                    layer.msg('货运单添加成功', {
                        time: 800,
                        icon: 1
                    });
                    layer.open({
                        type: 2,
                        title: '货运单编号：' + result.goodsBillCode,
                        content: [ 'editGoods.html?id=' + result.goodsBillCode, 'no' ],
                        area: [ '85%', '85%' ],
                        shadeClose: true,
                        move: false
                    });
                    $("#resetForm").click();
                } else {
                    layer.msg('货运单添加失败', {
                        time: 800,
                        icon: 2
                    });
                }
                console.log(result);
            }
        });*/
        return true;//通过表单提交
    });



});