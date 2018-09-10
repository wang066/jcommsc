package cn.jcomm.test.concurrency.b.b4;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

import junit.framework.TestCase;

/**
 * Created by 066 on 2017/6/28 0028.
 */
public class _Test6 extends TestCase {

    static ThreadLocal<Integer> i = new ThreadLocal<>();

    /**
     * test oom int[] 数组是存放在heap里
     *
     * @param args
     */
    public static void main(String[] args) {
        //heap
//        List<int[]> list = new ArrayList<>();
//        while (true) {
//            int[] ints = new int[1000];
//            list.add(ints);
//        }
        System.out.println(0x7fffffff);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(1233123123 >>> 16);


    }

    public static void a() throws RException {
        throw new RuntimeException("fadsfa");
    }

    public void test1() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("3", "33");
        map.put("1", "11");
        map.put("2", "22");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("排序之前:" + entry.getKey() + " 值" + entry.getValue());

        }
        System.out.println("======================================================");
        SortedMap<String, String> sort = new TreeMap<String, String>(map);
        Set<Map.Entry<String, String>> entry1 = sort.entrySet();
        Iterator<Map.Entry<String, String>> it = entry1.iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("排序之后:" + entry.getKey() + " 值" + entry.getValue());
        }


    }

    public void test2() {
        ThreadLocal<Integer> t = new ThreadLocal<>();
//        while (true) {
//            t.set(1);
//        }
        t.remove();
        WeakReference<Integer> w = new WeakReference<Integer>(1);
        w.clear();
    }

    public void test3() {
        System.out.println(0.3d == 0.1 * 3);
        toString();
    }

    public void test4() {
        System.out.println("1".equalsIgnoreCase("1"));
    }

    /**
     * 错误例子
     *
     * @throws InterruptedException
     */
    public void test5() throws InterruptedException {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Thread t1 = new Thread(new Runnable() {
            @Override public void run() {
                lock1.lock();
                try {
                    Thread.sleep(100);
                    System.out.println("t1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock2.lock();
                lock1.unlock();
                lock2.unlock();
            }
        });


        Thread t2 = new Thread(() -> {
            lock2.lock();
            System.out.println("t2");
            lock1.lock();

            lock1.unlock();
            lock2.unlock();
        });

        t1.start();
        t2.start();

        LockSupport.unpark(t2);
        LockSupport.park(t1);


        t1.join();
        t2.join();
    }

    public void test6() {
        try {
            a();
        } catch (Exception e) {
            if (e instanceof RException) {
                System.out.println("ok");
            }
            e.printStackTrace();
        }
    }

    public static class RException extends RuntimeException {

    }

    public void test7(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
    }
}
