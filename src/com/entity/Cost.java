package com.entity;

public class Cost {
    private int income;//收入
    private int expenditure;//支出
    private int do_business_income;//营业收入
    private int insurance;//保险
    private int not_do_business_income;//非营业收入
    private int do_business_cost;//营业费用
    private int car_freight;//车运费
    private int truckage;//搬运费
    private int administration_cost;//管理费用
    private int work_cost;//办公费用
    private int residential_cost;//房租费
    private int water_and_electricity_cost;//水电费
    private int telephone_cost;//电话费
    private int other;//其他
    private int financial_cost;//财务费用
    private int profit;//利润
    private int salary;//工资
    private int month;//月份

    public Cost() {
    }

    public Cost(int income, int expenditure, int do_business_income, int insurance, int not_do_business_income, int do_business_cost, int car_freight, int truckage, int administration_cost, int work_cost, int residential_cost, int water_and_electricity_cost, int telephone_cost, int other, int financial_cost, int profit, int salary, int month) {
        this.income = income;
        this.expenditure = expenditure;
        this.do_business_income = do_business_income;
        this.insurance = insurance;
        this.not_do_business_income = not_do_business_income;
        this.do_business_cost = do_business_cost;
        this.car_freight = car_freight;
        this.truckage = truckage;
        this.administration_cost = administration_cost;
        this.work_cost = work_cost;
        this.residential_cost = residential_cost;
        this.water_and_electricity_cost = water_and_electricity_cost;
        this.telephone_cost = telephone_cost;
        this.other = other;
        this.financial_cost = financial_cost;
        this.profit = profit;
        this.salary = salary;
        this.month = month;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public void setExpenditure(int expenditure) {
        this.expenditure = expenditure;
    }

    public void setDo_business_income(int do_business_income) {
        this.do_business_income = do_business_income;
    }


    public void setInsurance(int insurance) {
        this.insurance = insurance;
    }

    public void setNot_do_business_income(int not_do_business_income) {
        this.not_do_business_income = not_do_business_income;
    }

    public void setDo_business_cost(int do_business_cost) {
        this.do_business_cost = do_business_cost;
    }

    public void setCar_freight(int car_freight) {
        this.car_freight = car_freight;
    }

    public void setTruckage(int truckage) {
        this.truckage = truckage;
    }

    public void setAdministration_cost(int administration_cost) {
        this.administration_cost = administration_cost;
    }

    public void setWork_cost(int work_cost) {
        this.work_cost = work_cost;
    }

    public void setResidential_cost(int residential_cost) {
        this.residential_cost = residential_cost;
    }

    public void setWater_and_electricity_cost(int water_and_electricity_cost) {
        this.water_and_electricity_cost = water_and_electricity_cost;
    }

    public void setTelephone_cost(int telephone_cost) {
        this.telephone_cost = telephone_cost;
    }

    public void setOther(int other) {
        this.other = other;
    }

    public void setFinancial_cost(int financial_cost) {
        this.financial_cost = financial_cost;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getIncome() {
        return income;
    }

    public int getExpenditure() {
        return expenditure;
    }

    public int getDo_business_income() {
        return do_business_income;
    }


    public int getInsurance() {
        return insurance;
    }

    public int getNot_do_business_income() {
        return not_do_business_income;
    }

    public int getDo_business_cost() {
        return do_business_cost;
    }

    public int getCar_freight() {
        return car_freight;
    }

    public int getTruckage() {
        return truckage;
    }

    public int getAdministration_cost() {
        return administration_cost;
    }

    public int getWork_cost() {
        return work_cost;
    }

    public int getResidential_cost() {
        return residential_cost;
    }

    public int getWater_and_electricity_cost() {
        return water_and_electricity_cost;
    }

    public int getTelephone_cost() {
        return telephone_cost;
    }

    public int getOther() {
        return other;
    }

    public int getFinancial_cost() {
        return financial_cost;
    }

    public int getProfit() {
        return profit;
    }

    public int getSalary() {
        return salary;
    }

    public int getMonth() {
        return month;
    }
}
