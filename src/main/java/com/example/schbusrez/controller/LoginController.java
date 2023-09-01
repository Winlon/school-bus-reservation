package com.example.schbusrez.controller;

import com.example.schbusrez.bean.AdminBean;
import com.example.schbusrez.bean.UserBean;
import com.example.schbusrez.mapper.AdminMapper;
import com.example.schbusrez.mapper.UserMapper;
import com.example.schbusrez.service.AdminService;
import com.example.schbusrez.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;

@Controller
public class LoginController {

    //将Service注入Web层
    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String show(){
        return "login";
    }

    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
    public String login(int id,String password){
        UserBean userBean = userService.loginIn(id,password);
        AdminBean adminBean = adminService.land(id,password);
        if (userBean!=null){
            return "success";
        }else if (adminBean!=null)
            return "admin";
        else
            return "error";
    }
}
