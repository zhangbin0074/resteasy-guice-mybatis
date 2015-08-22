package com.yike.mybatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.yike.iwuse.dao.UserDao;
import com.yike.iwuse.dao.impl.UserDaoImpl;
import com.yike.iwuse.entity.User;

/**
 * Created by hunkier on 15/8/19.
 */
public class MyBatisTest {
    // 会话工厂
    private SqlSessionFactory sqlSessionFactory;
    private String resource = "mybatis-config.xml";

    @Before
    public void setup()throws  Exception{
        // 加载配置文件
        InputStream in = Resources.getResourceAsStream(resource);

        // 根据mybatis的配置创建SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);


    }
    @Test
    public  void testFindUserById() throws  Exception{
        // 构建dao对象
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);

        // 调用dao方法
        User user = userDao.findUserById(1);
        System.out.println(user);
        user = userDao.findUserById(2);
        System.out.println(user);
    }

    @Test
    public  void testFindUserList() throws  Exception{
        // 构建dao对象
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);

        // 调用dao方法
        List<User> list = userDao.findUserList();
        System.out.println(list);


    }

}
