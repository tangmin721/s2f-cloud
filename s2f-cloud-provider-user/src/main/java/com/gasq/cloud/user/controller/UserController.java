package com.gasq.cloud.user.controller;

import com.gasq.cloud.user.dao.UserDao;
import com.gasq.cloud.user.entity.User;
import com.gasq.cloud.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author tangmin
 * @version V1.0
 * @Title: UserController.java
 * @Package com.cachexic.springboot.demo.controller
 * @Description: use
 * @date 2017-04-04 11:16:37
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @GetMapping("users")
    public List<User> getUser(){
        logger.info("UserController:get user method print");

        return userDao.findAll();
    }

    @PostMapping(value = "saveUser")
    public User saveUser(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        return userDao.save(user);
    }

    @PutMapping("updataUser")
    public User updateUser(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        return userDao.save(user);
    }

    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userDao.delete(id);
    }

    @GetMapping("forAgeReturnSomeMsg/{id}")
    public void forAgeReturnSomeMsg(@PathVariable Long id) throws Exception {
//        User user = null;
//        user.toString();
        userService.forAgeReturnSomeMsg(id);
    }

}
