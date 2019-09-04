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
                    layer.alert('订单添加成功', {
                        time: 800,
                        icon: 1}
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
                    layer.alert('订单添加失败', {
                        time: 800,
                        icon: 2
                    });
                }
                console.log(result);
            }
        });
        return false;//通过表单提交
    });
    element.on('tab(demo)', function(data){
        if (data.index === 1) {
            table.render({
                elem: '#cusTable',
                height: 'full-170',
                url: '../../../OrderServlet?method=show', //数据接口
                limit: 10,
                limits: [ 10 ],
                page: true //开启分页
                ,cellMinWidth: 60
                ,cols: [[
                    { field: 'id', title: 'ID', fixed: 'left', sort: true, type: 'numbers' },
                    { field: 'order_id', title: '订单编号', align: "center", sort: true },
                    { field: 'sender_id', title: '发货客户编号', align: 'center' },
                    { field: 'sender_name', title: '发货客户名称', align: "center" },
                    { field: 'reciever_id', title: '收货客户编号', align: "center", width: 440 },
                    { field: 'reciever_name', title: '收货客户名称', align: "center", width: 180 },
                    { fixed: 'right', title:"操作", align: "center", toolbar: '#barDemo', width: 200 }
                ]]
            });
            // 监听工具条
            table.on('tool(cusTool)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
                var data = obj.data; //获得当前行数据
                var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
                var tr = obj.tr; //获得当前行 tr 的DOM对象
                if (layEvent === 'detail') {
                    layer.open({
                        type: 2,
                        title: '客户详细信息',
                        content: [ 'ordershow.html?order_id=' + data.order_id, 'no' ],
                        area: [ '85%', '85%' ],
                        shadeClose: true,
                        move: false
                    });
                }else if(layEvent === 'del'){ //删除
                    layer.confirm('真的删除么', function(index){
                        obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                        layer.close(index);
                        //向服务端发送删除指令
                        $.ajax({
                            type: "get",
                            url: "../../../OrderServlet?method=del&orderId=" + data.order_id,
                            success: function (result) {
                                console.log(result);
                            }
                        });
                        layer.msg('删除成功', {
                            time: 800
                        })
                    });
                }/*else if(layEvent === 'edit'){ //编辑

                    layer.open({
                        type: 2,
                        title: '客户信息修改',
                        content: [ 'orderModify.html?order_id=' + data.order_id, 'no' ],
                        area: [ '85%', '85%' ],
                        shadeClose: true,
                        move: true
                        /!*end: function() {
                            table.reload('cusTable', {
                                url: "customerModify.html"
                            })
                        }*!/
                    });
                }*/

            });
        }
    });



});