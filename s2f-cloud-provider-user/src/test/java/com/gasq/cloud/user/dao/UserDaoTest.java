package com.gasq.cloud.user.dao;

import org.junit.runner.RunWith;

import com.alibaba.fastjson.JSON;
import com.gasq.cloud.user.entity.User;
import com.gasq.cloud.user.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @author tangmin
 * @version V1.0
 * @Title: UserDaoTest.java
 * @Package com.cachexic.springboot.demo.dao
 * @Description:
 * @date 2017-04-04 11:59:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Test
    public void insertUser(){
        User user = new User();
        user.setName("张三4");
        user.setSex("男");
        user.setAge(24);
        user.setRemark("备注");
        user.setCreateTime(new Date());
        userDao.save(user);
    }

    @Test
    public void getAllUser(){
        List<User> users = userDao.findAll();
        System.out.println(JSON.toJSONString(users));
    }

    @Test
    @Rollback(false)
    public void transactional(){
        //修改数据库sex的长度
        userService.insertAandB();
    }

    @Test
    public void findByName(){
        System.out.println(JSON.toJSONString(userDao.findByName("张三")));
    }

}