/*
 * Created by IntelliJ IDEA.
 * User: hunkier
 * Date: 15/8/19
 * Time: 下午10:05
 */
package com.yike.iwuse.guice;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import com.yike.iwuse.mybatis.BatisModule;
import org.apache.ibatis.io.ResolverUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.yike.iwuse.mybatis.MybatisModule;

public class AppModule implements Module {
	
	private static final Logger log = LoggerFactory.getLogger(AppModule.class);

    @Override
    public void configure(Binder binder) {
    	binder.install(new MybatisModule());
//    	binder.install(new BatisModule());

    	
		// register dao components
		for (final Class daoClass : getClasses("com.yike.iwuse.dao")) {
			if (daoClass.isInterface()) {
				log.debug("****  - - - - Registering dao component {}",daoClass);
				bindClass(binder, daoClass);
			}
		}
		
		// register resources components
		for (final Class daoClass : getClasses("com.yike.iwuse.resources")) {
			if (daoClass.isInterface()) {
				log.debug("----  - - - - Registering resources component {}",daoClass);
				bindClass(binder, daoClass);
			}
		}
		
//		init(binder);
       
    }

	private void bindClasses(Binder binder,String packageName){
		Set<Class<? extends Class>> classes = getClasses(packageName);
		for (Class clazz : classes) {
			if (clazz.getPackage().getName().equals(packageName) ){
				log.debug("Registering packageName component {}",clazz);
				bindClass(binder,clazz);
			}else{
				// 子包中的类不注册
			}
		}
	}


	/**
	 * 注册类
	 * @param binder
	 * @param classToBind
	 */
	private void bindClass(final Binder binder, final Class classToBind) {

		// don't bind anonymous classes
		if (classToBind.isAnonymousClass()) return;

		// don't bind annotations
		if (classToBind.isAnnotation()) return;

		binder.bind(classToBind);

	}

	/**
	 * 获取包名下所有的类
	 * @param packageName
	 * @return
	 */
	private Set<Class<? extends Class>> getClasses(String packageName) {
		return new ResolverUtil<Class>()
				.find(new ResolverUtil.IsA(Object.class), packageName)
				.getClasses();

	}
}
