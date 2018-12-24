package com.chenxy.demo;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * 永久代溢出
 *
 * Java HotSpot(TM) 64-Bit Server VM warning: ignoring option PermSize=8m; support was removed in 8.0
 * Java HotSpot(TM) 64-Bit Server VM warning: ignoring option MaxPermSize=8m; support was removed in 8.0
 * 可以看到jdk 1.8之后就没有永久代的概念了
 *
 * 而取而代之的
 *
 *
 * @author chxy
 */
public class PermGenOomMock {

    public static void main(String[] args) {
        URL url = null;
        List<ClassLoader> classLoaderList = new ArrayList<ClassLoader>();
        try {
            url = new File("/tmp").toURI().toURL();
            URL[] urls = {url};
            while (true){

                //为什么这个东西在永久代 不是很看懂
                ClassLoader loader = new URLClassLoader(urls);
                classLoaderList.add(loader);
                loader.loadClass("com.chenxy.demo.test");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
