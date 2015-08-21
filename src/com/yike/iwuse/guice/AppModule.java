/*
 * Created by IntelliJ IDEA.
 * User: hunkier
 * Date: 15/8/19
 * Time: 下午10:05
 */
package com.yike.iwuse.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.Scopes;
import com.google.inject.servlet.GuiceFilter;
import com.google.inject.servlet.ServletModule;
import com.yike.iwuse.filter.EncodingFilter;
import com.yike.iwuse.filter.LoginFilter;
import com.yike.iwuse.mybatis.UserDao;
import com.yike.iwuse.mybatis.UserDaoImpl;
import com.yike.iwuse.resteasy.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class AppModule extends ServletModule {


    @Override
    protected void configureServlets() {
        init();
    }

    protected void init() {

        // servlet
        serve("/rest/*").with(com.yike.iwuse.resteasy.HttpServletDispatcher.class);

        // filter
        filter("/*").through(EncodingFilter.class);
//        filter("/*").through(GuiceFilter.class);
        filter("/rest/*").through(LoginFilter.class);

        //


        //add configuration logic here
        final Binder binder = binder();
        System.out.println("AppModule.configure . . . . . . . .. . ");
        // binder interface
        binder.bind(UserDao.class).to(UserDaoImpl.class).in(Scopes.SINGLETON);

        binder.bind(UserService.class);

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
