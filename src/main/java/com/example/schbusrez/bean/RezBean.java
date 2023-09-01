package com.example.schbusrez.bean;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class RezBean {
    private Integer id;
    private Integer stuid;
    private Timestamp time;
    private String use;
    private String from;
    private String to;
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public RezBean(Integer id, Integer stuid, Timestamp time, String use, String from, String to, String status){
        this.id=id;
        this.stuid=stuid;
        this.time=time;
        this.use=use;
        this.from=from;
        this.to=to;
        this.status=status;
    }
}
