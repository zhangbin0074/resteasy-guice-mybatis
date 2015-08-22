package com.yike.iwuse.mappers;

import com.yike.iwuse.entity.User;

import java.util.List;

/**
 * Created by hunkier on 15/8/23.
 */
public interface UserMapper {
    /**
     * 根据用户id查询用户信息
     * @param id
     * @return
     * @throws Exception
     */
    public User findUserById(int id) ;

    /**
     * 添加用户
     * @param user
     * @throws Exception
     */
    public void insertUser(User user) ;

    /**
     * 查询用户列表
     * @return
     * @throws Exception
     */
    public List<User> findUserList() ;
}
