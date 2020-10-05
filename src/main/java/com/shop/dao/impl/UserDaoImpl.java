package com.shop.dao.impl;

import com.shop.bean.User;
import com.shop.dao.BaseDao;
import com.shop.dao.UserDao;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql="SELECT * FROM `user` WHERE `username` = ? ";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql="SELECT * FROM `user` WHERE `username` = ? AND `password` = ? ";
        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public int SaveUser(User user) {
        String sql="INSERT INTO `user` (`username`,`password`,`email`) VALUES ( ?, ?, ?) ";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
