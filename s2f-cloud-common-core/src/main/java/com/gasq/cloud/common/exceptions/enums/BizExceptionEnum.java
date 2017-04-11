package com.gasq.cloud.common.exceptions.enums;

/**
 * Created by tangm on 2017/4/4.
 */
public enum BizExceptionEnum {
    UNKONW(-1,"未知异常"),
    SERVER_STOP(-2,"系统停止");

    private int code;
    private String msg;

    /**
     * 构造方法
     * @param code
     * @param msg
     */
    BizExceptionEnum(int code,String msg){
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
