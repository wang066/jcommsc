package cn.jcomm.test.concurrency.c;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson.JSON;
import junit.framework.TestCase;

/**
 * @author: jowang
 * @date: 2018-11-21 11:17
 * @description:
 */
public class Test3 extends TestCase {

    public void test1() {
        //var consumer=()->{};
        //final
        //var example=new ArrayList<>();
        //lombok.val i=0;
        //i++;

        lombok.var i = 0;
        i++;
        System.out.println(i);

        //var
    }

    public void test2() {
        //System.out.println(Ints.stringConverter().convert("1"));
        ;
        System.out.println(JSON.toJSONString(ThreadLocalRandom.current().ints().limit(10).toArray()));
    }

    public void test4() {
        //System.out.println(Ints.stringConverter().convert("1"));
        ;
        System.out.println(JSON.toJSONString(ThreadLocalRandom.current().ints().limit(10).toArray()));
    }

    public void test5() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            executorService.submit(() -> {
                try {
                    TimeUnit.SECONDS.sleep(finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(finalI);
            });
        }

        //System.out.println(executorService.);
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(executorService.isTerminated());
        }
        //executorService.awaitTermination(1,TimeUnit.HOURS);

        //System.out.println("all finsh");
    }


    public void test3() throws Exception {
        BlockingQueue queue = new ArrayBlockingQueue(10);
        //BlockingQueue queue1=new RedissonBlockingDeque()
        ExecutorService pushTheads = Executors.newFixedThreadPool(5);
        ExecutorService popTheads = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 100; i++) {
            int finalI = i;
            pushTheads.submit(() -> {
                try {
                    queue.put(finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        for (int i = 0; i < 100; i++) {
            int finalI = i;
            popTheads.submit(() -> {
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        TimeUnit.SECONDS.sleep(5);
    }
}
