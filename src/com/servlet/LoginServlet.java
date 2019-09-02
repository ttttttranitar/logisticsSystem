package com.servlet;

import com.alibaba.fastjson.JSON;
import com.entity.User;
import com.service.UserService;
import com.service.impl.UseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
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
        UserService userService = new UseServiceImpl();
        if (method.equals("login")){//登录
            String username = request.getParameter("loginId");
            String password = request.getParameter("password");
            User user=userService.logIn(username,password);
            if(user!=null) {
                //如果成功进入index.html
                session.setAttribute("User",user);
                response.sendRedirect(request.getContextPath()+"/index.html");
            }else {
                //如果失败进入login.html
                session.invalidate();
                response.sendRedirect(request.getContextPath()+"/login.html");
            }
        }else if (method.equals("show")){//将用户名显示在右上角
            User user=(User)session.getAttribute("User");
            String userJson=JSON.toJSONStringWithDateFormat(user,"yyyy-MM-dd HH:mm:ss");
            out.print(userJson);
        }
    }
}
