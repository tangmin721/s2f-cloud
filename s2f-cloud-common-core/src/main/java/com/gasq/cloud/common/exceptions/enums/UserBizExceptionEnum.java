package com.gasq.cloud.common.exceptions.enums;

/**
 * @author tangmin
 * @version V1.0
 * @Title: UserBizExceptionEnum.java
 * @Package com.cachexic.springboot.common.exceptions.enums
 * @Description: 用户模块的异常定义
 * @date 2017-04-04 22:54:18
 */
public enum UserBizExceptionEnum {
    UNKONW(-1,"未知异常"),
    USER_NOT_EXIT(10,"用户不存在"),
    USER_FOBBIT(11,"用户已被禁用11");

    private int code;
    private String msg;

    /**
     * 构造方法
     * @param code
     * @param msg
     */
    UserBizExceptionEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
