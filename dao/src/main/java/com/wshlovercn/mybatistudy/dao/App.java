package com.wshlovercn.mybatistudy.dao;

import com.wshlovercn.mybatistudy.dao.dao.UserDao;
import com.wshlovercn.mybatistudy.dao.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class App {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        InputStream inputStream;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //使用自己的实现类
//        UserDao dao = new UserDaoImpl(sqlSession);

        //动态代理，不需要写实现类
        UserDao dao = sqlSession.getMapper(UserDao.class);

        User user = dao.queryById(3);
        System.out.println(user);

        List<User> users = dao.queryAll();
        System.out.println(users);

        sqlSession.close();
    }
}
