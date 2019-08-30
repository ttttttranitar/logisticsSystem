package com.dao.impl;

import com.dao.CostDao;
import com.entity.Cost;
import com.util.DButil;

import java.sql.SQLException;

public class CostDaoImpl extends DButil implements CostDao {

    @Override
    public double save(Cost cost) throws SQLException {
        String sql="insert into `cost`(`income`,`payout`,`bizIncome`,`carriageMoney`,`insurance`,`unbizIncome`,`bizFee`,`carCarriage`,`conveyWage`,`manageFee`,`officeFee`,`houseRent`,`waterElecFee`,`phoneFee`,`other`,`financeFee`,`profit`,`wage`,`month`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";//18个？
        return updateDB(sql,cost.getIncome(),cost.getPayout(),cost.getBizFee(),cost.getCarriageMoney(),cost.getInsurance(),cost.getUnbizIncome(),cost.getCarCarriage(),cost.getConveyWage(),cost.getManageFee(),cost.getOfficeFee(),cost.getHouseRent(),cost.getWaterElecFee(),cost.getPhoneFee(),cost.getOther(),cost.getFinanceFee(),cost.getProfit(),cost.getWage(),cost.getMonth());
    }

    @Override
    public Cost getcost() throws SQLException {
        String sql = "SELECT `income`,`payout`,`bizIncome`,`carriageMoney`,`insurance`,`unbizIncome`," +
                "`bizFee`,`carCarriage`,`conveyWage`,`manageFee`,`officeFee`,`houseRent`,`waterElecFee`," +
                "`phoneFee`,`other`,`financeFee`,`profit`,`wage`,`month` from `cost` ";
        Cost cost;
        try {
            res =queryDB(sql);
            cost =null;
            if (res.next()){
                cost = new Cost();
                cost.setIncome(res.getDouble("income"));
                cost.setPayout(res.getDouble("payout"));
                cost.setBizIncome(res.getDouble("bizIncome"));
                cost.setCarriageMoney(res.getDouble("carriageMoney"));
                cost.setInsurance(res.getDouble("insurance"));
                cost.setUnbizIncome(res.getDouble("unbizIncome"));
                cost.setBizFee(res.getDouble("bizFee"));
                cost.setCarCarriage(res.getDouble("carCarriage"));
                cost.setConveyWage(res.getDouble("conveyWage"));
                cost.setManageFee(res.getDouble("manageFee"));
                cost.setOfficeFee(res.getDouble("officeFee"));
                cost.setHouseRent(res.getDouble("houseRent"));
                cost.setWaterElecFee(res.getDouble("waterElecFee"));
                cost.setPhoneFee(res.getDouble("phoneFee"));
                cost.setOther(res.getDouble("other"));
                cost.setFinanceFee(res.getDouble("financeFee"));
                cost.setProfit(res.getDouble("profit"));
                cost.setWage(res.getDouble("wage"));
                cost.setMonth(res.getString("month"));
            }
        }finally {
            closeALL(conn,stat,res);
        }
        return cost;
    }
}
