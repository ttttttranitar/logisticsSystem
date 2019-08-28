package com.servlet;

import com.alibaba.fastjson.JSON;
import com.dao.impl.ClientDaoImpl;
import com.entity.Client;
import com.service.ClientService;
import com.service.impl.ClientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ClientServlet",urlPatterns = "/ClientServlet")
public class ClientServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        String method = request.getParameter("method");
        ClientService clientService = new ClientServiceImpl();
        if (method.equals("add")){//新增客户
            String customer = request.getParameter("customer");
            String phone = request.getParameter("phone");
            String fax = request.getParameter("fax");
            String postCode = request.getParameter("postCode");
            String address = request.getParameter("address");
            String linkman = request.getParameter("linkman");
            String linkmanMobile = request.getParameter("linkmanMobile");
            String customerType = request.getParameter("customerType");
            String enterpriseProperty = request.getParameter("enterpriseProperty");
            String enterpriseSize = request.getParameter("enterpriseSize");
            String email = request.getParameter("email");
            Client client = new Client(customer,phone,fax,postCode,address,linkman,linkmanMobile,customerType,enterpriseProperty,enterpriseSize,email);
            if (clientService.save(client)>0){
                request.setAttribute("client",client);
            }
        }else if (method.equals("show")){
                Client client= (Client) request.getAttribute("client");
                String clientJSON = JSON.toJSONString(client);
                out.print(clientJSON);

        }
    }
}
