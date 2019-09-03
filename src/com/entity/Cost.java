package com.entity;

public class Cost {//资金类
    private int id;
    private double income;//收入
    private double payout;//支出
    private double bizIncome;//营业收入
    private double carriageMoney;//运费金额
    private double insurance;//保险
    private double unbizIncome;//非营业收入
    private double bizFee;//营业费用
    private double carCarriage;//车运费
    private double conveyWage;//搬运工资
    private double manageFee;//管理费用
    private double officeFee;//办公费用
    private double houseRent;//房租费
    private double waterElecFee;//水电费
    private double phoneFee;//电话费
    private double other;//其他
    private double financeFee;//财务费用
    private double profit;//利润
    private double wage;//工资
    private String month;//月份
    private double otherPayout;//其他支出（页面提交）
    private String writeDate;//日期
    private int administrative_fee_id;//管理费用id

    public Cost() {
    }

    public Cost(double officeFee, double houseRent, double waterElecFee, double phoneFee, double otherPayout, String writeDate ) {
        this.officeFee = officeFee;
        this.houseRent = houseRent;
        this.waterElecFee = waterElecFee;
        this.phoneFee = phoneFee;
        this.otherPayout = otherPayout;
        this.writeDate = writeDate;

    }


    public int getAdministrative_fee_id(){
        return administrative_fee_id;
    }
    public double getOtherPayout() {
        return otherPayout;
    }

    public String getWriteDate() {
        return writeDate;
    }

    public void setOtherPayout(double otherPayout) {
        this.otherPayout = otherPayout;
    }

    public void setWriteDate(String writeDate) {
        this.writeDate = writeDate;
    }

    public void setAdministrative_fee_id(int administrative_fee_id) {
        this.administrative_fee_id = administrative_fee_id;
    }

    public Cost(int id,double income, double payout, double bizIncome, double carriageMoney, double insurance, double unbizIncome, double bizFee, double carCarriage, double conveyWage, double manageFee, double officeFee, double houseRent, double waterElecFee, double phoneFee, double other, double financeFee, double profit, double wage, String month) {
        this.id=id;
        this.income = income;
        this.payout = payout;
        this.bizIncome = bizIncome;
        this.carriageMoney = carriageMoney;
        this.insurance = insurance;
        this.unbizIncome = unbizIncome;
        this.bizFee = bizFee;
        this.carCarriage = carCarriage;
        this.conveyWage = conveyWage;
        this.manageFee = manageFee;
        this.officeFee = officeFee;
        this.houseRent = houseRent;
        this.waterElecFee = waterElecFee;
        this.phoneFee = phoneFee;
        this.other = other;
        this.financeFee = financeFee;
        this.profit = profit;
        this.wage = wage;
        this.month = month;
    }

    public int getId() { return id; }

    public double getIncome() {
        return income;
    }

    public double getPayout() {
        return payout;
    }

    public double getBizIncome() {
        return bizIncome;
    }

    public double getCarriageMoney() {
        return carriageMoney;
    }

    public double getInsurance() {
        return insurance;
    }

    public double getUnbizIncome() {
        return unbizIncome;
    }

    public double getBizFee() {
        return bizFee;
    }

    public double getCarCarriage() {
        return carCarriage;
    }

    public double getConveyWage() {
        return conveyWage;
    }

    public double getManageFee() {
        return manageFee;
    }

    public double getOfficeFee() {
        return officeFee;
    }

    public double getHouseRent() {
        return houseRent;
    }

    public double getWaterElecFee() {
        return waterElecFee;
    }

    public double getPhoneFee() {
        return phoneFee;
    }

    public double getOther() {
        return other;
    }

    public double getFinanceFee() {
        return financeFee;
    }

    public double getProfit() {
        return profit;
    }

    public double getWage() {
        return wage;
    }

    public String getMonth() {
        return month;
    }

    public void setId(int id) { this.id = id; }

    public void setIncome(double income) {
        this.income = income;
    }

    public void setPayout(double payout) {
        this.payout = payout;
    }

    public void setBizIncome(double bizIncome) {
        this.bizIncome = bizIncome;
    }

    public void setCarriageMoney(double carriageMoney) {
        this.carriageMoney = carriageMoney;
    }

    public void setInsurance(double insurance) {
        this.insurance = insurance;
    }

    public void setUnbizIncome(double unbizIncome) {
        this.unbizIncome = unbizIncome;
    }

    public void setBizFee(double bizFee) {
        this.bizFee = bizFee;
    }

    public void setCarCarriage(double carCarriage) {
        this.carCarriage = carCarriage;
    }

    public void setConveyWage(double conveyWage) {
        this.conveyWage = conveyWage;
    }

    public void setManageFee(double manageFee) {
        this.manageFee = manageFee;
    }

    public void setOfficeFee(double officeFee) {
        this.officeFee = officeFee;
    }

    public void setHouseRent(double houseRent) {
        this.houseRent = houseRent;
    }

    public void setWaterElecFee(double waterElecFee) {
        this.waterElecFee = waterElecFee;
    }

    public void setPhoneFee(double phoneFee) {
        this.phoneFee = phoneFee;
    }

    public void setOther(double other) {
        this.other = other;
    }

    public void setFinanceFee(double financeFee) {
        this.financeFee = financeFee;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
