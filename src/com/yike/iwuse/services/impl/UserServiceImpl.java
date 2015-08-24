package com.yike.iwuse.services.impl;

import java.util.List;

import com.google.inject.Inject;
import com.yike.iwuse.entity.User;
import com.yike.iwuse.mappers.UserMapper;
import com.yike.iwuse.services.UserService;

public class UserServiceImpl implements UserService {
	@Inject
	private UserMapper userMapper;
    /**
     * 获取指定id的用户信息
     *
     * @param id
     * @return
     */
    @Override
    public User getById(int id) throws Exception {
        return userMapper.findUserById(id);
    }

    /**
     * 获取所有用户列表
     *
     * @return
     */
    @Override
    public List<User> getAll() throws Exception {
        return userMapper.findUserList();
    }

    /**
     * 获取用户传入的信息
     *
     * @param msg
     * @return
     */
    @Override
    public String getMessage(String msg) throws Exception {
        return "[hello dear!]" + ", MSG:{" + msg +"}";
    }

    /**
     * 获取用户传入的信息
     *
     * @return
     */
    @Override
    public String test() throws Exception {
        return "sucess";
    }
}
