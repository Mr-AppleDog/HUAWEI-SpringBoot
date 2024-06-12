package com.huawei.filter;


import com.huawei.controller.BaseController;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class CustomHeaderFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        // 从请求头中获取某个特定的值
        String token = httpServletRequest.getHeader("Token");
        // 你可以在这里对headerValue进行处理，或者将其存储到某个地方
        HttpSession session = httpServletRequest.getSession();
        if (token != null) {
            session.setAttribute("token", token);
        }
        // 继续处理请求链
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
