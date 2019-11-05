package com.test.testdemo.TestJava;

import org.junit.Test;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Test1 {

    @Test
    public void test0(){
        List<Long> acIds = new ArrayList<>();
        acIds.add(1L);
        acIds.add(2L);
        acIds.add(3L);
        acIds.add(4L);
        acIds.add(5L);
        Map<String,Object> data = new HashMap<>();
        List<String> names = new ArrayList<>();
        List<Integer> sums = new ArrayList<>();
        List<Long> mapIds = new ArrayList<>();
        List<Integer> mapSums = new ArrayList<>();
        List<Map<String,Object>> maps = new ArrayList<>();
        Map<String,Object> m1 = new HashMap<>();
        m1.put("accountId",1);
        m1.put("sum",1);
        Map<String,Object> m2 = new HashMap<>();
        m2.put("accountId",3);
        m2.put("sum",3);
        maps.add(m1);
        maps.add(m2);
        if (maps != null && maps.size() > 0) {
            maps.forEach(e -> {
                mapIds.add(Long.valueOf(String.valueOf(e.get("accountId"))));
                mapSums.add(Integer.valueOf(String.valueOf(e.get("sum"))));
            });
        }
        for (Long accountId : acIds) {
            names.add(accountId.toString());
            if (mapIds.contains(accountId)) {
                sums.add(mapSums.get(mapIds.indexOf(accountId)));
            }else {
                sums.add(0);
            }
        }
        data.put("names",names);
        data.put("sums",sums);
        System.out.println(data);
    }

    @Test
    public void test1(){
       String audio_path = "https://images.yxtribe.com/156966360714596d75.mp3";
        String fileName = audio_path.substring(audio_path.lastIndexOf("/") + 1).split("\\.")[0]+".wav";		//文件名
        String url = audio_path.substring(0, audio_path.lastIndexOf("/") + 1);	//url
        System.out.println(fileName);
        System.out.println(url);
    }

    @Test
    public void test2(){
        Date date = new Date(1571998892202L);
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println(format.format(date));
    }

    @Test
    public void test3(){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE , -3);
        Date time = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println(format.format(time));
    }

    enum tem{
        A("111","222"),
        B("333","444")
        ;

        String s;
        String s1;

        tem(String s, String s1) {
            this.s = s;
            this.s1 = s1;
        }

        public String getS() {
            return s;
        }

        public String getS1() {
            return s1;
        }
    }

    @Test
    public void test4(){
        System.out.println(tem.A.getS());
        System.out.println(tem.A.getS1());
        System.out.println(tem.B.getS());
        System.out.println(tem.B.getS1());
    }

}
