package com.datasource.datasourcedemo.service;

import com.datasource.datasourcedemo.dao.DataSourceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataSourceService {
    @Autowired
    private DataSourceDao dataSourceDao;

    public String selectById1(int i) {
        return dataSourceDao.selectById1(1);
    }
}
