/*
 * Created by IntelliJ IDEA.
 * User: hunkier
 * Date: 15/8/19
 * Time: 下午10:05
 */
package com.yike.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.Scopes;
import com.yike.mybatis.UserDao;
import com.yike.mybatis.UserDaoImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class AppModule extends AbstractModule {
    protected void configure() {
        //add configuration logic here
        final Binder binder = binder();

        // binder interface
        binder.bind(UserDao.class).to(UserDaoImpl.class).in(Scopes.SINGLETON);

        try {
            // 加载配置文件
            InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
            // 根据mybatis的配置创建SqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
            // binder instance not class
            binder.bind(SqlSessionFactory.class).toInstance(sqlSessionFactory);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
