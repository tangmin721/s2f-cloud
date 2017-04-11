package com.gasq.cloud.common.exceptions;


import com.gasq.cloud.common.exceptions.enums.UserBizExceptionEnum;

/**
 * @author tangmin
 * @version V1.0
 * @Title: BizException.java
 * @Package com.cachexic.springboot.common.exceptions
 * @Description: 用户模块业务异常类，继承业务异常，包装更多信息，比如code
 * @date 2017-04-04 22:39:40
 */
public class UserBizException extends BizException{
    /**
     * 构造方法
     * @param userBizExceptionEnum
     */
    public UserBizException(UserBizExceptionEnum userBizExceptionEnum){
        super(userBizExceptionEnum.getCode(), userBizExceptionEnum.getMsg());
    }
}
