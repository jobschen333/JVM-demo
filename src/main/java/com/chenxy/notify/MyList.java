package com.chenxy.notify;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chxy
 * @date 2019/1/30 11:37 AM
 */
public class MyList {

    private static List<String> list = new ArrayList<String>();

    public static void add() {
        list.add("anyString");
    }

    public static int size() {
        return list.size();
    }
}
