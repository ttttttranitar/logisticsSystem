package com.dao.impl;

import com.dao.CostDao;
import com.entity.Cost;
import com.util.DButil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CostDaoImpl extends DButil implements CostDao {
    //新增
    @Override
    public int save(Cost cost) throws SQLException {//添加数据
        String sql="insert into `cost_save`(`officeFee`,`houseRent`,`waterElecFee`,`phoneFee`,`otherPayout`,`writeDate`) values(?,?,?,?,?,?)";//？
        return updateDB(sql,cost.getOfficeFee(),cost.getHouseRent(),cost.getWaterElecFee(),cost.getPhoneFee(),cost.getOtherPayout(),cost.getWriteDate());
    }

    @Override
    public Cost getCostByID(int administrative_fee_id) throws SQLException {//通过ID查询
        String sql = "SELECT administrative_fee_id,`officeFee`,`houseRent`,`waterElecFee`,`phoneFee`,`otherPayout`,`writeDate` FROM `cost_save` where administrative_fee_id=?";
        Cost cost;
        try {
            res =queryDB(sql,administrative_fee_id);
            cost =null;
            if (res.next()){
                cost = new Cost();
                cost.setAdministrative_fee_id(res.getInt("administrative_fee_id"));
                cost.setOfficeFee(res.getDouble("officeFee"));
                cost.setHouseRent(res.getDouble("houseRent"));
                cost.setWaterElecFee(res.getDouble("waterElecFee"));
                cost.setPhoneFee(res.getDouble("phoneFee"));
                cost.setOtherPayout(res.getDouble("otherPayout"));
                cost.setWriteDate(res.getString("writeDate"));
            }
        }finally {
            closeALL(conn,stat,res);
        }
        return cost;
    }

    @Override
    public Cost getCost() throws SQLException {//查询成本
        String sql="SELECT `id`,`income`,`payout`,`bizIncome`,`carriageMoney`,`insurance`,`unbizIncome`,`bizFee`,`carCarriage`,`conveyWage`,`manageFee`,`officeFee`,`houseRent`,`waterElecFee`,`phoneFee`,`other`,`financeFee`,`profit`,`wage` FROM `cost` values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
       Cost cost;
        try {
        res = queryDB(sql);
        cost = null;
        if (res.next()) {
            cost.setId(res.getInt("id"));
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
            }
            }finally {
                closeALL(conn,stat,res);
            }
            return cost;

    }

    //查询


   /* @Override
    public Cost getcost() throws SQLException {
        String sql = "SELECT `officeFee`,`houseRent`,`waterElecFee`,`phoneFee`,`otherPayout`,`writeDate` FROM `cost_save`";
        Cost cost;
        try {
            res =queryDB(sql);
            cost =null;
            if (res.next()){
                cost = new Cost();
                cost.setOfficeFee(res.getDouble("officeFee"));
                cost.setHouseRent(res.getDouble("houseRent"));
                cost.setWaterElecFee(res.getDouble("waterElecFee"));
                cost.setPhoneFee(res.getDouble("phoneFee"));
                cost.setOtherPayout(res.getDouble("otherPayout"));
                cost.setWriteDate(res.getString("writeDate"));
            }
        }finally {
            closeALL(conn,stat,res);
        }
        return cost;
    }*/
    //带分页的List

    @Override
    public List<Cost> getCostList(int page, int pagesize) throws SQLException {
        List<Cost> costList = new ArrayList<>();
        String sql="select `administrative_fee_id`,`officeFee`,`houseRent`,`waterElecFee`,`phoneFee`,`writeDate`" +
                "from `cost_save` limit ?,?";
        Cost cost;
        try {
            res = queryDB(sql,(page-1)*pagesize,pagesize);
            cost = null;
            while (res.next()) {
                cost = new Cost();
                cost.setAdministrative_fee_id(res.getInt("administrative_fee_id"));
                cost.setOfficeFee(res.getDouble("officeFee"));
                cost.setHouseRent(res.getDouble("houseRent"));
                cost.setWaterElecFee(res.getDouble("waterElecFee"));
                cost.setPhoneFee(res.getDouble("phoneFee"));
                cost.setWriteDate(res.getString("writeDate"));
                costList.add(cost);
            }
        } finally {
            closeALL(conn, stat, res);
        }
        return costList;
    }

    @Override
    public int getCount() throws SQLException {
        int count = 0;
        String sql = "SELECT COUNT(`administrative_fee_id`) FROM `cost_save`";
        try {
        res = queryDB(sql,null);
        if (res.next()){
            count =  res.getInt(1);
        }
    } finally {
        closeALL(conn,stat,res);
    }
        return count;
    }
}
