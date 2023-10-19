package com.example.schbusrez.mapper;

import com.example.schbusrez.bean.RezBean;
import com.example.schbusrez.bean.SchbusBean;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RezMapper {
    int addRez(RezBean rezBean);
    List<RezBean> findAll();
    int updateRez(RezBean rezBean);
}
