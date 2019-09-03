package com.servlet;

import com.alibaba.fastjson.JSON;
import com.entity.Client;
import com.entity.Cost;
import com.entity.LayUIPageBean;
import com.service.CostService;
import com.service.impl.CostSeviceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CostServlet",urlPatterns = "/CostServlet")
public class CostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        String method = request.getParameter("method");
        CostService costService = new CostSeviceImpl();
        if (method.equals("add")) {//添加
            Double officeFee = Double.valueOf(request.getParameter("officeFee"));
            Double houseRent = Double.valueOf(request.getParameter("houseRent"));
            Double waterElecFee = Double.valueOf(request.getParameter("waterElecFee"));
            Double phoneFee = Double.valueOf(request.getParameter("phoneFee"));
            Double otherPayout = Double.valueOf(request.getParameter("otherPayout"));
            String writeDate = request.getParameter("writeDate");
            Cost cost = new Cost(officeFee, houseRent, waterElecFee, phoneFee, otherPayout, writeDate);
            if (costService.save(cost) > 0) {
                /*response.sendRedirect(request.getContextPath()+"/index.html");//跳转到index.html*/
                out.println("上传成功");
            }
        }else if (method.equals("show")) {//显示
            int administrative_fee_id = Integer.parseInt(request.getParameter("administrative_fee_id"));
            Cost cost = costService.getCostByID(administrative_fee_id);
            String costJSON = JSON.toJSONString(cost);
            out.print(costJSON);
        } else if (method.equals("CostList")) {
            int pages = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
            int limit = request.getParameter("limit") == null ? 1 : Integer.parseInt(request.getParameter("limit"));
            LayUIPageBean<Cost> page = new LayUIPageBean<>();
            page.setCount(costService.getCostCount());//总记录数
            //数据列表
            page.setMsg("");
            page.setCode(0);
            page.setData(costService.getCostList(pages, limit));
            String costListJSON = JSON.toJSONStringWithDateFormat(page, "yyyy-MM-dd HH:mm:ss");
            out.print(costListJSON);
        }else if (method.equals("show_income")) {//显示
            Cost cost = costService.getCost();
            String costJSON = JSON.toJSONString(cost);
            out.print(costJSON);
        }
    }
}
