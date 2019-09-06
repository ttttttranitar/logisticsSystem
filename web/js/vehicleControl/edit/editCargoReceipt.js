layui.use(['element', 'form', 'laydate', 'layer', 'table'], function() {
    let element = layui.element,
        form = layui.form,
        laydate = layui.laydate,
        layer = layui.layer,
        table = layui.table;

    lay('.test-item').each(function () {
        laydate.render({
            elem: this,
            trigger: 'click'
        })
    });

    $.ajax({
        type: "get",
        url: "../../../TransportServlet?method=show&limit=10",
        dataType:"json",
        async: false,
        success: function (result) {
            $.each(result.data, function (i, item) {
                let option = "<option value='" + item.transport_id + "'>";
                option += item.transport_id;
                option += "</option>";
                $("#goodsRevertBillCode").append(option);
            });
            form.render('select');
        }
    });

    $.ajax({
        type: 'post',
        url: "../../../DriverServlet?method=driverListPage&limit=10",
        dataType: 'json',
        async: false,
        success: function (result) {
            $.each(result.data, function (i, item) {
                let option = '<option value="' + item.driver_id + '">';
                option += item.driver_id;
                option += '</option>';
                $("#driver").append(option);
                /*$("#dealGoodsStation").append(option);*/
            });
            form.render('select');
        }
    });

    form.on('select(changeSend)', function (data) {
        // ajax
        $.ajax({
            type: 'get',
            url:"../../../TransportServlet?method=get&transportId="+$("#goodsRevertBillCode").val(),
            dataType:"json",
            success: function (result) {
                $("#startDate").val(result.start_date);
                $("#endDate").val(result.end_date);
                $("#transportFee").val(result.transport_fee);
                $("#insuranceFee").val(result.insurance_fee);
                $("#start").val(result.transport_start);
                $("#distination").val(result.transport_distinatin);
                $("#remark").val(result.transport_info);
            }
        });
    });

    form.on('select(changeSend2)', function (data) {
        // ajax
        $.ajax({
            type: 'post',
            url:"../../../DriverServlet?method=particulars&driverId="+$("#driver").val(),
            dataType:"json",
            success: function (result) {
                $("#driverName").val(result.driver_name);
                $("#driverPhone").val(result.driver_phone);
                $("#carId").val(result.car_id);
                $("#driverLicence").val(result.driver_license);
                $("#driverPermission").val(result.driver_permit);
            }
        });
    });

    laydate.render({
        elem: '#signTime',
        value: new Date()
    });

    // 货运单回执信息添加
    form.on('submit(addCargoReceipt)', function () {

        $("#receiveGoodsLinkman").removeAttr("disabled");
        $("#linkmanPhone").removeAttr("disabled");
        $("#receiveGoodsDetailAddr").removeAttr("disabled");
        $("#backBillState").removeAttr("disabled");

        $.ajax({
            type: "post",
            url: nginx_url + "/vehicle/add",
            data: $("#cargoReceiptForm").serialize(),
            dataType: "json",
            async: false,
            success: function (result) {
                if (result === "SUCCESS") {
                    layer.msg('货运回执单添加成功', {
                        time: 800,
                        icon: 1
                    });
                    $("#resetForm").click();
                } else {
                    layer.msg('货运回执单添加失败', {
                        time: 800,
                        icon: 2
                    });
                }
            }
        });
        return false;
    });

});