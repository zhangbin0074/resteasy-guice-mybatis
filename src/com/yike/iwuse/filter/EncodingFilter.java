package com.yike.iwuse.filter;

import com.google.inject.Singleton;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 编码过滤器
 * Created by hunk on 2015/8/20.
 */
// @WebFilter(filterName = "EncodingFilter", urlPatterns = {"/*"})
    @Singleton
public class EncodingFilter implements Filter {
    private final static String ENCODEING = "UTF-8";
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding(ENCODEING);
        resp.setCharacterEncoding(ENCODEING);
        resp.setContentType("text/html;charset=UTF-8");
//        System.out.printf("encodeing....");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
