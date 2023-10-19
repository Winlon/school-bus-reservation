package com.example.schbusrez.serviceImpl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.example.schbusrez.bean.AdminBean;
import com.example.schbusrez.bean.UserBean;
import com.example.schbusrez.mapper.AdminMapper;
import com.example.schbusrez.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public AdminBean land(int id,String password){
        String key = "cash:admin:" + id;
        //1.从redis查询用户缓存
        String adminJson = stringRedisTemplate.opsForValue().get(key);
        //2.判断是否存在
        if (StrUtil.isNotBlank(adminJson)) {
            //3.存在，直接返回
            AdminBean adminBean = JSONUtil.toBean(adminJson, AdminBean.class);
            return adminBean;
        }
        //4.不存在，根据id、password查询数据库
        AdminBean adminBean = adminMapper.findByUsernameAndPassword(id,password);
        //5.不存在，返回错误
        if (adminBean == null) {
            return null;
        }
        //6.存在，写入redis
        stringRedisTemplate.opsForValue().set(key,JSONUtil.toJsonStr(adminBean));
        //7.返回
        return adminBean;
    }
}
