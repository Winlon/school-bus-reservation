package com.example.schbusrez;

import com.example.schbusrez.SchbusrezApplication;
import com.example.schbusrez.bean.SchbusBean;
import com.example.schbusrez.bean.UserBean;
import com.example.schbusrez.service.SchbusService;
import com.example.schbusrez.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SchbusrezApplication.class)
public class SchbusrezApplicationTests {

    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {
        UserBean userBean = userService.login(200207339,"qq147211xwl");
        System.out.println("该用户tel为：");
        System.out.println(userBean.getTel());
    }
}