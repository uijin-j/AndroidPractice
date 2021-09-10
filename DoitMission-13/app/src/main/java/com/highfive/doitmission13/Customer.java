package com.highfive.doitmission13;

public class Customer {
    String name; //이름
    String birth; //생년월일
    String mobile; //전화번호

    public Customer(String name, String birth, String mobile) {
        this.name = name;
        this.birth = birth;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
