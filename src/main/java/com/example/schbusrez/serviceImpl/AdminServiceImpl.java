package com.example.schbusrez.serviceImpl;

import com.example.schbusrez.bean.AdminBean;
import com.example.schbusrez.mapper.AdminMapper;
import com.example.schbusrez.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public AdminBean land(int id,String password){
        return adminMapper.findByUsernameAndPassword(id, password);
    }
}
