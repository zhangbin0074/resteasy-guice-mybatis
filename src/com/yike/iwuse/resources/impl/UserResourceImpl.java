package com.yike.iwuse.resources.impl;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

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
    public Response getById(int id) throws Exception {
    	User user = userService.getById(id);
    	return Response.status(Status.OK).entity(user).build();
    }

    /**
     * 获取所有用户列表
     *
     * @return
     */
    @Override
    public Response getAll() throws Exception {
    	List<User> users = userService.getAll();
    	return Response.status(Status.OK).entity(users).build();
    }

    /**
     * 获取用户传入的信息
     *
     * @param msg
     * @return
     */
    @Override
    public Response getMessage(String msg) throws Exception {
    	String msgResult = userService.getMessage(msg);
    	return Response.status(Status.OK).entity(msgResult).build();
    }

    /**
     * 获取用户传入的信息
     *
     * @return
     */
    @Override
    public Response test() throws Exception {
    	String msgResult = userService.test();
    	return Response.status(Status.OK).entity(msgResult).build();
    }
}
