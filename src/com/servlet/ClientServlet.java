package com.servlet;

import com.alibaba.fastjson.JSON;
import com.entity.Client;
import com.entity.LayUIPageBean;
import com.entity.PageBean;
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
import java.util.List;

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
                out.print("SUCCESS");
            }
        }else if (method.equals("ClientList")){//json客户列表
            /*int page = request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
            int limit = request.getParameter("limit")==null?1:Integer.parseInt(request.getParameter("limit"));
            List<Client> clientList = clientService.getClientList(page,limit);
            StringBuffer sb = new StringBuffer("");
            sb.append("{" +
                    "code: 0, " +
                    "count:");
            sb.append(clientService.getClientCount());
            sb.append(",msg: \"\"" +
                    ",data:");
            sb.append(clientList);
            sb.append("}");
            String clientListJSON = JSON.toJSONStringWithDateFormat(sb,"yyyy-MM-dd HH:mm:ss");
            out.print(clientListJSON);*/
            int pages = request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
            int limit = request.getParameter("limit")==null?1:Integer.parseInt(request.getParameter("limit"));

            LayUIPageBean<Client> page = new LayUIPageBean<>();
            page.setCount(clientService.getClientCount());//总记录数
            //数据列表
            page.setMsg("");
            page.setCode(0);
            page.setData(clientService.getClientList(pages,limit));
            String clientListJSON = JSON.toJSONStringWithDateFormat(page,"yyyy-MM-dd HH:mm:ss");
            out.print(clientListJSON);
        }else if (method.equals("Update")){//修改客户数据
            String customerCode = request.getParameter("customerCode");
            String phone = request.getParameter("phone");
            String customer = request.getParameter("customer");
            String fax = request.getParameter("fax");
            String postCode = request.getParameter("postCode");
            String address = request.getParameter("address");
            String linkman = request.getParameter("linkman");
            String linkmanMobile = request.getParameter("linkmanMobile");
            String customerType = request.getParameter("customerType");
            String enterpriseProperty = request.getParameter("enterpriseProperty");
            String enterpriseSize = request.getParameter("enterpriseSize");
            String email = request.getParameter("email");
            Client client = new Client(customerCode,customer,phone,fax,postCode,address,linkman,linkmanMobile,customerType,enterpriseProperty,enterpriseSize,email);
            if (clientService.update(client)>0){
                /*response.sendRedirect(request.getContextPath()+"html/appControl/customer/customerManage.html");*/
                out.print("SUCCESS");
            }
        }else if (method.equals("show")){
            String customerCode = request.getParameter("customerCode");
            Client client = clientService.getClientByID(customerCode);
            String clientIDJSON = JSON.toJSONStringWithDateFormat(client,"yyyy-MM-dd HH:mm:ss");
            out.print(clientIDJSON);
        }
    }
}
