package com.example.schbusrez.mapper;

import com.example.schbusrez.bean.SchbusBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
public interface SchbusMapper {
    List<SchbusBean> showInfo();
    SchbusBean findBusById(Integer id);
    int addBus(SchbusBean schbusBean);
    int updateBus(SchbusBean schbusBean);
    int deleteBus(Integer id);
}