package com.shop.dao;

import com.shop.bean.User;

public interface UserDao {
    /**
     *根据用户名查询用户记录  （用户判断有没有这个用户名，在注册时）
     *
     * @param username 用户名
     * @return 如果null说明没有这个用户
     */
    public User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户记录（用于判断登录是否成功）
     *
     * @param username  用户名
     * @param password  密码
     * @return  如果null说明没有这个用户
     */
    public User queryUserByUsernameAndPassword(String username,String password);

    /**
     * 保存用户信息（用于创建新用户）
     * @param user
     * @return
     */
    public int SaveUser(User user);
}
