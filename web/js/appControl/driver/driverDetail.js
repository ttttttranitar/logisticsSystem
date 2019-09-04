layui.use(['layer', 'form', 'element', 'laydate', 'jquery', 'table'], function() {
    var element = layui.element,
        $ = layui.jquery,
        form = layui.form,
        layer = layui.layer,
        laydate = layui.laydate,
        table = layui.table;

    form.render();

    var driverId = window.location.href.split("=")[1];

    $.ajax({
        type: 'get',
        url:'../../../DriverServlet?method=particulars&driverId=' + driverId,
        dataType: 'json',
        success: function (result) {
            /*$.each(result, function (i, item) {
                var temp_id = '#' + i;
                $(temp_id).val(item);
            });
            $(":radio[name='gender'][value='" + result.gender + "']").prop("checked", "checked");
            form.render('radio');
            laydate.render({
                elem: '#birthday',
                type: 'date',
                value: new Date(result.birthday)
            });
            if (result.companyCar === true) {
                $("#switchValue").attr("checked", "checked");
            }
            form.render('checkbox');*/
            console.log(result);
            $("#driverName").val(result.driver_name);
            $("#idCard").val(result.card);
            $("#phone").val(result.driver_phone);
            $("#gender").val(result.sex);
            $("#birthday").val(result.birthdate);
            $("#carNo").val(result.car_id);
            $("#carType").val(result.car_type);
            $("#allowCarryVolume").val(result.car_volume);
            $("#allowCarryWeight").val(result.car_weight);
            $("#address").val(result.address);
            $("#carLength").val(result.car_lenght);
            $("#carWidth").val(result.car_width);
            $("#goodsHeight").val(result.car_height);
            $("#driveLicence").val(result.driver_license);
            $("#runLicence").val(result.driver_permit);
            $("#bizLicence").val(result.operation_license);
            $("#insuranceCard").val(result.insurance_license);
            $("#carFrameNo").val(result.vIN);
            $("#engineNo").val(result.motor_id);
            $("#carDept").val(result.company);
            $("#carDeptTel").val(result.company_tel);
            $("#remark").val(result.driver_info);
        }
    })
});