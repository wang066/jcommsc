package cn.jcomm.test.concurrency.a.a5;

import java.util.concurrent.*;

/**
 *CompletionService test 异步管理线程池
 */
public class CompletionServiceTest {
    public static void main(String[] args) {
//        CompletionService<String> completionService=new ExecutorCompletionService<String>(new Executor() {
//            @Override
//            public void execute(Runnable command) {
//                comm
//            }
//        });

//        ExecutorService executorService= Executors.newCachedThreadPool();
//        CompletionService<Integer> completionService=new ExecutorCompletionService<Integer>(executorService);
//        for (int i = 0; i < 10; i++) {
//            completionService.submit(new Callable<Integer>() {
//                @Override
//                public Integer call() throws Exception {
//                    int i=ThreadLocalRandom.current().nextInt(10);
//                    int j=ThreadLocalRandom.current().nextInt(10);
//                    int sum=i*j;
//                    System.out.println(sum);
//                    return sum;
//                }
//            });
//        }
//
//        int sum=0;
//        for (int i = 0; i < 10; i++) {
//            try {
//                Future<Integer> future=completionService.take();
//                sum=future.get();
//                System.out.println("-------------"+sum);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//        }
//
//        System.out.println(sum);
//        executorService.shutdown();


        ExecutorService executorService = Executors.newCachedThreadPool();
        BlockingQueue<Future<Integer>> queue = new LinkedBlockingDeque<>();
        for (int i = 0; i < 10; i++) {
            Future<Integer> submit = executorService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int i = ThreadLocalRandom.current().nextInt(10);
                    int j = ThreadLocalRandom.current().nextInt(10);
                    int sum = i * j;
                    System.out.println(sum);
                    return sum;
                }
            });
            queue.add(submit);
        }

        int sum = 0;
        int queueSize = queue.size();
        for(int i=0; i<queueSize; i++){
            try {
                sum = queue.take().get();
                System.out.println("---------"+sum);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("总数为："+sum);

    }
}
