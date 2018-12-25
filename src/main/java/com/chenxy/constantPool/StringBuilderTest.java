package com.chenxy.constantPool;

/**
 * @author chxy
 * @date 2018/12/25 12:00 PM
 */
public class StringBuilderTest {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String a = "1";
        for (int i=0; i<10000; i++) {
            // 性能差距如此之大 原因是因为一开始的时候 每次都要new StringBuilder
            a += "1";
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

        StringBuilder b = new StringBuilder("1");
        for (int i=0; i<10000; i++) {
            // test
            StringBuilder c = new StringBuilder("1");
            b.append(c);
        }
        long time3 = System.currentTimeMillis();

        System.out.println(time3 - endTime);


    }
}
