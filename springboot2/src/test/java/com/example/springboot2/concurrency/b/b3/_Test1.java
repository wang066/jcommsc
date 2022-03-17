package com.example.springboot2.concurrency.b.b3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by jowang on 2017/6/7 0007.
 */
public class _Test1 {
    public static void main(String[] args) {
//        List<Integer> list= Arrays.asList(1);
        List<Integer> list = new ArrayList<>();
        list.add(1);

        for (Integer ints : list) {
            list.remove(0);
            System.out.println(ints);
        }
    }

    private abstract class BackgroudTask<V> implements Runnable, Future<V> {
        private final FutureTask<V> computation = null;

        protected abstract V compute() throws Exception;

        protected void onCompletion(V result, Throwable throwable, boolean cancelled) {
        }

        protected void onProgress(int current, int max) {
        }

        private class Computation extends FutureTask<V> {
            public Computation() {
                super(new Callable<V>() {
                    @Override
                    public V call() throws Exception {
                        return BackgroudTask.this.compute();
                    }
                });
            }

            protected final void done() {

            }
        }

        private class Computation2 extends Computation {
            protected final void done2() {
                done();
            }
        }
    }


    protected final void done() {
        System.out.println("1");
    }


    public volatile int i;

    public void testA() throws Exception {

    }

    public void testB() throws Exception {

    }
}
