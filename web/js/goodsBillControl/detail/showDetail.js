layui.use(['element', 'form', 'laydate', 'jquery', 'layer', 'table'], function() {
    let element = layui.element,
        form = layui.form,
        laydate = layui.laydate,
        layer = layui.layer,
        table = layui.table,
        $ = layui.jquery;

    let transport_id = window.location.href.split("=")[1];//读取参数运单id
    $.ajax({
        type: "post",
        url: "../../../TransportServlet?method=get",
        data:"transportId="+transport_id,
        dataType:"json",
        async: false,
        success: function (result) {
            $("#transportId").val(result.transport_id);
            $("#sendGoodsDate").val(result.start_date);
            $("#receiveGoodsDate").val(result.end_date);
            $("#sendGoodsAddr").val(result.transport_start);
            $("#receiveGoodsAddr").val(result.transport_distinatin);
            $("#payMode").val(result.pay_type);
            $("#carriage").val(result.transport_fee);
            $("#insurance").val(result.insurance_fee);
            $("#remark").val(result.transport_info);
            /*$.each(result, function (i, item) {
                let temp_id = '#' + i;
                $(temp_id).val(item);
            });

            // 审核
            if (result.ifAudit === '审核') {
                $("#ifAudit").attr('checked', 'checked');
                form.render('checkbox');
            }

            // 有效
            if (result.validity === '有效') {
                $("#validity").attr('checked', 'checked');
                form.render('checkbox');
            }

            // 结账
            if (result.ifSettleAccounts === '结账') {
                $("#ifSettleAccounts").attr('checked', 'checked');
                form.render('checkbox');
            }

            // 日期
            laydate.render({
                elem: '#sendGoodsDate',
                type: 'date',
                value: new Date(result.sendGoodsDate)
                // theme: 'grid'
            });
            laydate.render({
                elem: '#predeliveryDate',
                type: 'date',
                value: new Date(result.predeliveryDate)
                // theme: 'grid'
            });
            if (result.factDealDate != null && result.factDealDate !== '') {
                laydate.render({
                    elem: '#factDealDate',
                    type: 'date',
                    value: new Date(result.factDealDate)
                    // theme: 'grid'
                });
            }

            laydate.render({
                elem: '#writeDate',
                type: 'date',
                value: new Date(result.writeDate)
                // theme: 'grid'
            });
        */
        }

    });

});