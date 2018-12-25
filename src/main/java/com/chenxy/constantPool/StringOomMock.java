package com.chenxy.constantPool;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chxy
 */
public class StringOomMock {

    static String  base = "string";
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i=0;i< Integer.MAX_VALUE;i++){
            String str = base + base;
            base = str;
            list.add(str.intern());
        }

        //jdk 1.6之前还有永久代的概念
    }
}
