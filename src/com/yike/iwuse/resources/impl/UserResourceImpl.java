package com.yike.iwuse.resources.impl;

import com.google.inject.Inject;
import com.yike.iwuse.dao.UserDao;
import com.yike.iwuse.entity.User;
import com.yike.iwuse.resources.UserResource;

import java.util.List;

public class UserResourceImpl implements UserResource {
	@Inject
	private UserDao userDao;
    /**
     * 获取指定id的用户信息
     *
     * @param id
     * @return
     */
    @Override
    public User getById(int id) throws Exception {
        return userDao.findUserById(id);
    }

    /**
     * 获取所有用户列表
     *
     * @return
     */
    @Override
    public List<User> getAll() throws Exception {
        return userDao.findUserList();
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
