package com.example.schbusrez.controller;

import com.example.schbusrez.bean.RezBean;
import com.example.schbusrez.bean.SchbusBean;
import com.example.schbusrez.mapper.RezMapper;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/booking/info")
public class BookingController {

    private final RezMapper rezMapper;

    public BookingController(RezMapper rezMapper){
        this.rezMapper=rezMapper;
    }
    @GetMapping("")
    public List<RezBean> getBookingList(){
        return rezMapper.findAll();
    }
    @PutMapping("/{id}")
    public void updaterez(@PathVariable Integer id, @RequestBody RezBean rezBean){
        rezBean.setId(id);
        rezMapper.updateRez(rezBean);
    }
}
