package com.example.springboot2.designpattern.observer._Observer;

import java.util.HashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jowang on 2017/2/7 0007.
 */
public class Main {
    public static void main(String[] args) {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());

        set.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(ObservableSet<Integer> s, Integer e) throws ExecutionException, InterruptedException {
                System.out.println(e);
                if (e == 23) {
//                    ExecutorService executorService = Executors.newSingleThreadExecutor();
//                    Object o = executorService.submit(new FutureTask((Callable<Integer>) () -> {
//                        s.removeObserver(this);
//                        return 1;
//                    })).get();
//                    System.out.println(o);
//                    executorService.shutdown();
                    if (e == 23) {
                        ExecutorService executor =
                                Executors.newSingleThreadExecutor();
                        final SetObserver<Integer> observer = this;
                        try {
                            executor.submit(new Runnable() {
                                public void run() {
                                    s.removeObserver(observer);
                                }
                            }).get();
                        } catch (Exception ex) {
                            System.out.println(ex);
                            throw new AssertionError(ex.getCause());
//                        } catch (Exception ex) {
//                            throw new AssertionError(ex.getCause());
                        } finally {
                            executor.shutdown();
                        }
                    }
                }
            }
        });

        for (int i = 0; i < 100; i++) {
            set.add(i);
        }
    }
}
