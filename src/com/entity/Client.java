package com.entity;

public class Client {//客户类
    private int customer_id;//客户编号
    private String customer_name;//客户姓名
    private String phone;//电话
    private String faxed;//传真
    private int postcode;//邮政编码
    private  String site;//地址
    private  String contacts;//联系人
    private  String Contact_phone;//联系人手机
    private  String client_type;//客户类型
    private  String enterprise_property;//企业性质
    private  String enterprise_scale;//企业规模
    private  String email;//电子邮件

    public Client() {
    }

    public Client(int customer_id, String customer_name, String phone, String faxed, int postcode, String site, String contacts, String contact_phone, String client_type, String enterprise_property, String enterprise_scale, String email) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.phone = phone;
        this.faxed = faxed;
        this.postcode = postcode;
        this.site = site;
        this.contacts = contacts;
        Contact_phone = contact_phone;
        this.client_type = client_type;
        this.enterprise_property = enterprise_property;
        this.enterprise_scale = enterprise_scale;
        this.email = email;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFaxed() {
        return faxed;
    }

    public void setFaxed(String faxed) {
        this.faxed = faxed;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getContact_phone() {
        return Contact_phone;
    }

    public void setContact_phone(String contact_phone) {
        Contact_phone = contact_phone;
    }

    public String getClient_type() {
        return client_type;
    }

    public void setClient_type(String client_type) {
        this.client_type = client_type;
    }

    public String getEnterprise_property() {
        return enterprise_property;
    }

    public void setEnterprise_property(String enterprise_property) {
        this.enterprise_property = enterprise_property;
    }

    public String getEnterprise_scale() {
        return enterprise_scale;
    }

    public void setEnterprise_scale(String enterprise_scale) {
        this.enterprise_scale = enterprise_scale;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
