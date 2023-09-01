package com.example.schbusrez.controller;

import com.example.schbusrez.bean.SchbusBean;
import com.example.schbusrez.mapper.SchbusMapper;
import com.example.schbusrez.service.SchbusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/success")
public class SchbusController {

    private final SchbusMapper schbusMapper;

    public SchbusController(SchbusMapper schbusMapper){
        this.schbusMapper=schbusMapper;
    }
    @RequestMapping("")
    public List<SchbusBean> getSchoolBusList(){
        return schbusMapper.showInfo();
    }
}
