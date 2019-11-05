package com.datasource.datasourcedemo.controller;

import com.datasource.datasourcedemo.service.DataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataSourceController {

    @Autowired
    private DataSourceService dataSourceService;

    @GetMapping("test1")
    public String test1(){
        return dataSourceService.selectById1(1);
    }

}
