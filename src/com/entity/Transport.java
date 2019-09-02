package com.entity;

public class Transport {
    private String transport_id;//运单号
    private String start_date;//发货日期
    private String end_date;//收货日期
    private String pay_type;//付款方式
    private String transport_fee;//运输费
    private String insurance_fee;//保险费
    private String transport_start;//收货地址
    private String transport_distinatin;//发货地址
    private String transport_info;//备注



    public Transport(String transport_id, String start_date, String end_date, String pay_type, String transport_fee, String insurance_fee, String transport_start, String transport_distinatin, String transport_info) {
        this.transport_id = transport_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.pay_type = pay_type;
        this.transport_fee = transport_fee;
        this.insurance_fee = insurance_fee;
        this.transport_start = transport_start;
        this.transport_distinatin = transport_distinatin;
        this.transport_info = transport_info;
    }

    public Transport(){}

    public String getTransport_id() {
        return transport_id;
    }

    public void setTransport_id(String transport_id) {
        this.transport_id = transport_id;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public String getTransport_fee() {
        return transport_fee;
    }

    public void setTransport_fee(String transport_fee) {
        this.transport_fee = transport_fee;
    }

    public String getInsurance_fee() {
        return insurance_fee;
    }

    public void setInsurance_fee(String insurance_fee) {
        this.insurance_fee = insurance_fee;
    }

    public String getTransport_start() {
        return transport_start;
    }

    public void setTransport_start(String transport_start) {
        this.transport_start = transport_start;
    }

    public String getTransport_distinatin() {
        return transport_distinatin;
    }

    public void setTransport_distinatin(String transport_distinatin) {
        this.transport_distinatin = transport_distinatin;
    }

    public String getTransport_info() {
        return transport_info;
    }

    public void setTransport_info(String transport_info) {
        this.transport_info = transport_info;
    }


}
