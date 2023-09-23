package com.newlecture.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("before filter");
        request.setCharacterEncoding("UTF-8");
        filterChain.doFilter(request, response);
        System.out.println("after filter");
    }

    @Override
    public void destroy() {

    }
}
