package com.entity;

public class Driver {
    private  String driver_id;//司机编号
    private  String driver_name;//司机姓名
    private  String card;//身份证
    private  String driver_phone;//司机电话
    private  String sex;//性别
    private  String birthdate;//出生日期
    private  String address;//司机地址
    private  String car_id;//卡车编号
    private  String driver_info;//司机备注
    private  String driver_license;//驾照
    private  String driver_permit;//行驶证
    private  String operation_license;//行车证
    private  String insurance_license;//保险凭证

    public Driver() {
    }

    public Driver(String driver_id, String driver_name, String card, String driver_phone, String sex, String birthdate, String address, String car_id, String driver_info, String driver_license, String driver_permit, String operation_license, String insurance_license) {
        this.driver_id = driver_id;
        this.driver_name = driver_name;
        this.card = card;
        this.driver_phone = driver_phone;
        this.sex = sex;
        this.birthdate = birthdate;
        this.address = address;
        this.car_id = car_id;
        this.driver_info = driver_info;
        this.driver_license = driver_license;
        this.driver_permit = driver_permit;
        this.operation_license = operation_license;
        this.insurance_license = insurance_license;
    }

    public String getCard() {
        return card;
    }

    public String getAddress() {
        return address;
    }

    public String getDriver_permit() {
        return driver_permit;
    }

    public String getDriver_id() {
        return driver_id;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public String getDriver_phone() {
        return driver_phone;
    }

    public String getSex() {
        return sex;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getCar_id() {
        return car_id;
    }

    public String getDriver_info() {
        return driver_info;
    }

    public String getDriver_license() {
        return driver_license;
    }

    public String getOperation_license() {
        return operation_license;
    }

    public String getInsurance_license() {
        return insurance_license;
    }

    public void setDriver_id(String driver_id) {
        this.driver_id = driver_id;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    public void setDriver_phone(String driver_phone) {
        this.driver_phone = driver_phone;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setCar_id(String car_id) {
        this.car_id = car_id;
    }

    public void setDriver_info(String driver_info) {
        this.driver_info = driver_info;
    }

    public void setDriver_license(String driver_license) {
        this.driver_license = driver_license;
    }

    public void setOperation_license(String operation_license) {
        this.operation_license = operation_license;
    }

    public void setInsurance_license(String insurance_license) {
        this.insurance_license = insurance_license;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDriver_permit(String driver_permit) {
        this.driver_permit = driver_permit;
    }

    public void setCard(String card) {
        this.card = card;
    }
}
