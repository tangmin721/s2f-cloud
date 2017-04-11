package com.gasq.cloud.user.dao;


import com.gasq.cloud.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author tangmin
 * @version V1.0
 * @Title: UserDao.java
 * @Package com.cachexic.springboot.demo.dao
 * @Description: 直接继承就可以了，不需要任何配置，泛型表示<实体类，ID类型></>
 * @date 2017-04-04 11:52:24
 */
public interface UserDao extends JpaRepository<User,Long> {

    /**
     * 自定义的查询方法,只需要名称按规则
     * @param name
     * @return
     */
    List<User> findByName(String name);
}
