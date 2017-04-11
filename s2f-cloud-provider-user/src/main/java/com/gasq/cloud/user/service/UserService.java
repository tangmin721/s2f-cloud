package com.gasq.cloud.user.service;

/**
 * @author tangmin
 * @version V1.0
 * @Title: UserServiceImpl.java
 * @Package com.cachexic.springboot.system.service
 * @Description: 
 * @date 2017-04-04 18:47:19
 */
public interface UserService {

    /**
     * 测试事务方法
     */
    void insertAandB();

    /**
     * 测试 抛出不同异常.根据user的age分别返回不一样的提示信息
     * @param id
     */
    void forAgeReturnSomeMsg(Long id) throws Exception;
}
