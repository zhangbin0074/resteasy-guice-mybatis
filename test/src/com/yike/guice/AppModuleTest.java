package com.yike.guice;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.yike.iwuse.dao.UserDao;
import com.yike.iwuse.entity.User;
import com.yike.iwuse.guice.AppModule;

/**
 * Created by hunkier on 15/8/19.
 */
public class AppModuleTest {

    private Injector injector ;

    @Before
    public void setUp() throws  Exception{
       injector =  Guice.createInjector(new AppModule());
      
    }

    @Test
    public void test()throws  Exception{
        UserDao dao = injector.getInstance(UserDao.class);
        User user = dao.findUserById(1);
        System.out.println(user);
    }
}
