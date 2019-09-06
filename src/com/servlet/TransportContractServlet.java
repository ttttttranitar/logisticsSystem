package com.servlet;

import com.alibaba.fastjson.JSON;
import com.entity.LayUIPageBean;
import com.entity.Order;
import com.entity.Transport;
import com.entity.TransportContract;
import com.service.OrderService;
import com.service.TransportContractService;
import com.service.TransportService;
import com.service.impl.OrderServiceImpl;
import com.service.impl.TransportContractServiceImpl;
import com.service.impl.TransportServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "TransportContractServlet",urlPatterns = "/TransportContractServlet")
public class TransportContractServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json;charset=UTF-8");//utf-8解析json文件
        String method = request.getParameter("method");
        HttpSession session=request.getSession();
        PrintWriter pw=response.getWriter();
        if(method.equals("add")){
            TransportContractService service=new TransportContractServiceImpl();
            TransportContract transportContract = new TransportContract();
            transportContract.setTransport_id(request.getParameter("goodsRevertBillCode"));
            transportContract.setStart_date(request.getParameter("startDate"));
            transportContract.setEnd_date(request.getParameter("endDate"));
            transportContract.setDriver_id(request.getParameter("goodsRevertBillCode"));
            transportContract.setTotal_fee(Double.parseDouble(request.getParameter("allCarriage")));
            if(service.add(transportContract)>0){
                 new OrderServiceImpl().changeStatue("运输中",transportContract.getTransport_id().substring(2));
                pw.print("SUCCESS");
            }
        }else if (method.equals("del")){
            TransportContractService service=new TransportContractServiceImpl();
            String transport_id=request.getParameter("transportId");
            String driver_id=request.getParameter("driverId");
            if(service.del(transport_id,driver_id)>0)
                pw.print("SUCCESS");

        }else if (method.equals("show")){
            TransportContractService service=new TransportContractServiceImpl();
            LayUIPageBean<TransportContract> page=new LayUIPageBean<TransportContract>();
            int currentPage=request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));//当前页面由前端提供
            int pageSize=request.getParameter("limit")==null?1:Integer.parseInt(request.getParameter("limit"));//获取单个分页条目数
            List<TransportContract> contracts=service.getContractList(currentPage,pageSize);
            if(contracts!=null){
                page.setData(contracts);
                page.setMsg("添加成功");
                page.setCount(service.totalContract());
                String pageJSON=JSON.toJSONStringWithDateFormat(page,"yyyy-MM-dd hh:MM");
                pw.print(pageJSON);
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
