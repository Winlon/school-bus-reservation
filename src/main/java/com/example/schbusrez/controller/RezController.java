package com.example.schbusrez.controller;

import com.example.schbusrez.bean.RezBean;
import com.example.schbusrez.mapper.RezMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RezController{
    @Autowired
    RezMapper rezMapper;
    @PostMapping("/api/appointment")
    @ResponseBody
    public String addAppointment(@RequestBody RezBean rezBean){
        int rows = rezMapper.addRez(rezBean);
        if (rows == 1){
            return "success";
        }else {
            return "fail";
        }
    }
}
