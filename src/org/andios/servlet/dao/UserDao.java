package org.andios.servlet.dao;

import org.andios.servlet.model.User;

public interface UserDao {
    //用户登录的方法声明
    public User login(User user);
    //用户注册方法的声明
    public boolean register (User user);
}
