package com.shop.test;

import com.shop.bean.User;
import com.shop.dao.UserDao;
import com.shop.dao.impl.UserDaoImpl;
import org.junit.Test;

public class UserDaoTest {

    UserDao userDao=new UserDaoImpl();

    @Test
    public void queryUserByUsername(){
        if(userDao.queryUserByUsername("admin")==null){
            System.out.println("用户名可用");
        }else{
            System.out.println("用户名已存在");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword(){
        if(userDao.queryUserByUsernameAndPassword("admin","1234")==null){
            System.out.println("登录失败，账号或密码错误");
        }else{
            System.out.println("登录成功");
        }
    }

    @Test
    public void SaveUser(){
        System.out.println(userDao.SaveUser(new User("admin2","123","123@qq.com")));
    }
}
