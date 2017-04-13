package com.gasq.cloud.common.fallback;

import com.gasq.cloud.common.result.ResultUtil;
import com.gasq.cloud.common.utils.JacksonUtils;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author tangmin
 * @version V1.0
 * @Title: MyFallbackProvider.java
 * @Package com.gasq.cloud
 * @Description: 自定义zull fallback的返回
 * @date 2017-04-13 15:06:49
 */
@Component
public class GasqZuulFallbackProvider implements ZuulFallbackProvider {
    @Override
    public String getRoute() {
        return "s2f-cloud-provider-user";
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.BAD_REQUEST;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.BAD_REQUEST.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.BAD_REQUEST.name();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream(JacksonUtils.obj2json(ResultUtil.FAIL(-400,"gasqZuulFallbackProvider")).getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}
