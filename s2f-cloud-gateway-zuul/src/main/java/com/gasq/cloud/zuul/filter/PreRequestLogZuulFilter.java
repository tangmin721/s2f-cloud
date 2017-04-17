package com.gasq.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tangmin
 * @version V1.0
 * @Title: PreRequestLogZuulFilter.java
 * @Package com.gasq.cloud.zuul.filter
 * @Description: 前置filter（4种：PRE,ROUTING,POST,ERROR）
 * http://www.itmuch.com/spring-cloud/zuul/spring-cloud-zuul-filter/
 * (1) PRE：这种过滤器在请求被路由之前调用。我们可利用这种过滤器实现身份验证、在集群中选择请求的微服务、记录调试信息等。
 * (2) ROUTING：这种过滤器将请求路由到微服务。这种过滤器用于构建发送给微服务的请求，并使用Apache HttpClient或Netfilx Ribbon请求微服务。
 * (3) POST：这种过滤器在路由到微服务以后执行。这种过滤器可用来为响应添加标准的HTTP Header、收集统计信息和指标、将响应从微服务发送给客户端等。
 * (4) ERROR：在其他阶段发生错误时执行该过滤器。
 *
 * Spring Cloud默认为Zuul编写并启用了一些过滤器，例如DebugFilter、FormBodyWrapperFilter、PreDecorationFilter等。这些过滤器都存放在spring-cloud-netflix-core这个Jar包的org.springframework.cloud.netflix.zuul.filters包中。
 * @date 2017-04-16 18:11:14
 */
public class PreRequestLogZuulFilter extends ZuulFilter{

    private static final Logger log = LoggerFactory.getLogger(PreRequestLogZuulFilter.class);
    /**
     *filterType：返回过滤器的类型。有pre、route、post、error等几种取值，分别对应上文的几种过滤器。详细可以参考com.netflix.zuul.ZuulFilter.filterType() 中的注释。
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * filterOrder：返回一个int值来指定过滤器的执行顺序，不同的过滤器允许返回相同的数字。
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * shouldFilter：返回一个boolean值来判断该过滤器是否要执行，true表示执行，false表示不执行。
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * run：过滤器的具体逻辑。本实现中，我们让它打印了请求的HTTP方法以及请求的地址。
     * @return
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("请求的host:%s send %s request to %s",request.getRemoteHost(), request.getMethod(), request.getRequestURL().toString()));
        return null;
    }
}
