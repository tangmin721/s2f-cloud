package com.gasq.cloud.user.service.impl;


import com.gasq.cloud.common.exceptions.BizException;
import com.gasq.cloud.common.exceptions.UserBizException;
import com.gasq.cloud.common.exceptions.enums.BizExceptionEnum;
import com.gasq.cloud.common.exceptions.enums.UserBizExceptionEnum;
import com.gasq.cloud.user.dao.UserDao;
import com.gasq.cloud.user.entity.User;
import com.gasq.cloud.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * @author tangmin
 * @version V1.0
 * @Title: UserServiceImpl.java
 * @Package com.cachexic.springboot.system.service.impl
 * @Description:
 * @date 2017-04-04 18:49:15
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void insertAandB() {
        User userA = new User();
        userA.setName("userA");
        userA.setCreateTime(new Date());
        userA.setSex("男");
        userA.setAge(29);
        userA.setRemark("beizhuA");
        userDao.save(userA);

        User userB = new User();
        userB.setName("userB");
        userB.setCreateTime(new Date());
        userB.setSex("女女女女女女女女女");
        userB.setAge(29);
        userB.setRemark("beizhuA");
        userDao.save(userB);

    }

    /**
     * 异常测试类（1,2,3）
     * @param id
     * @throws Exception
     */
    public void forAgeReturnSomeMsg(Long id) throws Exception {
        User user = userDao.findOne(id);
        int age = user.getAge();

        if(age<10){
            throw new BizException(BizExceptionEnum.SERVER_STOP);
        }else if(age>90){
            throw new UserBizException(UserBizExceptionEnum.USER_NOT_EXIT);
        }else{
            User user1 = new User();
            user1.getName().toString();
        }

    }
}
