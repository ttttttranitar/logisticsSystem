layui.use(['element', 'form', 'laydate', 'layer', 'table'], function(){
    let element = layui.element,
    form = layui.form,
    laydate = layui.laydate,
    layer = layui.layer,
    table = layui.table;

    let id = window.location.href.split("=")[1];
    $.ajax({
        type: "get",
        data:"administrative_fee_id="+id,
        dataType:"json",
        url: "../../../CostServlet?method=show",
        async: false,
        success: function (result) {
            $("#officeFee").val(result.officeFee);
            $("#houseRent").val(result.houseRent);
            $("#waterElecFee").val(result.waterElecFee);
            $("#phoneFee").val(result.phoneFee);
            $("#otherPayout").val(result.otherPayout);
            $("#writeDate").val(result.writeDate);
        }


    });

});