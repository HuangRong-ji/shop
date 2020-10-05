package com.shop.controller;

import com.shop.bean.User;
import com.shop.service.UserService;
import com.shop.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistServlet")
public class RegistServlet extends HttpServlet {
    UserService userService=new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取前端传来的参数
        String usernname=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String code=request.getParameter("code");

        if("lckx".equalsIgnoreCase(code)){
            if(userService.existsUsername(usernname)){
                //用户名存在
                System.out.println("用户名已存在");
                //重新加载注册页面
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
            }else{
                //调用注册的方法
                userService.registUser(new User(usernname,password,email));
                //注册成功，返回注册成功页面
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request,response);
            }
        }else{
            System.out.println("验证码["+code+"]不正确");
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
