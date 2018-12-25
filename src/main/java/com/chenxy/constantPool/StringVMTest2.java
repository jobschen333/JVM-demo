package com.chenxy.constantPool;

/**
 * @author chxy
 * @date 2018/12/25 11:55 AM
 */
public class StringVMTest2 {

    public static void main(String[] args) {
        /**
         * 字节码为：
         *   0:   ldc     #16; //String 11   --- 从常量池加载字符串常量11
         2:   astore_1                   --- 将11的引用存到本地变量1，其实就是将s指向常量池中11的位置
         */
        String s = "11";

/**
 * 0:   new     #16; //class java/lang/String    --- 新开辟了一个地址，存储new出来的对象
 3:   dup                                      --- 将new出来的对象复制了一份到栈顶（也就是s1最终指向的是堆中的另一个存储字符串11的地址）
 4:   ldc     #18; //String 11　　　　　　　　　　
 6:   invokespecial   #20; //Method java/lang/String."<init>":(Ljava/lang/String;)V
 9:   astore_1
 */
        String s1 = new String("11");

/**
 * 0:   new     #16; //class java/lang/StringBuilder                       --- 可以看到jdk对字符串拼接做了优化，先是建了一个StringBuilder对象
 3:   dup
 4:   new     #18; //class java/lang/String                              --- 创建String对象
 7:   dup
 8:   ldc     #20; //String 1                                            --- 从常量池加载了1（此时常量池和堆中都会存字符串对象）
 10:  invokespecial   #22; //Method java/lang/String."<init>":(Ljava/lang/String;)V                    --- 初始化String("1")对象
 13:  invokestatic    #25; //Method java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
 16:  invokespecial   #29; //Method java/lang/StringBuilder."<init>":(Ljava/lang/String;)V             --- 初始化StringBuilder对象
 19:  new     #18; //class java/lang/String
 22:  dup
 23:  ldc     #20; //String 1
 25:  invokespecial   #22; //Method java/lang/String."<init>":(Ljava/lang/String;)V
 28:  invokevirtual   #30; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
 31:  invokevirtual   #34; //Method java/lang/StringBuilder.toString:()Ljava/lang/String;
 34:  astore_1                                                                                          ---从上可以看到实际上常量池目前只存了1
 36:  invokevirtual   #38; //Method java/lang/String.intern:()Ljava/lang/String;  --- 调用String.intern中，jdk1.7以后，常量池也是堆中的一部分且常量池可以存引用，这里直接存的是s2的引用
 39:  pop                                                                                                --- 这里直接返回的是栈顶的元素
 */
        String s2 = new String("1") + new String("1");
        s2.intern();

/**
 * 0:   ldc     #16; //String abc        --- 可以看到此时常量池直接存储的是:abc, 而不会a、b、c各存一份
 2:   astore_1
 */
        String s3 = "a" + "b" + "c";

/**
 0:   new     #16; //class java/lang/StringBuilder
 3:   dup
 4:   ldc     #18; //String why                --- 常量池的why
 6:   invokespecial   #20; //Method java/lang/StringBuilder."<init>":(Ljava/lang/String;)V
 9:   ldc     #23; //String true                --- 常量池的true
 11:  invokevirtual   #25; //Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
 14:  invokevirtual   #29; //Method java/lang/StringBuilder.toString:()Ljava/lang/String;
 17:  astore_1
 */
        String s17 = new StringBuilder("why").append("true").toString();
        System.out.println(s1 == s1.intern());                            // jdk1.7之前为false，之后为true
    }
}
