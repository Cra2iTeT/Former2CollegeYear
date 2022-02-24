package com.Cra2iTeT.filter;

import com.Cra2iTeT.pojo.Ls;
import com.Cra2iTeT.pojo.Stu;
import com.Cra2iTeT.pojo.Tea;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SysFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //过滤器，从Session中获取用户
        Object o = request.getSession().getAttribute("userSession");

        if (o == null) {//用户未登录或者被移除出库了
            response.getWriter().print("<script> alert(\"请先登录\"); window.location='Login.jsp'</script>");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
    }
}
