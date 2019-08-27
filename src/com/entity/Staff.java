package com.entity;

public class Staff {/*职工类*/
    private int staff_id;//职工编号
    private String staff_name;//职工姓名
    private String department;//部门
    private String position;//职位
    private String sex;//性别
    private int user_condition;//用户情况
    private String birthday;//出生日期（生日的单词）

    public Staff() {
    }

    public Staff(int staff_id, String staff_name, String department, String position, String sex, int user_condition, String birthday) {
        this.staff_id = staff_id;
        this.staff_name = staff_name;
        this.department = department;
        this.position = position;
        this.sex = sex;
        this.user_condition = user_condition;
        this.birthday = birthday;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setUser_condition(int user_condition) {
        this.user_condition = user_condition;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }

    public String getSex() {
        return sex;
    }

    public int getUser_condition() {
        return user_condition;
    }

    public String getBirthday() {
        return birthday;
    }
}
