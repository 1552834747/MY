package com.mybatis.mybatisdemo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface MybatisDao {

    void setlist(@Param("list") List<Map<String,String>> list);


    List<Map<String,Object>> getlist();
}
