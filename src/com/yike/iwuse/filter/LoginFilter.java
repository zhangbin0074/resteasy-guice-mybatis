package com.yike.iwuse.filter;

import com.google.inject.Singleton;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 接口用户登录过滤器
 * Created by hunk on 2015/8/20.
 */
//@WebFilter(filterName = "LoginFilter", urlPatterns = {"/rest/*"})
@Singleton
public class LoginFilter implements Filter {
    private final static String prix = "_MCH_AT";
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String url = request.getRequestURI();
        System.out.println("url: " + url);
        HttpSession session = request.getSession(false);
        String cookie = request.getHeader("Cookie");
        if (null!=cookie && cookie.startsWith(prix)){
            chain.doFilter(req, resp);
            return;
        }

        chain.doFilter(req, resp);

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
