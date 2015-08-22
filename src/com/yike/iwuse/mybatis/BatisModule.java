package com.yike.iwuse.mybatis;

import com.google.inject.name.Names;
import com.yike.iwuse.mappers.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by hunkier on 15/8/23.
 */
public class BatisModule extends  org.mybatis.guice.MyBatisModule{
    private final static String  path = "db.properties";

    @Override
    protected void initialize() {
        Properties properties = new Properties();
        try {
            properties.load(Resources.getResourceAsStream(path));
            Names.bindProperties(binder(), properties);

            bindDataSourceProviderType(PooledDataSourceProvider.class);
            bindTransactionFactoryType(JdbcTransactionFactory.class);



            // loads mappers from the package
            addMapperClasses(UserMapper.class.getPackage().getName());


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
