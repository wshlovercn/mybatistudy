package com.wshlovercn.mybatistudy.dao.dao;

import com.wshlovercn.mybatistudy.dao.entity.User;

import java.util.List;

public interface UserDao {
    User queryById(Integer id);

    List<User> queryAll();
}
