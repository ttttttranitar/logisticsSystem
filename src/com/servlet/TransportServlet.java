package com.servlet;

import com.alibaba.fastjson.JSON;
import com.entity.LayUIPageBean;
import com.entity.Order;
import com.entity.Transport;
import com.service.OrderService;
import com.service.TransportService;
import com.service.impl.OrderServiceImpl;
import com.service.impl.TransportServiceImpl;
import com.sun.org.apache.regexp.internal.RE;
import sun.security.krb5.internal.PAData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "TransportServlet",urlPatterns = "/TransportServlet")
public class TransportServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json;charset=UTF-8");//utf-8解析json文件
        String method=request.getParameter("method");
        HttpSession session=request.getSession();
        session.setMaxInactiveInterval(500);
        PrintWriter pw=response.getWriter();

        if(method.equals("add")){
            TransportService service=new TransportServiceImpl();
            Transport transport=new Transport();
            transport.setStart_date(request.getParameter("startDate"));//发货时间
            transport.setEnd_date(request.getParameter("endDate"));//收货时间
            transport.setPay_type(request.getParameter("payType"));//支付方式
            transport.setTransport_fee(request.getParameter("transportFee"));//运费
            transport.setInsurance_fee(request.getParameter("insuranceFee"));//保险费
            transport.setTransport_start(request.getParameter("start"));//发货地址
            transport.setTransport_distinatin(request.getParameter("distination"));//收货地址
            transport.setTransport_info(request.getParameter("transportInfo"));//备注
            String orderId=request.getParameter("orderId");//运单号
            if(service.addTransport(transport,orderId)>0){
                session.setAttribute("transport",transport);
                OrderService orderService=new OrderServiceImpl();
                orderService.changeStatue("已揽货",orderId);//更改订单状态
                pw.print("SUCCESS");
            }
        }

        else if(method.equals("get")){
            TransportService service=new TransportServiceImpl();
            Transport transport=null;
            String transportId=request.getParameter("transportId");
            transport=service.getTransport(transportId);
            if(transport!=null){
                String transportJSON=JSON.toJSONStringWithDateFormat(transport,"yyyy-MM-dd hh:MM");
                pw.print(transportJSON);
            }

        }

        else if(method.equals("update")){
            Transport transport=new Transport();
            TransportService service=new TransportServiceImpl();
            transport.setTransport_id(request.getParameter("transportId"));
            transport.setStart_date(request.getParameter("startDate"));//发货时间
            transport.setEnd_date(request.getParameter("endDate"));//收货时间
            transport.setPay_type(request.getParameter("payType"));//支付方式
            transport.setTransport_fee(request.getParameter("transportFee"));//运费
            transport.setInsurance_fee(request.getParameter("insuranceFee"));//保险费
            transport.setTransport_start(request.getParameter("start"));//发货地址
            transport.setTransport_distinatin(request.getParameter("distination"));//收货地址
            transport.setTransport_info(request.getParameter("transportInfo"));//备注
            if(service.updateTransport(transport)>0){
                pw.print("SUCCESS");
            }

        }

        else if(method.equals("getOrder")){
            Order order=null;
            OrderService service=new OrderServiceImpl();
            String orderId=request.getParameter("orderId");
            order=service.getOrder(orderId);
            if(order!=null){
                String orderJSON=JSON.toJSONStringWithDateFormat(order,"yyyy-MM-dd hh:MM");
                pw.print(orderJSON);
            }
        }

        else if(method.equals("show")){
            LayUIPageBean<Transport> page=new LayUIPageBean<>();
            TransportService service=new TransportServiceImpl();
            int currentPage=request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
            int pageSize=request.getParameter("limit")==null?1:Integer.parseInt(request.getParameter("limit"));
            List<Transport> transportList=service.getTransportList(currentPage,pageSize);
            if(transportList!=null){
                page.setData(transportList);
                page.setCount(service.totalTransport());
                page.setMsg("");
                String pageJSON= JSON.toJSONStringWithDateFormat(page,"yyyy-MM-dd hh:MM");
                pw.print(pageJSON);
            }
        }

        else if(method.equals("showOrders")){
            LayUIPageBean<Order> page=new LayUIPageBean<Order>();
            OrderService service=new OrderServiceImpl();
            int currentPage=request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
            int pageSize=request.getParameter("limit")==null?1:Integer.parseInt(request.getParameter("limit"));
            List<Order> orders=service.getOrderList(currentPage,pageSize);
            if(orders!=null){
                page.setMsg("");
                page.setData(orders);
                String pageJSON=JSON.toJSONStringWithDateFormat(page,"yyyy-MM-dd hh:MM");
                pw.print(pageJSON);
            }
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
               doPost(request,response);
    }
}
