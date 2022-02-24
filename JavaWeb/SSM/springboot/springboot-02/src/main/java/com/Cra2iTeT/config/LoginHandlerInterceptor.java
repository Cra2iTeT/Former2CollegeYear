package com.Cra2iTeT.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object session = request.getSession().getAttribute("loginUser");
        if (session != null) {
            return true;
        } else {
            request.setAttribute("msg", "请先登录");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        }
    }
}
