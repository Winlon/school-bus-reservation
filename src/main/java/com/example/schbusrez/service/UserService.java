package com.example.schbusrez.service;

import com.example.schbusrez.bean.UserBean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

public interface UserService {
    UserBean login(int id, String password);
}