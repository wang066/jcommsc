package cn.jcomm.test.concurrency.b.b4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 066 on 2017/6/28 0028.
 */
public class _Test5 {

    static ThreadLocal<Integer> i = new ThreadLocal<>();

    public static void main(String[] args) {
        i.set(1);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> System.out.println(i.get()));//print null
        executorService.shutdown();
    }

}
