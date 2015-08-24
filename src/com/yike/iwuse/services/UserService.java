package com.yike.iwuse.services;

import java.util.List;

import com.google.inject.ImplementedBy;
import com.yike.iwuse.entity.User;
import com.yike.iwuse.services.impl.UserServiceImpl;

@ImplementedBy(UserServiceImpl.class)
public interface UserService {
	
	 /**
     * 获取指定id的用户信息
     * @param id
     * @return
     */
    public User getById( int id)throws Exception;
    
    /**
     * 获取所有用户列表
     * @return
     */
    public List<User> getAll()throws  Exception;
    
    /**
     * 获取用户传入的信息
     * @param msg
     * @return
     */
    public String getMessage(String msg) throws Exception;

     /**
     * 获取用户传入的信息
     * @return
     */
    public String test() throws Exception;



}
