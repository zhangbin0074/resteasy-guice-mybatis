package com.yike.iwuse.mybatis;

import org.mybatis.guice.XMLMyBatisModule;

import java.util.Properties;

/**
 * Created by hunkier on 15/8/21.
 */
public class MybatisModule extends XMLMyBatisModule{
    @Override
    protected void initialize() {

        setClassPathResource("mybatis-config.xml");
        setEnvironmentId("development");

    }

    
}
