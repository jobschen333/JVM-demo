package com.chenxy.master_worker;

/**
 * @author chxy
 * @date 2019/4/18 7:52 PM
 */
public class PlusWorker extends Worker {

    @Override
    public Object handle(Object input) {

        Integer i =(Integer)input;
        return i*i*i;
    }
}
