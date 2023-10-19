package com.example.schbusrez.serviceImpl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.example.schbusrez.bean.UserBean;
import com.example.schbusrez.mapper.UserMapper;
import com.example.schbusrez.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    //将DAO注入Service层
    @Autowired
    private UserMapper userMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public UserBean login(int id, String password) {
        String key = "cash:user:" + id;
        //1.从redis查询用户缓存
        String userJson = stringRedisTemplate.opsForValue().get(key);
        //2.判断是否存在
        if (StrUtil.isNotBlank(userJson)) {
            //3.存在，直接返回
            UserBean userBean = JSONUtil.toBean(userJson, UserBean.class);
            return userBean;
        }
        //4.不存在，根据id、password查询数据库
        UserBean userBean = userMapper.getInfo(id,password);
        //5.不存在，返回错误
        if (userBean == null) {
            return null;
        }
        //6.存在，写入redis
        stringRedisTemplate.opsForValue().set(key,JSONUtil.toJsonStr(userBean));
        //7.返回
        return userBean;
    }
}