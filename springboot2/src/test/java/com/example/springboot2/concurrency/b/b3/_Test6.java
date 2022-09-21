package com.example.springboot2.concurrency.b.b3;

import com.alibaba.fastjson.JSON;
import com.google.common.util.concurrent.MoreExecutors;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        ForkJoinPool forkJoinPool = new ForkJoinPool(2);
        forkJoinPool.submit(new ForkJoinTask<Object>() {
            @Override
            public Object getRawResult() {
                return null;
            }

            @Override
            protected void setRawResult(Object value) {

            }

            @Override
            protected boolean exec() {
                return false;
            }
        });
    }

    @Test
    void testk() {
      
    }

    public void test1() {
        List<Integer> collected = Stream.of(1, 2, 3).collect(Collectors.toList());

        System.out.println(JSON.toJSONString(collected));
    }

    public void test2() {
        List<String> collected = new ArrayList<>();
        for (String string : Arrays.asList("a", "b", "hello")) {
            String uppercaseString = string.toUpperCase();
            collected.add(uppercaseString);
        }
        assertEquals(Arrays.asList("A", "B", "HELLO"), collected);

        List<String> collect = Arrays.asList("a", "b", "hello").stream().map(t -> t.toUpperCase()).collect(Collectors.toList());
        JSON.toJSONString(collect);

        assertEquals(Arrays.asList("A", "B", "HELLO"), collect);


        List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
                .flatMap(numbers -> numbers.stream())
                .collect(Collectors.toList());
        assertEquals(Arrays.asList(1, 2, 3, 4), together);
    }

    @Test
    public void test3() {
        //Stream.of(1, 2,3, 4, 5).reduce((i1, i2) -> i1 + i2).;
        Integer iResult1 = Stream.of(1, 2, 3, 4, 5).reduce((i1, i2) -> i1 + i2).get();
        System.out.println(iResult1);

        System.out.println(Stream.of(1, 2, 3, 4, 5).reduce(2, (i1, i2) -> i1 + i2));
    }

    //public void  test4(){
    //    ForkJoinPool forkJoinPool=new ForkJoinPool(2);
    //    ForkJoinPool forkJoinPool1 = ForkJoinPool.commonPool();
    //    PoolUtils.
    //}

    public void test4() {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        //forkJoinPool.execute(new CustomRecursiveTask());
        //int result = customRecursiveTask.join();

        //int result = forkJoinPool.invoke(customRecursiveTask);

        //invoke all
        //forkJoinPool.invokeAll()
    }

    public void test5() throws InterruptedException, BrokenBarrierException, TimeoutException {
        ExecutorService executorService = MoreExecutors.getExitingExecutorService(new ThreadPoolExecutor(2, 2, 2, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100)));

        //for (int i = 1; i < 4; i++) {
        //    int finalI = i;
        //    executorService.execute(() -> {
        //        try {
        //            TimeUnit.SECONDS.sleep(finalI);
        //            System.out.println(finalI);
        //        } catch (InterruptedException e) {
        //            e.printStackTrace();
        //        }
        //    });
        //}
        //System.out.println(executorService.isTerminated());
        //executorService.shutdown();
        //executorService.awaitTermination(1, TimeUnit.DAYS);

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
            System.out.println("ok");
        });

        for (int i = 0; i < 2; i++) {
            int finalI = i;
            executorService.execute(() -> {
                try {
                    Thread.sleep(1000 * finalI);
                    System.out.println(finalI);
                    cyclicBarrier.await(1, TimeUnit.MINUTES);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            });
        }


        System.out.println(cyclicBarrier.getParties());


    }

    public static class CustomRecursiveAction extends RecursiveAction {

        private static final int THRESHOLD = 4;
        private static Logger logger =
                Logger.getAnonymousLogger();
        private String workload = "";

        public CustomRecursiveAction(String workload) {
            this.workload = workload;
        }

        @Override
        protected void compute() {
            if (workload.length() > THRESHOLD) {
                ForkJoinTask.invokeAll(createSubtasks());
            } else {
                processing(workload);
            }
        }

        private List<CustomRecursiveAction> createSubtasks() {
            List<CustomRecursiveAction> subtasks = new ArrayList<>();

            String partOne = workload.substring(0, workload.length() / 2);
            String partTwo = workload.substring(workload.length() / 2, workload.length());

            subtasks.add(new CustomRecursiveAction(partOne));
            subtasks.add(new CustomRecursiveAction(partTwo));

            return subtasks;
        }

        private void processing(String work) {
            String result = work.toUpperCase();
            logger.info("This result - (" + result + ") - was processed by "
                    + Thread.currentThread().getName());
        }
    }


    public static class CustomRecursiveTask extends RecursiveTask<Integer> {
        private static final int THRESHOLD = 20;
        private int[] arr;

        public CustomRecursiveTask(int[] arr) {
            this.arr = arr;
        }

        @Override
        protected Integer compute() {
            if (arr.length > THRESHOLD) {
                return ForkJoinTask.invokeAll(createSubtasks())
                        .stream()
                        .mapToInt(ForkJoinTask::join)
                        .sum();
            } else {
                return processing(arr);
            }
        }

        private Collection<CustomRecursiveTask> createSubtasks() {
            List<CustomRecursiveTask> dividedTasks = new ArrayList<>();
            dividedTasks.add(new CustomRecursiveTask(
                    Arrays.copyOfRange(arr, 0, arr.length / 2)));
            dividedTasks.add(new CustomRecursiveTask(
                    Arrays.copyOfRange(arr, arr.length / 2, arr.length)));
            return dividedTasks;
        }

        private Integer processing(int[] arr) {
            return Arrays.stream(arr)
                    .filter(a -> a > 10 && a < 27)
                    .map(a -> a * 10)
                    .sum();
        }
    }
}
