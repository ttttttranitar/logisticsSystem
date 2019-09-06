layui.use(['element', 'form', 'laydate', 'layer', 'table'], function () {
    let element = layui.element,
        form = layui.form,
        laydate = layui.laydate,
        layer = layui.layer,
        table = layui.table;
    let array = ['/未出合同', '/未到车辆', '/未结合同'];

    refresh(0);

    // 监听工具条
    table.on('tool(cargoReceiptTool)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        let data = obj.data; //获得当前行数据
        let layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        let tr = obj.tr; //获得当前行 tr 的DOM对象

        if(layEvent === 'del'){ //删除
            layer.confirm('真的删除么', function(index){
                obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                layer.close(index);
                //向服务端发送删除指令
                $.ajax({
                    type: "post",
                    url: "../../../TransportContractServlet?method=del" ,
                    data:"transportId="+data.transport_id+"&driverId="+data.driver_id,
                    dataType:"text",
                    success: function (result) {
                        console.log(result);
                    }
                });
                layer.msg('删除成功', {
                    time: 800
                })
            });
        } /*else if(layEvent === 'edit'){ //编辑
            layer.open({
                type: 2,
                title: '货运回执单信息修改',
                content: [ 'modifyDetail.html?goodsRevertBillCode=' + data.goodsRevertBillCode ],
                area: [ '85%', '85%' ],
                shadeClose: true,
                move: false,
                end: function() {
                    table.reload('cargoReceiptTable1', {
                        url: nginx_url + '/vehicle/select' + array[0]
                    })
                }
            });
        }  else if (layEvent === 'detail') {
            layer.open({
                type: 2,
                title: '货运回执单详细信息',
                content: ['showDetail.html?goodsRevertBillCode=' + data.goodsRevertBillCode ],
                area: ['85%', '85%'],
                shadeClose: true,
                move: false,
            });
        }*/

    });

    element.on('tab(demo)', function (data) {

        refresh(data.index);

        // 监听工具条
    });

    function refresh(id) {
        table.render({
            elem: '#cargoReceiptTable' + (id + 1),
            height: 'full-170',
            url:"../../../TransportContractServlet?method=show",
            limit: 10,
            limits: [10],
            page: true //开启分页
            , cellMinWidth: 60
            , cols: [[
                {title: 'ID', fixed: 'left', type: 'numbers', align: 'center'},
                {field: 'transport_id', title: '货运单编号', align: 'center'},
                {field: 'driver_id', title: '司机编号', align: 'center'},
                {field: 'start_date', title: '起运时间', align: "center"},
                {field: 'end_date', title: '到达时间', align: 'center'},
                {field: 'total_fee', title: '总运费', align: 'center'},
                {fixed: 'right', title: "操作", align: "center", toolbar: '#barDemo', width: 200}
            ]]
        });
    }

});
