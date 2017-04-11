package com.gasq.cloud.common.exceptions;

import com.gasq.cloud.common.result.Result;
import com.gasq.cloud.common.result.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author tangmin
 * @version V1.0
 * @Title: ExceptionHandle.java
 * @Package com.cachexic.springboot.common.exceptions
 * @Description: 统一异常处理
 * @date 2017-04-04 22:31:25
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    /**
     * 异常统一返回
     *
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        //先写具体的业务异常
        if (e instanceof UserBizException) {
            UserBizException userBizException = (UserBizException) e;
            return ResultUtil.fail(userBizException.getCode(), userBizException.getMessage());

            //再写总的业务异常
        } else if (e instanceof BizException) {
            BizException bizException = (BizException) e;
            return ResultUtil.fail(bizException.getCode(), bizException.getMessage());
        } else {
            logger.error("[系统异常]{}", e);
            return ResultUtil.fail(-100, "系统异常：" + e.getMessage());
        }
    }
}
