package com.shop.controller;

import com.shop.bean.User;
import com.shop.service.UserService;
import com.shop.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (userService.loginUser(new User(username, password)) != null) {
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("password", password);

//            System.out.println("login...");
//
//            System.out.println(request.getSession().getAttribute("username"));
//            System.out.println(request.getSession().getAttribute("password"));
//            System.out.println("login...");

            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        } else {
            response.sendRedirect("pages/user/login.jsp");
        }
    }

    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");

        if ("lckx".equalsIgnoreCase(code)) {
            if (userService.existsUsername(username)) {
                //用户名存在
                System.out.println("用户名已存在");
                //重新加载注册页面
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            } else {
                //调用注册的方法
                userService.registUser(new User(username, password, email));
                //注册成功，返回注册成功页面
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("msg", "验证码错误！！");
            request.setAttribute("username", username);
            request.setAttribute("email", email);
            System.out.println("验证码[" + code + "]不正确");
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        }
    }

}
