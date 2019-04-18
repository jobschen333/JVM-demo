package com.chenxy.constantPool;

import java.util.UUID;

/**
 *
 *
 * @author chxy
 * @date 2018/12/25 3:26 PM
 */
public class StringInternTest {

    public static void main(String[] args) throws Exception {
        for (int i=0; i<Integer.MAX_VALUE; i++){
            UUID.randomUUID().toString().intern();
            if (i>=100000 && i%100000==0){
                System.out.println("i="+i);
            }
        }
    }

    //PrintStringTableStatistics 会在结束进程的时候输出

    //-XX:StringTableSize=5000000
    /**
     * StringTable 是一个HashTable
     * //如果更少的hash碰撞就能够更快的遍历
     * 这个能够在-XX:StringTableSize=5000000 超过一定量的时候减少hash碰撞。  但是一开始呢？不是越小越好？
     */

}
