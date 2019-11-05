package com.datasource.datasourcedemo.ds;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
@MapperScan("com.datasource.datasourcedemo.controller")//包名
@EnableTransactionManagement
public class DataSourceConfig {


    private static Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    @Autowired
    private Environment env;

    /**
     *  构造多数据源连接池
     */
    @Bean
    @Primary
    public DynamicDataSource dynamicDataSource() throws SQLException {

        Map<Object,Object> druidDataSourceMap = new ConcurrentHashMap<>();
        DruidDataSource dataSource1 = new DruidDataSource();
        dataSource1.setUrl("jdbc:mysql:///test1");
        dataSource1.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource1.setUsername("root");
        dataSource1.setPassword("root");

        DruidDataSource dataSource2 = new DruidDataSource();
        dataSource2.setUrl("jdbc:mysql:///test2");
        dataSource2.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource2.setUsername("root");
        dataSource2.setPassword("root");

        //key 值对应enum里的名称
        druidDataSourceMap.put(DatabaseType.mysql1,dataSource1);
        druidDataSourceMap.put(DatabaseType.mysql2,dataSource2);

        DynamicDataSource dataSource = new DynamicDataSource();
        // 该方法是AbstractRoutingDataSource的方法
        dataSource.setTargetDataSources(druidDataSourceMap);

        // 默认使用的datasource
        dataSource.setDefaultTargetDataSource(dataSource1);
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DynamicDataSource dynamicDataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dynamicDataSource);
        sessionFactoryBean.setTypeAliasesPackage(env.getProperty("mybatis.type-aliases-package"));
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapper-locations")));
        return sessionFactoryBean.getObject();
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }

}

