package com.chenxy.staticTest;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author chxy
 * @date 2019/1/9 8:55 AM
 */
public class TestInteger {

    public static void main(String[] args) {
        int a = 1;
        Integer b = 1;
        Integer c = 1;

        //确实都是从常量池里面拿数据
        System.out.println(a == b);
        //System.out.println(b == c);
        TreeMap treeMap = new TreeMap();

        String str = "aaabbbcc  c";
        try {
            StaticBean.class.newInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println(cal3(str));
    }


    private static char cal3(String str) {
        Map<Character,Integer> map = new HashMap<>();
        char[] ch = str.toCharArray();
        int max = 0 ;
        char res = ch[0] ;
        for (int i = ch.length -1 ; i >= 0;i --) {
            if(map.containsKey(ch[i])){
                map.put(ch[i],map.get(ch[i])+1);
                if(map.get(ch[i]) >= max ){
                    max = map.get(ch[i]);
                    res = ch[i] ;
                }
            }else {
                map.put(ch[i],1);
            }
        }
        return res ;
    }

}
