package com.shop.service.impl;

import com.shop.bean.User;
import com.shop.dao.UserDao;
import com.shop.dao.impl.UserDaoImpl;
import com.shop.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao=new UserDaoImpl();
    @Override
    public boolean registUser(User user) {
        int resutl= userDao.SaveUser(user);
        return (resutl>-1);
    }

    @Override
    public User loginUser(User user) {
        return  userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());

    }

    @Override
    public boolean existsUsername(String username) {
        return (userDao.queryUserByUsername(username)!=null);
    }
}
