package cn.jcomm.test.concurrency.b.b3;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * Created by jowang on 2017/6/27 0027.
 */
public class _Test6 {
    public static void main(String[] args) {
//        Date d=new Date();
//        d.setHours(23);
//        System.out.println(d.getTime());
//        System.out.println(System.currentTimeMillis());
        Thread.currentThread().interrupt();
//        Executor executor=new RejectableScheduledThreadPoolExecutor(10);

        ForkJoinPool forkJoinPool=new ForkJoinPool(2);
        forkJoinPool.submit(new ForkJoinTask<Object>() {
            @Override public Object getRawResult() {
                return null;
            }

            @Override protected void setRawResult(Object value) {

            }

            @Override protected boolean exec() {
                return false;
            }
        });
    }
}
