package com.example.schbusrez.serviceImpl;

import com.example.schbusrez.bean.UserBean;
import com.example.schbusrez.mapper.UserMapper;
import com.example.schbusrez.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    //将DAO注入Service层
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserBean loginIn(int id, String password){
        return userMapper.getInfo(id,password);
    }
}