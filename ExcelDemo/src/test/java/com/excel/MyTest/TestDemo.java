package com.excel.MyTest;

import com.excel.entity.TestEntity;
import com.excel.airExcel.AirExcelUtil;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;

public class TestDemo {

    private InputStream userXls;
    private InputStream userXlsx;
    private InputStream test;
    private String userXlsName = "UserXls.xls";
    private String userXlsxName = "UserXlsx.xlsx";
    private String testName = "test.xlsx";

    {
        try {
            userXls = new FileInputStream("F:\\MY\\ExcelDemo\\src\\main\\resources\\static\\UserXls.xls");
            userXlsx = new FileInputStream("F:\\MY\\ExcelDemo\\src\\main\\resources\\static\\UserXlsx.xlsx");
            test = new FileInputStream("F:\\MY\\ExcelDemo\\src\\main\\resources\\static\\test.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test0() throws IOException, InstantiationException, IllegalAccessException {
        AirExcelUtil<TestEntity> excelUtil = new AirExcelUtil<TestEntity>(TestEntity.class);
        List<TestEntity> list = excelUtil.importExcel( "test", "text.xlsx", test);
        System.out.println(list);
    }



    @Test
    public void test2() {

        String col = "A";
        col = col.toUpperCase();
        System.out.println(col);
        // 从-1开始计算,字母重1开始运算。这种总数下来算数正好相同。
        int count = -1;
        char[] cs = col.toCharArray();
        System.out.println(cs);
        for (int i = 0; i < cs.length; i++) {
            count += (cs[i] - 64) * Math.pow(26, cs.length - 1 - i);
        }
        System.out.println(count);
    }

    @Test
    public void test8() throws Exception {
        FileOutputStream output = new FileOutputStream("F:\\MY\\ExcelDemo\\src\\main\\resources\\static\\test.xlsx");
        AirExcelUtil<TestEntity> excelUtil = new AirExcelUtil<TestEntity>(TestEntity.class);
        ArrayList<TestEntity> users = getUser(3, 5);
        boolean test = excelUtil.exportExcel(users,"test","text.xlsx", output);
        System.out.println(test);
    }

    public ArrayList<TestEntity> getUser(int i,int j){
        ArrayList<TestEntity> users = new ArrayList<>();
        for (int i1 = 0; i1 < i; i1++) {
            TestEntity user = new TestEntity();
            user.setId(i1);
            user.setName("na=================================me"+i1);
            user.setTime(new Date());
            user.setMaps(getMap(j--));
            users.add(user);
        }
        return users;
    }

    public List<Map<String,Object>> getMap(int i){
        ArrayList<Map<String, Object>> maps = new ArrayList<>();
        for (int i1 = 0; i1 < i; i1++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("age",i1);
            map.put("content",new Date());
            maps.add(map);
        }
        return maps;
    }

    @Test
    public void test10() throws NoSuchFieldException {
        Map<String,Object> map = new HashMap<>();
        map.put("id","1");
        map.put("time",new Date());
        Object o = map.get("id");
        System.out.println(o instanceof String);
        System.out.println(o.getClass().getTypeName());
        Object o1 = map.get("time");
        System.out.println(o1 instanceof Date);
        System.out.println(o1.getClass().getTypeName());
    }



}
