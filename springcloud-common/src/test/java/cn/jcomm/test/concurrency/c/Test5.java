package cn.jcomm.test.concurrency.c;

import junit.framework.TestCase;

/**
 * @author: jowang
 * @date: 2018-09-18 9:43
 * @description:
 */
public class Test5 extends TestCase {
    // public void test() {
    //     System.out.println(null!=1);
    // }

    public interface lamtest {
        void a();

        void b();
    }

    public void test1() {
        // lamtest lam = () -> {
        //     System.out.println(1);
        // };
    }
}
