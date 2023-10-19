package com.example.schbusrez.controller;

import com.example.schbusrez.bean.AdminBean;
import com.example.schbusrez.bean.UserBean;
import com.example.schbusrez.mapper.AdminMapper;
import com.example.schbusrez.mapper.UserMapper;
import com.example.schbusrez.service.AdminService;
import com.example.schbusrez.service.UserService;
import io.netty.util.concurrent.CompleteFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

@Controller
public class LoginController {

    //将Service注入Web层
    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;
    @Autowired
    private ThreadPoolTaskExecutor applicationTaskExecutor;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String show(){
        return "login";
    }

    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
    public String login(int id,String password) throws ExecutionException, InterruptedException {
        //异步执行
        CompletableFuture<UserBean> userFuture = CompletableFuture.supplyAsync(new Supplier<UserBean>() {
            @Override
            public UserBean get() {
                UserBean uB = userService.login(id,password);
                return uB;
            }
        }, applicationTaskExecutor);
        //异步执行
        CompletableFuture<AdminBean> adminFuture = CompletableFuture.supplyAsync(new Supplier<AdminBean>() {
            @Override
            public AdminBean get() {
                AdminBean aB = adminService.land(id,password);
                return aB;
            }
        }, applicationTaskExecutor);
        UserBean userBean=userFuture.get();
        AdminBean adminBean=adminFuture.get();
        if (userBean!=null)
            return "success";
        else if (adminBean!=null)
            return "admin";
        else
            return "error";
    }
}
