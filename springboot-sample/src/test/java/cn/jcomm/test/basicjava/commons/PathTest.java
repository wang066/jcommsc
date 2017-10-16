package cn.jcomm.test.basicjava.commons;

import junit.framework.TestCase;

import java.io.File;

/**
 * 路径测试
 */
public class PathTest extends TestCase {


    public void test(){
        System.out.println( new File("src/main" + File.separator + "res" + File.separator).getAbsolutePath());
    }

    public void test1(){
        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
    }

    public void test2(){
        for(int i = 0; i < 10; ++i)
            System.out.println(i);

        for(int i = 0; i < 10; i++)
            System.out.println(i);
    }
}
