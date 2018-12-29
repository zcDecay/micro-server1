package com.advance.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description zuul的权限登录过滤器
 * @Author zcc
 * @Date 18/12/27
 */
@Component
public class LoginFilter extends ZuulFilter {

    /**
     * 返回登录类型
     * pre：被路由之前执行
     * routing：路由请求时执行
     * post：在routing和error过滤器之后执行
     * error：处理请求发生错误调用
     */
    @Override
    public String filterType() {
        // 登录校验，前置过滤器
        return "pre";
    }

    /**
     * 设置顺序
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 返回true代表过滤器生效
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 校验逻辑
     */
    @Override
    public Object run() throws ZuulException {
        // 获取Zuul提供的请求上下文对象
        RequestContext currentContext = RequestContext.getCurrentContext();
        // 上下文中获取request对象
        HttpServletRequest request = currentContext.getRequest();
        // 从请求中获取token
        String token = request.getHeader("NEWT_TOKEN");
        //String token = request.getParameter("NEWT_TOKEN");

        if (null == token && "".equals(token.trim())) {
            // 没有token，登录校验失败，拦截
            currentContext.setSendZuulResponse(false);
            // 返回401代码，重定向到登录页面
            currentContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        // 校验通过，可以考虑把用户信息放入上下文，继续向后执行
        return token;
    }
}
