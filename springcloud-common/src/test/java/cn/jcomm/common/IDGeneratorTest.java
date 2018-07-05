package cn.jcomm.common;

import junit.framework.TestCase;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author: jowang
 * @date: 2018-06-30 10:22
 * @description:
 */
public class IDGeneratorTest extends TestCase {

    public  void test(){
        ExecutorService executorService=new ThreadPoolExecutor(2,2,1, TimeUnit.DAYS,new ArrayBlockingQueue<Runnable>(1000));

        Set<Long> longs1=new HashSet<>();
        Set<Long> longs2=new HashSet<>();

        executorService.submit(new Runnable() {
            @Override public void run() {
                IDGenerator idWorker = new IDGenerator(0, 0);
                IntStream.rangeClosed(1,1000).forEach(
                        index -> {
                            long id = idWorker.nextId();
                            longs1.add(id);
                            System.out.println(id);
                        }
                );
            }
        });

        executorService.submit(new Runnable() {
            @Override public void run() {
                IDGenerator idWorker2 = new IDGenerator(1, 0);
                IntStream.rangeClosed(1,1000).forEach(
                        index -> {
                            long id = idWorker2.nextId();
                            longs2.add(id);
                            System.out.println(id);
                        }
                );
            }
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(longs1.size()+"---"+longs2.size());
        System.out.println(CollectionUtils.containsAny(longs1, longs2));

        executorService.shutdown();
    }

}