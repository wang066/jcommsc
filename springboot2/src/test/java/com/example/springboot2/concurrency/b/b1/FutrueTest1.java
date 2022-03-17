// package com.example.springboot2.concurrency.b.b1;
//
// import java.util.ArrayList;
// import java.util.List;
// import java.util.concurrent.*;
//
// import org.apache.commons.lang.math.RandomUtils;
//
// /**
//  * Created by 066 on 2017/3/2 0002.
//  * 异步调用返回 java 代码
//  */
// public class FutrueTest1 {
//     public static void main(String[] args) throws ExecutionException, InterruptedException {
//         ExecutorService executorService= Executors.newFixedThreadPool(2);
//         List<Future> list=new ArrayList<>();
//         for (int i = 0; i < 4; i++) {
//             Future<?> submit = executorService.submit(new Callable<Object>() {
//                 @Override
//                 public Object call() throws Exception {
//                     int i = RandomUtils.nextInt(1000);
//                     TimeUnit.MILLISECONDS.sleep(RandomUtils.nextInt(1000));
//                     System.out.println(i);
//                     return 1;
//                 }
//             });
//
//             list.add(submit);
//         }
//
//         list.forEach(t-> {
//             try {
//                 System.out.println(t.get().toString());
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             } catch (ExecutionException e) {
//                 e.printStackTrace();
//             }
//         });
//
//         executorService.shutdown();
//     }
// }
