package com.yike.iwuse.resources.impl;

import java.util.List;

import com.google.inject.Inject;
import com.yike.iwuse.entity.User;
import com.yike.iwuse.resources.UserResource;
import com.yike.iwuse.services.UserService;

public class UserResourceImpl implements UserResource {
	@Inject 
	private UserService userService;
    /**
     * 获取指定id的用户信息
     *
     * @param id
     * @return
     */
    @Override
    public User getById(int id) throws Exception {
    	return userService.getById(id);
    }

    /**
     * 获取所有用户列表
     *
     * @return
     */
    @Override
    public List<User> getAll() throws Exception {
    	return userService.getAll();
    }

    /**
     * 获取用户传入的信息
     *
     * @param msg
     * @return
     */
    @Override
    public String getMessage(String msg) throws Exception {
        return userService.getMessage(msg);
    }

    /**
     * 获取用户传入的信息
     *
     * @return
     */
    @Override
    public String test() throws Exception {
        return userService.test();
    }
}
