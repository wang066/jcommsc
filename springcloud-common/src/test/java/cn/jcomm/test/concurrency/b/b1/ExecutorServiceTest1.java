package cn.jcomm.test.concurrency.b.b1;

import junit.framework.TestCase;

import java.util.concurrent.*;

/**
 * Created by 066 on 2017/3/7 0007.
 *
 * 线程编码习惯
 * 1.创建
 *
 * 2.销毁
 *
 */
public class ExecutorServiceTest1 extends TestCase {
    public static void main(String[] args) {

    }

    /**
     * 测试定时线程池
     */
    public void test_ScheduledExecutorService() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        //第5秒开始 ，每延迟一秒打印一个hello
        ScheduledFuture<?> scheduleTask = scheduler.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        }, 5, 1, TimeUnit.SECONDS);

        scheduler.shutdown();
    }

    /**
     * 单线程
     */
    public void test1(){
        ExecutorService executorService=Executors.newSingleThreadExecutor();
        executorService.shutdown();
    }

    /**
     * 固定线程池
     */
    public void test2(){
        ExecutorService executorService=Executors.newFixedThreadPool(10);
        executorService.shutdown();
    }

    /**
     * 缓冲线程池
     */
    public void test3(){
        ExecutorService executorService=Executors.newCachedThreadPool();
        executorService.shutdown();
    }

    /**
     *  创建并行线程池
     */
    public void test4(){
        ExecutorService executorService=Executors.newWorkStealingPool();
        executorService.shutdown();
    }
}
