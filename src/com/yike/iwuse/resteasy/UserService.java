package com.yike.iwuse.resteasy;



import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.yike.iwuse.guice.AppModule;
import com.yike.iwuse.mybatis.User;
import com.yike.iwuse.mybatis.UserDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hunk on 2015/8/19.
 */
 @Path("/user")
public class UserService {
    /**
     * 初始化数据
     */
    private static Map<Integer,Object> map = new HashMap<Integer, Object>();


    private Injector injector = Guice.createInjector(new AppModule());


    private UserDao userDao = this.injector.getInstance(UserDao.class);
//    private Injector injector ;
//    private UserDao userDao ;
//
//    @Inject
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }
//
//     @Inject
//    public void setInjector(Injector injector) {
//        this.injector = injector;
//    }

    /**
     * 获取指定id的用户信息
     * @param id
     * @return
     */
    @GET
    @Path("/user/{id}")
    @Produces("application/json")
    public User getById(@PathParam("id")int id)throws Exception{
//        userDao = injector.getInstance(UserDao.class);
        return userDao.findUserByid(id);
    }

    /**
     * 获取所有用户列表
     * @return
     */
    @GET
    @Path("/users")
    @Produces("application/json")
    public List<User> getAll()throws  Exception{
//        userDao = injector.getInstance(UserDao.class);
        return  userDao.findUserList();
    }

    /**
     * 获取用户传入的信息
     * @param msg
     * @return
     */
    @GET
    @Path("/trans/{msg}")
    public String getMessage(@PathParam("msg")String msg){
        return "[hello dear!]" + ", MSG:{" + msg +"}";
    }
}
