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

    /**
     * 不需要返回数据的成功
     * @return
     */
    public static Result success(){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        //result.setData(object);
        return result;
    }

    /**
     * 需要返回数据的成功
     * @param object
     * @return
     */
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    /**
     * 失败，返回不一样的code，便于定位错误
     * @param code
     * @return
     */
    public static Result fail(int code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
