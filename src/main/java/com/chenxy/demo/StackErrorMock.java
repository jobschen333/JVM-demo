package com.chenxy.demo;

/**
 * 栈溢出测试
 * 若Java虚拟机栈的内存大小不允许动态扩展，那么当线程请求栈的深度超过当前Java虚拟机栈的最大深度的时候，就抛出StackOverFlowError异常。
 * @author chxy
 */
public class StackErrorMock {

    private static int index = 1;

    /**
     * 每一次call都会申请一个栈
     */
    private void call(){
        index++;
        call();
    }

    public static void main(String[] args) {
        StackErrorMock mock = new StackErrorMock();
        try {
            mock.call();

            //这里用Throwable 是因为 StackOverflowError 和 OutOfMemoryError 都不属于 Exception 的子类
        }catch (Throwable e){
            System.out.println("Stack deep : "+index);
            e.printStackTrace();
        }
    }

}
