package com.datasource.datasourcedemo.ds;

import org.springframework.stereotype.Component;

@Component
public class DatabaseContextHolder {
    //创建 ThreadLocal 用余存储唯一的线程变量
    private static final ThreadLocal<DatabaseType> contextHolder = new ThreadLocal<>();

    //添加
    public static void setDatabaseType(DatabaseType type) {
        contextHolder.set(type);
    }
    //获取
    public static DatabaseType getDatabaseType() {
        return contextHolder.get();
    }
    //删除
    /*
     *注意使用完成之后 需要删除线程变量
     *ThreadLocal不会自动清理
     */
    public static void clearDBKey() { contextHolder.remove(); }

}

