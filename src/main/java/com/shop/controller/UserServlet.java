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
                //�û�������
                System.out.println("�û����Ѵ���");
                //���¼���ע��ҳ��
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            } else {
                //����ע��ķ���
                userService.registUser(new User(username, password, email));
                //ע��ɹ�������ע��ɹ�ҳ��
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("msg", "��֤����󣡣�");
            request.setAttribute("username", username);
            request.setAttribute("email", email);
            System.out.println("��֤��[" + code + "]����ȷ");
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        }
    }

}
