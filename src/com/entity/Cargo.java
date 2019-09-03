package com.entity;

import java.security.SecureRandom;

public class Cargo {//货物类
    private int shipper_id;//发货人编号
    private String shipper;//发货人
    private String shipper_phone;//发货人电话
    private String shipper_site;//发货人地址
    private int consignee_id;//收货人编号
    private String consignee;//收货人
    private String consignee_phone;//收货人电话
    private String consignee_site;//收货人地址
    private String ship_address;//发货地址
    private String shipping_address;//收货地址
    private String shipments_date;//发货日期
    private String delivery_date;//交货日期
    private double Substitute_loans;//代收款
    private double Substitute_service_charge;//代收手续费
    private String payment_method;//支付方式;
    private String Pickup_way;//取货方式
    private String write_tickets_person;//写票人
    private String write_date;//填写日期
    private double drop_off_charge;//减少金额
    private String transfer_station;//中转站
    private double transit_shipment_cost;//中转费
    private double deliver_goods_cost;//送货费
    private double insurance_cost;//保险费用
    private int Staff_id;//职工编号
    private String remarks;//备注
    private String place_of_receipt;//接货点

    public Cargo() {
    }

    public Cargo(int shipper_id, String shipper, String shipper_phone, String shipper_site, int consignee_id, String consignee, String consignee_phone, String consignee_site, String ship_address, String shipping_address, String shipments_date, String delivery_date, double substitute_loans, double substitute_service_charge, String payment_method, String pickup_way, String write_tickets_person, String write_date, double drop_off_charge, String transfer_station, double transit_shipment_cost, double deliver_goods_cost, double insurance_cost, int staff_id, String remarks, String place_of_receipt) {
        this.shipper_id = shipper_id;
        this.shipper = shipper;
        this.shipper_phone = shipper_phone;
        this.shipper_site = shipper_site;
        this.consignee_id = consignee_id;
        this.consignee = consignee;
        this.consignee_phone = consignee_phone;
        this.consignee_site = consignee_site;
        this.ship_address = ship_address;
        this.shipping_address = shipping_address;
        this.shipments_date = shipments_date;
        this.delivery_date = delivery_date;
        Substitute_loans = substitute_loans;
        Substitute_service_charge = substitute_service_charge;
        this.payment_method = payment_method;
        Pickup_way = pickup_way;
        this.write_tickets_person = write_tickets_person;
        this.write_date = write_date;
        this.drop_off_charge = drop_off_charge;
        this.transfer_station = transfer_station;
        this.transit_shipment_cost = transit_shipment_cost;
        this.deliver_goods_cost = deliver_goods_cost;
        this.insurance_cost = insurance_cost;
        Staff_id = staff_id;
        this.remarks = remarks;
        this.place_of_receipt = place_of_receipt;
    }

    public void setShipper_id(int shipper_id) {
        this.shipper_id = shipper_id;
    }

    public void setShipper(String shipper) {
        this.shipper = shipper;
    }

    public void setShipper_phone(String shipper_phone) {
        this.shipper_phone = shipper_phone;
    }

    public void setShipper_site(String shipper_site) {
        this.shipper_site = shipper_site;
    }

    public void setConsignee_id(int consignee_id) {
        this.consignee_id = consignee_id;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public void setConsignee_phone(String consignee_phone) {
        this.consignee_phone = consignee_phone;
    }

    public void setConsignee_site(String consignee_site) {
        this.consignee_site = consignee_site;
    }

    public void setShip_address(String ship_address) {
        this.ship_address = ship_address;
    }

    public void setShipping_address(String shipping_address) {
        this.shipping_address = shipping_address;
    }

    public void setShipments_date(String shipments_date) {
        this.shipments_date = shipments_date;
    }

    public void setDelivery_date(String delivery_date) {
        this.delivery_date = delivery_date;
    }

    public void setSubstitute_loans(double substitute_loans) {
        Substitute_loans = substitute_loans;
    }

    public void setSubstitute_service_charge(double substitute_service_charge) {
        Substitute_service_charge = substitute_service_charge;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public void setPickup_way(String pickup_way) {
        Pickup_way = pickup_way;
    }

    public void setWrite_tickets_person(String write_tickets_person) {
        this.write_tickets_person = write_tickets_person;
    }

    public void setWrite_date(String write_date) {
        this.write_date = write_date;
    }

    public void setDrop_off_charge(double drop_off_charge) {
        this.drop_off_charge = drop_off_charge;
    }

    public void setTransfer_station(String transfer_station) {
        this.transfer_station = transfer_station;
    }

    public void setTransit_shipment_cost(double transit_shipment_cost) {
        this.transit_shipment_cost = transit_shipment_cost;
    }

    public void setDeliver_goods_cost(double deliver_goods_cost) {
        this.deliver_goods_cost = deliver_goods_cost;
    }

    public void setInsurance_cost(double insurance_cost) {
        this.insurance_cost = insurance_cost;
    }

    public void setStaff_id(int staff_id) {
        Staff_id = staff_id;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setPlace_of_receipt(String place_of_receipt) {
        this.place_of_receipt = place_of_receipt;
    }

    public int getShipper_id() {
        return shipper_id;
    }

    public String getShipper() {
        return shipper;
    }

    public String getShipper_phone() {
        return shipper_phone;
    }

    public String getShipper_site() {
        return shipper_site;
    }

    public int getConsignee_id() {
        return consignee_id;
    }

    public String getConsignee() {
        return consignee;
    }

    public String getConsignee_phone() {
        return consignee_phone;
    }

    public String getConsignee_site() {
        return consignee_site;
    }

    public String getShip_address() {
        return ship_address;
    }

    public String getShipping_address() {
        return shipping_address;
    }

    public String getShipments_date() {
        return shipments_date;
    }

    public String getDelivery_date() {
        return delivery_date;
    }

    public double getSubstitute_loans() {
        return Substitute_loans;
    }

    public double getSubstitute_service_charge() {
        return Substitute_service_charge;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public String getPickup_way() {
        return Pickup_way;
    }

    public String getWrite_tickets_person() {
        return write_tickets_person;
    }

    public String getWrite_date() {
        return write_date;
    }

    public double getDrop_off_charge() {
        return drop_off_charge;
    }

    public String getTransfer_station() {
        return transfer_station;
    }

    public double getTransit_shipment_cost() {
        return transit_shipment_cost;
    }

    public double getDeliver_goods_cost() {
        return deliver_goods_cost;
    }

    public double getInsurance_cost() {
        return insurance_cost;
    }

    public int getStaff_id() {
        return Staff_id;
    }

    public String getRemarks() {
        return remarks;
    }

    public String getPlace_of_receipt() {
        return place_of_receipt;
    }
}
