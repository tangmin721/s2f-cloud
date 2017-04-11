package com.gasq.cloud.common.result;

/**
 * @author tangmin
 * @version V1.0
 * @Title: Result.java
 * @Package com.cachexic.springboot.common.result
 * @Description: 返回信息统一包装
 * @date 2017-04-04 22:13:02
 */
public class Result {
    private int code;
    private String msg;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
