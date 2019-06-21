package com.wshlovercn.mybatistudy.dao.respository;

import com.wshlovercn.mybatistudy.dao.dao.UserDao;
import com.wshlovercn.mybatistudy.dao.entity.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImpl implements UserDao {
    public SqlSession sqlSession;

    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public User queryById(Integer id) {
        return this.sqlSession.selectOne("UserDao.queryById", id);
    }

    public List<User> queryAll() {
        return this.sqlSession.selectList("UserDao.queryAll");
    }
}
