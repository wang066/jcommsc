package com.example.springboot_common.threadpool;

import com.google.common.collect.Maps;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolMonitor {
    public static Map<String, ExecutorWrapper> executorServiceMap = new HashMap<>();


    public void putExecutor(String name) {
        ExecutorService executor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return null;
            }
        }, new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

            }
        });
    }

    private void putExecutor(String name, ExecutorService executorService) {
        executorServiceMap.put(name, ExecutorWrapper.of(executorService));
    }

    public static class ExecutorWrapper {
        private String name;
        public ExecutorService executorService;

        private Map<String, AtomicInteger> counter = Maps.newConcurrentMap();

        public ExecutorWrapper(ExecutorService executorService) {
            this.executorService = executorService;
        }

        public static ExecutorWrapper of() {
            ExecutorWrapper wrapper = new ExecutorWrapper(null);

            wrapper.executorService = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1), new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    return new Thread("name");
                }
            }, (r, executor) -> {
                wrapper.counter.get("1").incrementAndGet();
            });

            return wrapper;
        }

        public static ExecutorWrapper of(ExecutorService executorService) {
            return new ExecutorWrapper(executorService);
        }


        public void execute(Runnable runnable) {
            executorService.execute(RunnableWrapper.of(runnable));
        }
    }

    public static class RunnableWrapper implements Runnable {
        private Runnable runnable;

        private LocalDateTime startTime;
        private LocalDateTime endTime;

        public RunnableWrapper(Runnable runnable) {
            this.runnable = runnable;
        }

        public static RunnableWrapper of(Runnable runnable) {
            return new RunnableWrapper(runnable);
        }


        @Override
        public void run() {
            startTime = LocalDateTime.now();
            runnable.run();
            endTime = LocalDateTime.now();
        }
    }

}
