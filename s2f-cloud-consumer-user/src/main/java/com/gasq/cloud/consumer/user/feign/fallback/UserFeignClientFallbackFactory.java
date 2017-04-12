package com.gasq.cloud.consumer.user.feign.fallback;

import com.gasq.cloud.common.result.Result;
import com.gasq.cloud.common.result.ResultUtil;
import com.gasq.cloud.consumer.user.entity.User;
import com.gasq.cloud.consumer.user.feign.UserFeignClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author tangmin
 * @version V1.0
 * @Title: UserFeignClientFactory.java
 * @Package com.gasq.cloud.consumer.user.feign.fallback
 * @Description: Feign利用fallbackFactory属性，打印fallback异常.(fallback = UserFeignClientFallback.class 的增强版)
 * @date 2017-04-12 18:54:03
 */
@Component
public class UserFeignClientFallbackFactory implements FallbackFactory<UserFeignClient>{

    private static final Logger logger = LoggerFactory.getLogger(UserFeignClientFallbackFactory.class);

    @Override
    public UserFeignClient create(Throwable cause) {
        //一进fallback就能拦截到异常
        logger.info("fall back reason was :{}",cause.getMessage());

        return new UserFeignClientWithFallBackFactory() {

            @Override
            public Result getUserById(Long id) {
                return ResultUtil.FAIL("FallbackFactory getUserById fall back");
            }

            @Override
            public Result saveUser(String name, Integer age, String remark) {
                return ResultUtil.FAIL("FallbackFactory saveUser fall back");
            }

            @Override
            public Result saveUserEntity(User user) {
                return ResultUtil.FAIL("FallbackFactory saveUserEntity fall back");
            }
        };
    }
}
