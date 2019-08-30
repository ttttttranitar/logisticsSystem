package com.entity;

public class Order {//账单类
    private  String order_id;//账单编号
    private String sender_id;//发货客户编号
    private String sender_name;//发货客户
    private  String sender_phone;//发货客户电话
    private String sender_address;//发货客户地址
    private String reciever_id;//收货客户编号
    private String reciever_name;//收货客户
    private String reciever_phone;//收货客户电话
    private String reciever_address;//收货客户地址


    private String order_statue;
    private double order_amount;
    private String submit_date;

    public Order(String order_id, String sender_id, String sender_name, String sender_phone, String sender_address, String reciever_id, String reciever_name, String reciever_phone, String reciever_address, double order_amount, String submit_date) {
        this.order_id = order_id;
        this.sender_id = sender_id;
        this.sender_name = sender_name;
        this.sender_phone = sender_phone;
        this.sender_address = sender_address;
        this.reciever_id = reciever_id;
        this.reciever_name = reciever_name;
        this.reciever_phone = reciever_phone;
        this.reciever_address = reciever_address;
        this.order_amount = order_amount;
        this.order_statue="已提交";
        this.submit_date = submit_date;
    }

    public Order(){}

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getSender_id() {
        return sender_id;
    }

    public void setSender_id(String sender_id) {
        this.sender_id = sender_id;
    }

    public String getSender_name() {
        return sender_name;
    }

    public void setSender_name(String sender_name) {
        this.sender_name = sender_name;
    }

    public String getSender_phone() {
        return sender_phone;
    }

    public void setSender_phone(String sender_phone) {
        this.sender_phone = sender_phone;
    }

    public String getSender_address() {
        return sender_address;
    }

    public void setSender_address(String sender_address) {
        this.sender_address = sender_address;
    }

    public String getReciever_id() {
        return reciever_id;
    }

    public void setReciever_id(String reciever_id) {
        this.reciever_id = reciever_id;
    }

    public String getReciever_name() {
        return reciever_name;
    }

    public void setReciever_name(String reciever_name) {
        this.reciever_name = reciever_name;
    }

    public String getReciever_phone() {
        return reciever_phone;
    }

    public void setReciever_phone(String reciever_phone) {
        this.reciever_phone = reciever_phone;
    }

    public String getReciever_address() {
        return reciever_address;
    }

    public void setReciever_address(String reciever_address) {
        this.reciever_address = reciever_address;
    }

    public String getSubmit_date() {
        return submit_date;
    }

    public void setSubmit_date(String submit_date) {
        this.submit_date = submit_date;
    }

    public String getOrder_statue() {
        return order_statue;
    }

    public void setOrder_statue(String order_statue) {
        this.order_statue = order_statue;
    }

    public double getOrder_amount() {
        return order_amount;
    }

    public void setOrder_amount(double order_amount) {
        this.order_amount = order_amount;
    }


}
