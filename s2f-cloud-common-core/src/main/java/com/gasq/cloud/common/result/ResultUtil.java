package com.gasq.cloud.common.result;

/**
 * @author tangmin
 * @version V1.0
 * @Title: ResultUtil.java
 * @Package com.cachexic.springboot.common.result
 * @Description: 统一包装返回
 * @date 2017-04-04 22:15:32
 */
public class ResultUtil {

    private final static int SUCCESS_CODE = 0;
    private final static String SUCCESS_MSG = "SUCCESS";
    private final static int FAIL_CODE = -10;
    private final static String FAIL_MSG = "FAIL";

    /**
     * 不需要返回数据的成功
     * @return
     */
    public static Result SUCCESS(){
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        result.setMsg(SUCCESS_MSG);
        return result;
    }

    /**
     * 需要返回数据的成功
     * @param object
     * @return
     */
    public static Result SUCCESS(Object object){
        Result success = ResultUtil.SUCCESS();
        success.setData(object);
        return success;
    }

    /**
     * 失败
     * @param object
     * @return
     */
    public static Result FAIL(Object object){
        Result result = new Result();
        result.setCode(FAIL_CODE);
        result.setMsg(FAIL_MSG);
        result.setData(object);
        return result;
    }

    /**
     * 带code的失败,不带返回object
     * @param code
     * @param msg
     * @return
     */
    public static Result FAIL(int code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    /**
     * 带code的失败,带返回object
     * @param code
     * @param msg
     * @param object
     * @return
     */
    public static Result FAIL(int code,String msg,Object object){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(object);
        return result;
    }
}
