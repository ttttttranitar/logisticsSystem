package com.entity;

public class Car {
    private String car_id;//车牌号
    private String car_type;//汽车登录名
    private Double car_volume;//车在体积
    private Double car_weight;//车重
    private Double car_lenght;//车长
    private Double car_width;//车宽
    private Double car_height;//车高
    private String motor_id;//发动机号
    private String vIN;//车架号
    private String company;//车属公司
    private int is_company_car;//公司车（是/否）
    private String company_tel;//公司电话

    public Car() {
    }

    public Car(String car_id, String car_type, Double car_volume, Double car_weight, Double car_lenght, Double car_width, Double car_height, String motor_id, String vIN, String company, int is_company_car, String company_tel) {
        this.car_id = car_id;
        this.car_type = car_type;
        this.car_volume = car_volume;
        this.car_weight = car_weight;
        this.car_lenght = car_lenght;
        this.car_width = car_width;
        this.car_height = car_height;
        this.motor_id = motor_id;
        this.vIN = vIN;
        this.company = company;
        this.is_company_car = is_company_car;
        this.company_tel = company_tel;
    }

    public void setCar_width(Double car_width) {
        this.car_width = car_width;
    }

    public void setCar_id(String car_id) {
        this.car_id = car_id;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }

    public void setCar_volume(Double car_volume) {
        this.car_volume = car_volume;
    }

    public void setCar_lenght(Double car_lenght) {
        this.car_lenght = car_lenght;
    }

    public void setCar_weight(Double car_weight) {
        this.car_weight = car_weight;
    }

    public void setCar_height(Double car_height) {
        this.car_height = car_height;
    }

    public void setMotor_id(String motor_id) {
        this.motor_id = motor_id;
    }

    public void setVIN(String vIN) {
        this.vIN = vIN;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setIs_company_car(int is_company_car) {
        this.is_company_car = is_company_car;
    }

    public void setCompany_tel(String company_tel) {
        this.company_tel = company_tel;
    }

    public String getCar_id() {
        return car_id;
    }

    public String getCar_type() {
        return car_type;
    }

    public Double getCar_volume() {
        return car_volume;
    }

    public Double getCar_lenght() {
        return car_lenght;
    }

    public Double getCar_weight() {
        return car_weight;
    }

    public Double getCar_height() {
        return car_height;
    }

    public String getMotor_id() {
        return motor_id;
    }

    public String getVIN() {
        return vIN;
    }

    public String getCompany() {
        return company;
    }

    public int getIs_company_car() {
        return is_company_car;
    }

    public String getCompany_tel() {
        return company_tel;
    }

    public Double getCar_width() {
        return car_width;
    }
}
