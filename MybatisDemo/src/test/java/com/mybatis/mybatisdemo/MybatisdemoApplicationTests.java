package com.mybatis.mybatisdemo;

import com.mybatis.mybatisdemo.dao.MybatisDao;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@MapperScan("com.mybatis.mybatisdemo.dao")
class MybatisdemoApplicationTests {

    @Autowired
    MybatisDao mybatisDao;

    @Test
    void contextLoads() {
    }



    @Test
    void test0(){
        List<Map<String,String>> list = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        map.put("id","1");
        map.put("value","1");
        list.add(map);
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("id","2");
        map2.put("value","2");
        list.add(map2);
        mybatisDao.setlist(list);
    }

    @Test
    void test1(){
        List<Map<String,Object>> map = mybatisDao.getlist();
        System.out.println(map);
    }

}
