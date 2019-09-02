package com.servlet;

import com.alibaba.fastjson.JSON;
import com.entity.LayUIPageBean;
import com.entity.Transport;
import com.service.OrderService;
import com.service.TransportService;
import com.service.impl.OrderServiceImpl;
import com.service.impl.TransportServiceImpl;
import com.sun.org.apache.regexp.internal.RE;

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
            transport.setStart_date(request.getParameter("startDate"));
            transport.setEnd_date(request.getParameter("endDate"));
            transport.setPay_type(request.getParameter("payType"));
            transport.setTransport_fee(request.getParameter("transportFee"));
            transport.setInsurance_fee(request.getParameter("insuranceFee"));
            transport.setTransport_start(request.getParameter("start"));
            transport.setTransport_distinatin(request.getParameter("distination"));
            transport.setTransport_info(request.getParameter("transportInfo"));
            String orderId=request.getParameter("orderId");
            if(service.addTransport(transport,orderId)>0){
                session.setAttribute("transport",transport);
                OrderService orderService=new OrderServiceImpl();
                orderService.changeStatue("运输中",orderId);//更改订单状态
                pw.print("{msg:'添加成功'}");
            }else {
                pw.print("{msg:'添加失败'}");
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

        else if(method.equals("show")){
            LayUIPageBean<Transport> page=new LayUIPageBean<>();
            TransportService service=new TransportServiceImpl();
            int currentPage=request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
            int pageSize=request.getParameter("limit")==null?1:Integer.parseInt(request.getParameter("limit"));
            List<Transport> transportList=service.getTransportList(currentPage,pageSize);
            if(transportList!=null){
                page.setData(transportList);
                page.setMsg("");
                String pageJSON= JSON.toJSONStringWithDateFormat(page,"yyyy-MM-dd hh:MM");
                pw.print(pageJSON);
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
               doPost(request,response);
    }
}
