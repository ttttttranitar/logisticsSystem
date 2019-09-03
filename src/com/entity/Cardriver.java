package com.entity;

public class Cardriver {
    private String car_id;//车牌号
    private String car_type;//汽车登录名
    private Double car_volume;//车在体积
    private Double car_weight;//车重
    private Double car_lenght;//车长
    private Double car_width;//车宽
    private Double car_height;//车高
    private String motor_id;//发动机号
    private String VIN;//车架号
    private String company;//车属公司
    private int is_company_car;//公司车（是/否）
    private String company_tel;//公司电话
    private  String driver_id;//司机编号
    private  String driver_name;//司机姓名
    private  String card;//身份证
    private  String driver_phone;//司机电话
    private  String sex;//性别
    private  String birthdate;//出生日期
    private  String address;//司机地址
    private  String driver_info;//司机备注
    private  String driver_license;//驾照
    private  String driver_permit;//行驶证
    private  String operation_license;//行车证
    private  String insurance_license;//保险凭证

    public Cardriver() {
    }

    public Cardriver(String car_id, String car_type, Double car_volume, Double car_weight, Double car_lenght, Double car_width, Double car_height, String motor_id, String VIN, String company, int is_company_car, String company_tel, String driver_id, String driver_name, String card, String driver_phone, String sex, String birthdate, String address, String car_id1, String driver_info, String driver_license, String driver_permit, String operation_license, String insurance_license) {
        this.car_id = car_id;
        this.car_type = car_type;
        this.car_volume = car_volume;
        this.car_weight = car_weight;
        this.car_lenght = car_lenght;
        this.car_width = car_width;
        this.car_height = car_height;
        this.motor_id = motor_id;
        this.VIN = VIN;
        this.company = company;
        this.is_company_car = is_company_car;
        this.company_tel = company_tel;
        this.driver_id = driver_id;
        this.driver_name = driver_name;
        this.card = card;
        this.driver_phone = driver_phone;
        this.sex = sex;
        this.birthdate = birthdate;
        this.address = address;
        this.car_id = car_id1;
        this.driver_info = driver_info;
        this.driver_license = driver_license;
        this.driver_permit = driver_permit;
        this.operation_license = operation_license;
        this.insurance_license = insurance_license;
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

    public String getDriver_permit() {
        return driver_permit;
    }

    public String getOperation_license() {
        return operation_license;
    }

    public String getInsurance_license() {
        return insurance_license;
    }

    public String getCar_type() {
        return car_type;
    }

    public Double getCar_volume() {
        return car_volume;
    }

    public Double getCar_weight() {
        return car_weight;
    }

    public Double getCar_lenght() {
        return car_lenght;
    }

    public Double getCar_width() {
        return car_width;
    }

    public Double getCar_height() {
        return car_height;
    }

    public String getMotor_id() {
        return motor_id;
    }

    public String getVIN() {
        return VIN;
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

    public String getDriver_id() {
        return driver_id;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public String getCard() {
        return card;
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

    public String getAddress() {
        return address;
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

    public void setDriver_permit(String driver_permit) {
        this.driver_permit = driver_permit;
    }

    public void setOperation_license(String operation_license) {
        this.operation_license = operation_license;
    }

    public void setInsurance_license(String insurance_license) {
        this.insurance_license = insurance_license;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }

    public void setCar_volume(Double car_volume) {
        this.car_volume = car_volume;
    }

    public void setCar_weight(Double car_weight) {
        this.car_weight = car_weight;
    }

    public void setCar_lenght(Double car_lenght) {
        this.car_lenght = car_lenght;
    }

    public void setCar_width(Double car_width) {
        this.car_width = car_width;
    }

    public void setCar_height(Double car_height) {
        this.car_height = car_height;
    }

    public void setMotor_id(String motor_id) {
        this.motor_id = motor_id;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
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

    public void setDriver_id(String driver_id) {
        this.driver_id = driver_id;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    public void setCard(String card) {
        this.card = card;
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

    public void setAddress(String address) {
        this.address = address;
    }
}
