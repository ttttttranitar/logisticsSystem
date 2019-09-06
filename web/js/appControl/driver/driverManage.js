layui.use(['layer', 'form', 'element', 'laydate', 'jquery', 'table'], function() {
    var element = layui.element,
        $ = layui.jquery,
        form = layui.form,
        layer = layui.layer,
        laydate = layui.laydate,
        table = layui.table;
    form.render();

    laydate.render({
        elem: '#birthday',
        type: 'date',
        theme: '#393D49'
    });

    form.on('switch(checkCondition)', function (data) {
        if (data.elem.checked === true) {
            $("#companyCar").val(true);
        } else {
            $("#companyCar").val(false);
        }
    });

    form.on('submit(addDriver)', function () {
        $.ajax({
            type: 'post',
            url:'../../../DriverServlet?method=add',
            data: $("#driverForm").serialize(),
            dataType: 'text',
            success: function (result) {
                console.log(result);
                if (result === 'SUCCESS') {
                    layer.msg('司机信息添加成功', {
                        time: 800,
                        icon: 1
                    });
                    $("#resetForm").click();
                } else {
                    layer.msg('司机信息添加失败', {
                        time: 800,
                        icon: 1
                    });
                }
            }
        });
        return false;
    });

    element.on('tab(driverFilter)', function(data){
        if (data.index === 1) {
            table.render({
                elem: '#driverTable',
                height: 'full-170',
                url:'../../../DriverServlet?method=driverListPage', //数据接口
                limit: 10,
                limits: [ 10 ],
                page: true, //开启分页
                cellMinWidth: 80,
                cols: [[
                    { title: 'ID', fixed: 'left', sort: true, type: 'numbers', align: 'center' },
                    { field: 'driver_id', title: '司机编号', align: 'center' },
                    { field: 'driver_name', title: '司机姓名', align: 'center' },
                    { field: 'driver_phone', title: '电话', align: 'center' },
                    { field: 'driver_permit', title: '行驶证', align: 'center' },
                    { field: 'car_id', title: '车号', align: 'center' },
                    { field: 'driver_license', title: '驾照', align: 'center' },
                    { fixed: 'right', title:"操作", align:"center", toolbar: '#barDemo', width: 200 }
                ]]
            });

            // 监听工具条
            table.on('tool(driverTool)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
                var data = obj.data; //获得当前行数据
                var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）

                if(layEvent === 'del'){ //删除
                    layer.confirm('真的删除么', function(index){
                        obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                        layer.close(index);
                        //向服务端发送删除指令
                        $.ajax({
                            type: "post",
                            url: "../../../DriverServlet?method=delete&driver_id=" + data.driver_id,
                            async: false,
                            dataType: 'text',
                            success: function (result) {
                                console.log(result);
                                if (result === 'SUCCESS') {
                                    layer.msg('删除成功', {
                                        time: 800,
                                        icon: 1
                                    });
                                } else {
                                    layer.msg('删除失败', {
                                        time: 800,
                                        icon: 5
                                    });
                                }
                            }
                        });
                        table.reload('driverTable', {
                            url:'../../../DriverServlet?method=driverListPage'
                        });
                    });

                } else if(layEvent === 'edit'){ //编辑
                    layer.open({
                        type: 2,
                        title: '司机 - ' + data.driver_id + '信息修改',
                        content: ['driverModify.html?driver_id=' + data.driver_id, 'no'],
                        area: ['95%', '95%'],
                        shadeClose: true,
                        move: false
                        /*end: function() {
                            table.reload('driverTable', {
                                url: nginx_url + '/driverInfo/selectAllByPage'
                            })
                        }*/
                    });
                } else if(layEvent === 'detail') {
                    layer.open({
                        type: 2,
                        title: '司机 - ' + data.driver_id + ' 信息详情',
                        content: [ 'driverDetail.html?driver_id=' + data.driver_id, 'no' ],
                        area: [ '95%', '95%' ],
                        shadeClose: true,
                        move: false
                    });
                }
            });
        }
    });

});
