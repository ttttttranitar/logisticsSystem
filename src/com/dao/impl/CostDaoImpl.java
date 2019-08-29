package com.dao.impl;

import com.dao.CostDao;
import com.entity.Cost;
import com.util.DButil;

import java.sql.SQLException;

public class CostDaoImpl extends DButil implements CostDao {

    @Override
    public int save(Cost cost) throws SQLException {
        String sql="insert into `cost`(`income`,`expenditure`,`do_business_income`,`insurance`,`not_do_business_income`,`do_business_cost`,`car_freight`,`truckage`,`administration_cost`,`work_cost`,`residential_cost`,`water_and_electricity_cost`,`telephone_cost`,`other`,`financial_cost`,`profit`,`salary`,`month`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";//18个？
        return updateDB(sql,cost.getIncome(),cost.getExpenditure(),cost.getDo_business_income(),cost.getInsurance(),cost.getNot_do_business_income(),cost.getDo_business_cost(),cost.getCar_freight(),cost.getTruckage(),cost.getAdministration_cost(),cost.getWork_cost(),cost.getResidential_cost(),cost.getWater_and_electricity_cost(),cost.getTelephone_cost(),cost.getOther(),cost.getFinancial_cost(),cost.getProfit(),cost.getSalary(),cost.getMonth());
    }

    @Override
    public Cost getcost() throws SQLException {
        String sql = "SELECT `income`,`expenditure`,`do_business_income`,`insurance`,`not_do_business_income`,`do_business_cost`," +
                "`car_freight`,`truckage`,`administration_cost`,`work_cost`,`residential_cost`,`water_and_electricity_cost`,`telephone_cost`," +
                "`other`,`financial_cost`,`profit`,`salary`,`month` from `cost` ";
        Cost cost;
        try {
            res =queryDB(sql);
            cost =null;
            if (res.next()){
                cost = new Cost();
                cost.setIncome(res.getInt("income"));
                cost.setExpenditure(res.getInt("expenditure"));
                cost.setDo_business_income(res.getInt("do_business_income"));
                cost.setInsurance(res.getInt("insurance"));
                cost.setNot_do_business_income(res.getInt("not_do_business_income"));
                cost.setDo_business_cost(res.getInt("do_business_cost"));
                cost.setCar_freight(res.getInt("car_freight"));
                cost.setTruckage(res.getInt("truckage"));
                cost.setAdministration_cost(res.getInt("administration_cost"));
                cost.setWork_cost(res.getInt("work_cost"));
                cost.setResidential_cost(res.getInt("residential_cost"));
                cost.setWater_and_electricity_cost(res.getInt("water_and_electricity_cost"));
                cost.setTelephone_cost(res.getInt("telephone_cost"));
                cost.setOther(res.getInt("other"));
                cost.setFinancial_cost(res.getInt("financial_cost"));
                cost.setProfit(res.getInt("profit"));
                cost.setSalary(res.getInt("salary"));
                cost.setMonth(res.getInt("month"));
            }
        }finally {
            closeALL(conn,stat,res);
        }
        return cost;
    }
}
