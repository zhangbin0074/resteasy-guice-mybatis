/*
 * Created by IntelliJ IDEA.
 * User: hunkier
 * Date: 15/8/19
 * Time: 下午10:05
 */
package com.yike.iwuse.guice;

import java.util.Set;

import org.apache.ibatis.io.ResolverUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.yike.iwuse.mybatis.BatisModule;
import com.yike.iwuse.resources.UserResource;
import com.yike.iwuse.services.UserService;

public class AppModule implements Module {
	
	private static final Logger log = LoggerFactory.getLogger(AppModule.class);

    @Override
    public void configure(Binder binder) {
    	binder.install(new BatisModule());

    	
		// 注册services到Guice
    	bindClassesInPackage(binder, UserService.class.getPackage());
    	// 注册resources到Guice
    	bindClassesInPackage(binder, UserResource.class.getPackage());

       
    }

    /**
     * 注册包(packages)下所有的类到Guice
     * @param binder
     * @param packages
     */
	private void bindClassesInPackage(Binder binder,Package packages){
		String packageName = packages.getName();
		Set<Class<? extends Class>> classes = getClasses(packageName);
		for (Class clazz : classes) {
			if (clazz.getPackage().getName().equals(packageName) ){// 包名相同才注册
				log.debug("Registering packageName component {}",clazz);
				bindClass(binder,clazz);
			}else{
				// 子包中的类不注册
			}
		}
	}


	/**
	 * 注册类到Guice
	 * @param binder
	 * @param classToBind
	 */
	private void bindClass(final Binder binder, final Class classToBind) {

		// don't bind anonymous classes  匿名内部类
		if (classToBind.isAnonymousClass()) return;

		// don't bind annotations 注解定义类
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
