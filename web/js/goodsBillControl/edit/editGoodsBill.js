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
        url: "../../../OrderServlet?method=showClients",
        data:'limit='+10,
        async: false,
        dataType:"JSON",
        success: function (result) {
            $.each(result.data, function (i, item) {
                var  option = "<option value='" + item.customer_id + "'>";//从返回的用户表中得到每一个用户id
                option += item.customer_id;
                option += "</option>";
                $("#receiveGoodsCustomerNo").append(option);
                $("#sendGoodsCustomerNo").append(option);

                form.render();
            });
        }

    });


    form.on('select(sendGoodsCustomerNo)', function (data) {
        // ajax获取客户信息
        $.ajax({
            type: 'post',
            url: '../../../OrderServlet?method=getClient'+"&clientId="+$("#sendGoodsCustomerNo").val(),//请求servlet
            dataType:"JSON",
            success: function (result) {
                $("#Shipping_custome").val(result.customer_name);//自动生成相关数据
                $("#Shipping_custome_phone").val(result.contact_phone);
                $("#Shipping_customer_address").val(result.site);
            }
        });
    });

    form.on('select(receiveGoodsCustomerNo)', function (data) {
        // ajax
        $.ajax({
            type: 'post',
            dataType:"JSON",
            url: '../../../OrderServlet?method=getClient'+"&clientId="+ $("#receiveGoodsCustomerNo").val(),
            success: function (result) {
                $("#Receiving_customer").val(result.customer_name);
                $("#Receiving_customer_phone").val(result.contact_phone);
                $("#Receiving_customer_address").val(result.site);
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
        $("#goodsBillForm :input").each(function () {
            $(this).removeAttr("disabled");
        });
        $("#factDealDate").attr("disabled", "disabled");
        $("#transferFee").attr("disabled", "disabled");
        $("#moneyOfChangePay").attr("disabled", "disabled");

        $.ajax({//通过ajax提交表单
            type: "post",
            url: "../../../OrderServlet?method=add",
            data: $("#goodsBillForm").serialize(),
            dataType: "text",
            async: false,
            success: function (result) {
                if (result == "SUCCESS") {
                    layer.msg('订单添加成功', {
                        time: 800,
                        icon: 1},
                        function () {
                            let index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                            parent.layer.close(index); //再执行关闭
                            window.parent.location.reload();//新增成功后刷新父界面
                        }
                    );
                /*    layer.open({
                        type: 2,
                        title: '货运单编号：' + result.goodsBillCode,
                        content: [ 'editGoods.html?id=' + result.goodsBillCode, 'no' ],
                        area: [ '85%', '85%' ],
                        shadeClose: true,
                        move: false
                    });*/
                    $("#resetForm").click();
                } else {
                    layer.msg('订单添加失败', {
                        time: 800,
                        icon: 2
                    });
                }
                console.log(result);
            }
        });
        return false;//通过表单提交
    });



});