package com.example.springboot2.concurrency.b.b2;

import java.util.concurrent.*;

/**
 * Created by jowang on 2016/11/26 0026.
 */
public class MyAsyncTest implements Callable {
    private int num;

    public MyAsyncTest(int num) {
        this.num = num;
    }

    @Override
    public Object call() throws Exception {
        boolean result=false;
        if (num == 0) {
            result = true;
        } else if (num == 1) {
            while (true) { //infinite loop
                System.out.println("looping....");
                Thread.sleep(3000);
            }
        } else {
            throw new Exception("Callable terminated with Exception!");
        }
        if (result) {
            return "Task done.";
        } else {
            return "Task failed";
        }
    }

    public static void main(String[] args) {
        //定义几个任务
        MyAsyncTest call1 = new MyAsyncTest(0);
        MyAsyncTest call2 = new MyAsyncTest(1);
        MyAsyncTest call3 = new MyAsyncTest(2);
        //初始任务执行工具。
        ExecutorService es = Executors.newFixedThreadPool(3);
        //执行任务，任务启动时返回了一个Future对象，
        Future future1 = es.submit(call1);
        Future future2 = es.submit(call2);
        Future future3 = es.submit(call3);
//        es.invokeAny()
        try {
            //任务1正常执行完毕，future1.get()会返回线程的值
            System.out.println(future1.get());
            //任务2进行一个死循环，调用future2.cancel(true)来中止此线程。
            Thread.sleep(3000);
            System.out.println("Thread 2 terminated? :" + future2.cancel(true));
            //任务3抛出异常，调用future3.get()时会引起异常的抛出
            System.out.println(future3.get());
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
