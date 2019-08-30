package com.servlet;

import com.alibaba.fastjson.JSON;
import com.entity.Order;
import com.entity.PageBean;
import com.service.OrderService;
import com.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "OrderServlet",urlPatterns = "/OrderServlet")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json;charset=UTF-8");//utf-8解析json文件
        String method=request.getParameter("method");
        HttpSession session=request.getSession();
        PrintWriter pw=response.getWriter();

        if(method.equals("add")){
            Order order=new Order();
            OrderService service=new OrderServiceImpl();
            order.setSender_id(request.getParameter("sender_id"));
            order.setSender_name(request.getParameter("sender_name"));
            order.setSender_phone(request.getParameter("sender_phone"));
            order.setSender_address(request.getParameter("sender_address"));
            order.setReciever_id(request.getParameter("reciever_id"));
            order.setReciever_name(request.getParameter("reciever_name"));
            order.setReciever_phone(request.getParameter("reciever_phone"));
            order.setReciever_address(request.getParameter("reciever_address"));
            order.setOrder_amount(Double.parseDouble(request.getParameter("order_amount")));
            order.setSubmit_date(request.getParameter("submit_date"));
            if(service.addOrder(order)>0){
                  pw.print("{msg:'添加成功'}");
                  response.sendRedirect(request.getContextPath()+"");
            }else{

            }
        }

        else if(method.equals("changeStatue")){
            OrderService service=new OrderServiceImpl();
            String orderId=request.getParameter("userId");
            String statue=request.getParameter("orderStatue");
            if(service.changeStatue(orderId,statue)>0){

            }else{

            }


        }

        else if(method.equals("show")){
            OrderService service=new OrderServiceImpl();
            PageBean page=new PageBean();
            int currentPage=request.getParameter("currentPage")==null?1:Integer.parseInt(request.getParameter("currentPage"));
            page.setPagesize(5);
            page.setCurrentPage(currentPage);
            page.setTotalPage((int)Math.floor(service.totalOrder()/page.getPagesize()));//分页数向上取整
            List<Order>orders=service.getOrderList(currentPage,page.getPagesize());
            if(orders!=null){
                page.setPageList(orders);
                String pageJSON=JSON.toJSONStringWithDateFormat(page,"yyyy-MM-dd hh:MM");//将JSON字符串发送到页面
                pw.print(pageJSON);
            }else {
                pw.print("{meg:'没有数据'}");

            }

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}
