// package cn.jcomm.test.concurrency.a.a3;
//
//
// import java.util.concurrent.*;
//
// /**
//  *
//  */
// public class LockTest1 {
//     public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
// //        Lock lock = new ReentrantLock();
// //        lock.lock();
// //        try {
// //            // update object state
// //        }
// //        finally {
// ////            lock.unlock();
// //        }
//         ExecutorService executorService = Executors.newSingleThreadExecutor();
//         Future<?> submit = executorService.submit(
// //                new Task<Integer>() {
// //                    @Override
// //                    protected Integer call() throws Exception {
// //                        return 0;
// //                    }
// //                }
// //                () -> 0
// //                new Callable<Integer>() {
// //                    @Override
// //                    public Integer call() throws Exception {
// //                        return null;
// //                    }
// //                }
//                 new Task<Integer>() {
//                     @Override
//                     public Integer call() throws Exception {
//                         return 123;
//                     }
//                 }
//         );
//         Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//             @Override
//             public void uncaughtException(Thread t, Throwable e) {
//
//             }
//         });
// //        Integer o = (Integer) submit.get(1, TimeUnit.SECONDS);
//         System.out.println();
//
//
//     }
// }
