package com.yike.iwuse.dao;

import java.util.List;

import com.google.inject.ImplementedBy;
import com.yike.iwuse.dao.impl.UserDaoImpl;
import com.yike.iwuse.entity.User;
import com.yike.iwuse.service.impl.UserServiceImpl;

/**
 * 用户管理Dao
 * Created by hunk on 2015/8/18.
 */
@ImplementedBy(UserDaoImpl.class)
public interface UserDao {
    /**
     * 根据用户id查询用户信息
     * @param id
     * @return
     * @throws Exception
     */
    public User findUserById(int id) throws  Exception;

    /**
     * 添加用户
     * @param user
     * @throws Exception
     */
    public void insertUser(User user) throws  Exception;

    /**
     * 查询用户列表
     * @return
     * @throws Exception
     */
    public List<User> findUserList() throws  Exception;
}
