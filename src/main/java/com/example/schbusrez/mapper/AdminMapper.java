package com.example.schbusrez.mapper;

import com.example.schbusrez.bean.AdminBean;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    AdminBean findByUsernameAndPassword(@Param("id") int id, @Param("password") String password);
}
