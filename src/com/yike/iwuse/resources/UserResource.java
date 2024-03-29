package com.yike.iwuse.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.google.inject.ImplementedBy;
import com.yike.iwuse.resources.impl.UserResourceImpl;
@ImplementedBy(UserResourceImpl.class)
@Path("user")
public interface UserResource {
	
	 /**
     * 获取指定id的用户信息
     * @param id
     * @return
     */
    @GET
    @Path("/user/{id}")
    @Produces("application/json")
    public Response getById(@PathParam("id")int id)throws Exception;
    
    /**
     * 获取所有用户列表
     * @return
     */
    @GET
    @Path("/users")
    @Produces("application/json")
    public Response getAll()throws  Exception;
    
    /**
     * 获取用户传入的信息
     * @param msg
     * @return
     */
    @GET
    @Path("/trans/{msg}")
    public Response getMessage(@PathParam("msg")String msg) throws Exception;

     /**
     * 获取用户传入的信息
     * @return
     */
    @GET
    @Path("/*")
    public Response test() throws Exception;



}
