package com.example.schbusrez.mapper;

import com.example.schbusrez.bean.AdminBean;
import com.example.schbusrez.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public interface UserMapper {
    UserBean getInfo(@Param("id") int id,@Param("password") String password);
}
