package com.datasource.datasourcedemo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DataSourceDao {
    @Select("select name form user where id = #{i}")
    String selectById1(int i);
}
