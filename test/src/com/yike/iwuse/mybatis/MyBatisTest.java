package com.yike.iwuse.mybatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.yike.iwuse.entity.User;
import com.yike.iwuse.mappers.UserMapper;

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
    	// 构建mpper对象
    	UserMapper userMapper = sqlSessionFactory.openSession().getMapper(UserMapper.class);
       

        // 调用mapper方法
        User user = userMapper.findUserById(1);
        System.out.println(user);
        user = userMapper.findUserById(2);
        System.out.println(user);
    }

    @Test
    public  void testFindUserList() throws  Exception{
        // 构建mpper对象
        UserMapper userMapper = sqlSessionFactory.openSession().getMapper(UserMapper.class);
        

        // 调用mppper方法
        List<User> list = userMapper.findUserList();
        System.out.println(list);


    }

}
