package com.shop.filter;


import com.shop.bean.User;
import com.shop.service.UserService;
import com.shop.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter {
    UserService userService = new UserServiceImpl();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        HttpSession session = request.getSession();


        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");

//        String uri = request.getRequestURI();

        if (username == null || password == null || userService.loginUser(new User(username, password)) == null) {
//            System.out.println("拦截到的uri： " + uri);
            servletRequest.getRequestDispatcher("/pages/user/login.jsp").forward(servletRequest, servletResponse);
            return;

        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
