package com.chenxy.constantPool;

/**
 *
 * 测试运行时常量
 * 字符串常量池的需要1、提升效率和减少内存分配 因为百分之80的时间会在处理字符串，正因为String的不可变性，常量池很容易被管理和优化
 * 2、安全性考虑。正因为字符串的场景如此之多，所以设计成不可变的字段被有意或者无意的窜改 String是被final修饰的
 * 3、作为HashMap、HashTable等hash型数据key的必要。因为不可变的设计，jvm底层很容易在缓存String对象的时候缓存其hashcode，这样在执行效率上会大大提升。
 *
 *
 * @author chxy
 */
public class TestRuntimeConstantPool {

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = new String("def");
        String str3 = "abc";
        //单来说就是intern用来返回常量池中的某字符串，如果常量池中已经存在该字符串，则直接返回常量池中该对象的引用。否则，在常量池中加入该对象，然后 返回引用
        String str4 = str2.intern();
        String str5 = "def";
        System.out.println(str1 == str3);//true
        System.out.println(str1 == str2);
        System.out.println(str2 == str4);//false
        System.out.println(str4 == str5);//true

        // 对于什么时候会在常量池存储字符串对象，我想我们可以基本得出结论: 1. 显示调用String的intern方法的时候; 2. 直接声明字符串字面常量的时候，例如: String a = "aaa";
// 3. 字符串直接常量相加的时候，例如: String c = "aa" + "bb";  其中的aa/bb只要有任何一个不是字符串字面常量形式，都不会在常量池生成"aabb". 且此时jvm做了优化，不//   会同时生成"aa"和"bb"在字符串常量池中

    }
}
