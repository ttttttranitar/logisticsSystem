package com.entity;

public class Transfer {//中转
    private int id;//id
    private String city;//城市
    private String companyName;//公司名称
    private String linkPhone;//联系电话
    private String detailAddress;//详细地址

    public Transfer() {
    }

    public Transfer(String city, String companyName, String linkPhone, String detailAddress) {
        this.id=id;
        this.city = city;
        this.companyName = companyName;
        this.linkPhone = linkPhone;
        this.detailAddress = detailAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }
}
