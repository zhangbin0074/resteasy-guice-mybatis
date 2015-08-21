package com.yike.iwuse.listener;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.yike.iwuse.guice.AppModule;
import com.yike.iwuse.mybatis.UserDao;
//import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;

import javax.servlet.annotation.WebListener;

/**
 * Created by hunk on 2015/8/20.
 */
@WebListener
public class MyGuiceServletContextListener  extends GuiceServletContextListener{
    @Override
    protected Injector getInjector() {
        /*
        Injector injector = Guice.createInjector(new AppModule());
        System.out.printf(injector.getInstance(UserDao.class).toString());
        return  injector;
        */
        return Guice.createInjector(new ServletModule(){
            @Override
            protected void configureServlets() {
//                org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher
                ServletKeyBindingBuilder builder = serve("/rest/*");
                builder.with(com.yike.iwuse.resteasy.HttpServletDispatcher.class);
            }
        });
    }
}
