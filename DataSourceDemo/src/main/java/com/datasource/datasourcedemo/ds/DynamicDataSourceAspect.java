package com.datasource.datasourcedemo.ds;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Order(-10)
@Component
public class DynamicDataSourceAspect {

    private static Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    @Pointcut("@annotation(targetDataSource)")
    public void pointCut(TargetDataSource targetDataSource) {}

    /*
     *
     * @Before：在方法执行之前进行执行：
     * @annotation(targetDataSource)：
     * 会拦截注解targetDataSource的方法，否则不拦截;
     */
    @Before("pointCut(targetDataSource)")
    public void doBefore(JoinPoint point, TargetDataSource targetDataSource){
        //获取当前的指定的数据源;
        DatabaseType value = targetDataSource.value();
        //如果不在会使用默认的。
        if (targetDataSource.value()==null){
            //找到的话，那么设置到动态数据源上下文中。
            DatabaseContextHolder.setDatabaseType(targetDataSource.value());
        }
    }

    /**
     * 清理
     */
    @After("pointCut(targetDataSource)")
    public void after(TargetDataSource targetDataSource){
        DatabaseContextHolder.clearDBKey();
    }
}
