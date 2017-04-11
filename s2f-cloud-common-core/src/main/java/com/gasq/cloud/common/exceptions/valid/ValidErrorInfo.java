package com.gasq.cloud.common.exceptions.valid;

/**
 * @author tangmin
 * @version V1.0
 * @Title: ValidErrorInfo.java
 * @Package com.cachexic.springboot.common.exceptions.valid
 * @Description: 转换org.springframework.validation.FieldError
 * @date 2017-04-08 17:25:04
 */
public class ValidErrorInfo {
    private String field;
    private String errMsg;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
