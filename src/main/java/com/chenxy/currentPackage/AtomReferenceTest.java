package com.chenxy.currentPackage;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author chxy
 * @date 2019/2/15 10:14 AM
 */
public class AtomReferenceTest {


    // 可以 套任何的对象  是一种原子操作 可以用cas
    private final static AtomicReference<String> atomReference = new AtomicReference<>("abc");

    public static void main(String[] args) {


    }
}