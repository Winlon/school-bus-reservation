package com.example.schbusrez.bean;

import org.springframework.stereotype.Repository;


public class UserBean {
    private int id;
    private String password;
    private String tel;

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getTel() {
        return tel;
    }
}
