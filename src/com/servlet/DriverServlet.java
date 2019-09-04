package com.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.entity.Car;
import com.entity.Cardriver;
import com.entity.Driver;
import com.service.CarService;
import com.service.CardriverService;
import com.service.DriverService;
import com.service.impl.CarServiceImpl;
import com.service.impl.CardriverServiceImpl;
import com.service.impl.DriverServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "DriverServlet",urlPatterns = "/DriverServlet")
public class DriverServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json;charset=UTF-8");//utf-8解析json文件
        String method=request.getParameter("method");
        HttpSession session=request.getSession();
        PrintWriter pw=response.getWriter();
        DriverService driverService = new DriverServiceImpl();
        CarService carService = new CarServiceImpl();
        CardriverService cardriverService =new CardriverServiceImpl();
        if(method.equals("add")){//执行新增
            String driver_id = driverService.IDgenerator();
            String driverName = request.getParameter("driverName");
            String idCard = request.getParameter("idCard");
            String phone = request.getParameter("phone");
            String gender = request.getParameter("gender");
            String birthday = request.getParameter("birthday");
            String address = request.getParameter("address");
            String carNo = request.getParameter("carNo");
            String carType = request.getParameter("carType");
            Double allowCarryVolume = Double.valueOf(request.getParameter("allowCarryVolume"));
            Double allowCarryWeight = Double.valueOf(request.getParameter("allowCarryWeight"));
            Double carLength = Double.valueOf(request.getParameter("carLength"));
            Double carWidth = Double.valueOf(request.getParameter("carWidth"));
            Double goodsHeight = Double.valueOf(request.getParameter("goodsHeight"));
            String driveLicence = request.getParameter("driveLicence");
            String runLicence = request.getParameter("runLicence");
            String bizLicence = request.getParameter("bizLicence");
            String insuranceCard = request.getParameter("insuranceCard");
            String carFrameNo = request.getParameter("carFrameNo");
            String engineNo = request.getParameter("engineNo");
            String carDept = request.getParameter("carDept");
            String carDeptTel = request.getParameter("carDeptTel");
            String remark = request.getParameter("remark");
            Driver driver = new Driver(driver_id,driverName,idCard,phone,gender,birthday,address,carNo,remark,driveLicence,runLicence,bizLicence,insuranceCard);
            Car car = new Car(carNo,carType,allowCarryVolume,allowCarryWeight,carLength,carWidth,goodsHeight,engineNo,carFrameNo,carDept,1,carDeptTel);
            if(driverService.save(driver)>0 && carService.save(car)>0){
                pw.print("SUCCESS");
            }
        }else if(method.equals("driverListPage")){
            //获取页面当前页码page
            int page = request.getParameter("page")==null?1:Integer.parseInt(request.getParameter("page"));
            //获得页面页大小limit
            int limit = request.getParameter("limit")==null?1:Integer.parseInt(request.getParameter("limit"));
            List<Driver> driverList = driverService.getDriverList(page,limit);
            StringBuilder sb = new StringBuilder("");
            sb.append("{" +
                    " \"code\":0," +
                    " \"msg\": \"\"," +
                    " \"count\":"+driverService.getDriverCount()+"," +
                    " \"data\":");
            String driverListJSON = JSON.toJSONStringWithDateFormat(driverList,"yyyy-MM-dd HH:mm:ss");
            sb.append(driverListJSON);
            sb.append("}");
            pw.print(sb.toString());
        }else if (method.equals("particulars")){
            String driverId = request.getParameter("driverId");
            Cardriver cardriver = cardriverService.cardriver(driverId);
            String driverJSON = JSON.toJSONStringWithDateFormat((cardriver),"yyyy-MM-dd HH:mm:ss");
            pw.print(driverJSON);
        }else if(method.equals("update")){
            String driverId = request.getParameter("driverId");
            String driverName = request.getParameter("driverName");
            String idCard = request.getParameter("idCard");
            String phone = request.getParameter("phone");
            String gender = request.getParameter("gender");
            String birthday = request.getParameter("birthday");
            String address = request.getParameter("address");
            String carNo = request.getParameter("carNo");
            String carType = request.getParameter("carType");
            Double allowCarryVolume = Double.valueOf(request.getParameter("allowCarryVolume"));
            Double allowCarryWeight = Double.valueOf(request.getParameter("allowCarryWeight"));
            Double carLength = Double.valueOf(request.getParameter("carLength"));
            Double carWidth = Double.valueOf(request.getParameter("carWidth"));
            Double goodsHeight = Double.valueOf(request.getParameter("goodsHeight"));
            String driveLicence = request.getParameter("driveLicence");
            String runLicence = request.getParameter("runLicence");
            String bizLicence = request.getParameter("bizLicence");
            String insuranceCard = request.getParameter("insuranceCard");
            String carFrameNo = request.getParameter("carFrameNo");
            String engineNo = request.getParameter("engineNo");
            String carDept = request.getParameter("carDept");
            String carDeptTel = request.getParameter("carDeptTel");
            String remark = request.getParameter("remark");
            Driver driver = new Driver(driverId,driverName,idCard,phone,gender,birthday,address,carNo,remark,driveLicence,runLicence,bizLicence,insuranceCard);
            Car car = new Car(carNo,carType,allowCarryVolume,allowCarryWeight,carLength,carWidth,goodsHeight,engineNo,carFrameNo,carDept,1,carDeptTel);
            if(driverService.modification(driver)>0 && carService.modification(car)>0){
                pw.print("SUCCESS");
            }
        }else if(method.equals("delete")){
            String driverId = request.getParameter("driverId");
            if(driverService.delete(driverId)>0){
                pw.print("SUCCESS");
            }
        }
    }
}
