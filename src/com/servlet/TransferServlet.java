package com.servlet;

import com.alibaba.fastjson.JSON;
import com.entity.Client;
import com.entity.LayUIPageBean;
import com.entity.Transfer;
import com.service.TransferService;
import com.service.impl.TransferServiceImol;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TransferServlet",urlPatterns = "/TransferServlet")
public class TransferServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        String method = request.getParameter("method");
        TransferService transferService = new TransferServiceImol();
        if (method.equals("add")) {
            String city = request.getParameter("city");
            String companyName = request.getParameter("companyName");
            String linkPhone = request.getParameter("linkPhone");
            String detailAddress = request.getParameter("detailAddress");
            Transfer transfer = new Transfer(city,companyName,linkPhone,detailAddress);
            if (transferService.save(transfer) > 0) {
                out.print("SUCCESS");
            }
        } else if (method.equals("show")) {
            Transfer transfer = (Transfer) request.getAttribute("id");
            String transferJSON =JSON.toJSONStringWithDateFormat(transfer, "yyyy-MM-dd HH:mm:ss");
            out.print(transferJSON);
        }else if (method.equals("TransferList")){
            int pages = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
            int limit = request.getParameter("limit") == null ? 1 : Integer.parseInt(request.getParameter("limit"));
            LayUIPageBean<Transfer> page = new LayUIPageBean<>();
            page.setCount(transferService.getTransferCount());//总记录数
            //数据列表
            page.setMsg("");
            page.setCode(0);
            page.setData(transferService.getTransferList(pages, limit));
            String costListJSON = JSON.toJSONStringWithDateFormat(page, "yyyy-MM-dd HH:mm:ss");
            out.print(costListJSON);
        }
    }
}
