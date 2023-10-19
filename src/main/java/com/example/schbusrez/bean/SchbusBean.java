package com.example.schbusrez.bean;

import java.io.Serializable;
import java.util.List;

public class SchbusBean implements Serializable {
    private Integer id;
    private Integer seatnum;
    private String cond;
    private String tel;

    public SchbusBean(Integer id,Integer seatnum,String cond,String tel){
        this.id=id;
        this.seatnum=seatnum;
        this.cond=cond;
        this.tel=tel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSeatnum() {
        return seatnum;
    }

    public void setSeatnum(Integer seatnum) {
        this.seatnum = seatnum;
    }

    public String getCond() {
        return cond;
    }

    public void setCond(String cond) {
        this.cond = cond;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
