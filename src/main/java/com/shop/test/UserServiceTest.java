package com.shop.test;

import com.shop.bean.User;
import com.shop.service.UserService;
import com.shop.service.impl.UserServiceImpl;
import org.junit.Test;

public class UserServiceTest {
    UserService userService=new UserServiceImpl();

    @Test
    public void registUser(){
        System.out.println(userService.registUser(new User("1234","123","123")));
    }

    @Test
    public void loginUser(){
        System.out.println(userService.loginUser(new User("admin","123")).toString());
    }

    @Test
    public void existsUsername(){
        if((userService.existsUsername("admin"))){
            System.out.println("用户名不可用");
        }else{
            System.out.println("用户名可用");
        }
    }
}
