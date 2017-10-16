package cn.jcomm.test.concurrency.b.b1;

import java.util.concurrent.*;

/**
 * Created by 066 on 2017/3/2 0002.
 * 异步调用返回 java 代码
 */
public class FutrueTest1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        Future<?> submit = executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {

                return 1;
            }
        });

        System.out.println(submit.get().toString());

        executorService.shutdown();
    }
}
