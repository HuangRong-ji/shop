package com.shop.service;

import com.shop.bean.User;

public interface UserService {

    /**
     * 用于注册用户
     * @param user 注册用户
     */
    public boolean registUser(User user);

    /**
     * 用于用户登录
     * @param user  登录的用户
     * @return 返回null证明数据库没有该用户
     */
    public User loginUser(User user);

    /**
     * 查看用户是否存在
     * @param username  用户名
     * @return  返回true证明用户可用
     */
    public boolean existsUsername(String username);
}
