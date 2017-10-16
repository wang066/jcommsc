package cn.jcomm.test.concurrency.a.a5;

import org.joda.time.DateTime;

/**
 * Created by 066 on 2017/2/17 0017.
 * 执行结果是什么
 * 因为覆盖
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("ok");
            }
        }) {
            @Override
            public void run() {
                System.out.println("ok2");
            }
        }.start();

        DateTime.now();


        Integer i =null;
        System.out.println(Integer.getInteger("",0));


    }
}
