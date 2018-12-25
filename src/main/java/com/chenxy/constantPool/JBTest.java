package com.chenxy.constantPool;

/**
 * 基本类型测试
 * @author chxy
 * @date 2018/12/25 2:38 PM
 */
public class JBTest {

    //Byte,Short,Integer,Long,Character,Boolean；
    //这5种包装类默认创建了数值[-128，127]的相应类型的缓存数据，但是超出此范围仍然会去创建新的对象。

    public static void main(String[] args) {
        Integer i1 = 40;
        Integer i2 = 40;
        System.out.println( i1 == i2);

        Integer i3 = 400;
        Integer i4 = 400;
        System.out.println(i3 == i4);

        Double double1=1.2;
        Double double2=1.2;
        //这种就没有实现常量池技术
        System.out.println(double1==double2);//输出false

    }
}
