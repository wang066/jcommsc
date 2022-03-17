// package com.example.springboot2.concurrency.a.a3;
//
// import org.joda.time.DateTime;
//
// import java.time.LocalDateTime;
// import java.util.concurrent.TimeUnit;
// import java.util.concurrent.atomic.AtomicInteger;
//
// /**
//  * Created by jowang on 2017/1/1 0001.
//  * todo 计数器
//  */
// public class VolatileTest {
//
//     public static class Counter {
//
//         public static int count = 0;
//
//         public static void inc() {
//
//             //这里延迟1毫秒，使得结果明显
//             try {
//                 Thread.sleep(1);
//             } catch (InterruptedException e) {
//             }
//
//             count++;
//         }
//
//         public static void main(String[] args) {
//
//             //同时启动1000个线程，去进行i++计算，看看实际结果
//
//             for (int i = 0; i < 1000; i++) {
//                 new Thread(new Runnable() {
//                     @Override
//                     public void run() {
//                         Counter.inc();
//                     }
//                 }).start();
//             }
//
//             //这里每次运行的值都有可能不同,可能为1000
//             System.out.println("运行结果:Counter.count=" + Counter.count);
//         }
//     }
//
//     public static class Counter2 {
//
//         public volatile static int count = 0;
//
//         public static void inc() {
//
//             //这里延迟1毫秒，使得结果明显
//             try {
//                 Thread.sleep(1);
//             } catch (InterruptedException e) {
//             }
//
//             count++;
//         }
//
//         public static void main(String[] args) throws InterruptedException {
//
//             //同时启动1000个线程，去进行i++计算，看看实际结果
//
//             for (int i = 0; i < 1000; i++) {
//                 new Thread(new Runnable() {
//                     @Override
//                     public void run() {
//                         Counter2.inc();
//                     }
//                 }).start();
//             }
//             TimeUnit.SECONDS.sleep(5);
//             //这里每次运行的值都有可能不同,可能为1000
//             System.out.println("运行结果:Counter.count=" + Counter2.count);
//         }
//     }
//
//
//     public static class Counter3 {
//
//         public static AtomicInteger count = new AtomicInteger();
//
//         public static void inc() {
//
//             //这里延迟1毫秒，使得结果明显
//             try {
//                 Thread.sleep(1);
//             } catch (InterruptedException e) {
//             }
//
//             count.addAndGet(1);
//         }
//
//         public static void main(String[] args) throws InterruptedException {
//
//             //同时启动1000个线程，去进行i++计算，看看实际结果
//
//             for (int i = 0; i < 100; i++) {
//                 new Thread(new Runnable() {
//                     @Override
//                     public void run() {
//                         Counter3.inc();
//                     }
//                 }).start();
//             }
//
//             TimeUnit.SECONDS.sleep(3);
//             System.out.println("运行结果:Counter.count=" + Counter3.count);
//         }
//     }
//
//     public static class Counter4 {
//
//         public static volatile int count = 0;
//
//         public static synchronized void inc() {
//
//             //这里延迟1毫秒，使得结果明显
//             try {
//                 Thread.sleep(1);
//             } catch (InterruptedException e) {
//             }
//
//             count++;
//         }
//
//         public static void main(String[] args) throws InterruptedException {
//
//             //同时启动1000个线程，去进行i++计算，看看实际结果
//
//             for (int i = 0; i < 100; i++) {
//                 new Thread(new Runnable() {
//                     @Override
//                     public void run() {
//                         Counter4.inc();
//                     }
//                 }).start();
//             }
//
//             TimeUnit.SECONDS.sleep(3);
//             System.out.println("运行结果:Counter.count=" + Counter4.count);
//         }
//     }
//
//     public static class CheckThreadState {
//         public static void main(String[] args) throws InterruptedException {
//             System.out.println(LocalDateTime.now());
//             Thread t = new Thread(new Runnable() {
//                 @Override
//                 public void run() {
//                     try {
//                         Thread.sleep(3000);
//                     } catch (InterruptedException e) {
//                         e.printStackTrace();
//                     }
//                 }
//             });
//             t.start();
//             while (! t.getState().equals(Thread.State.TERMINATED)) {
//                 Thread.sleep(10);
//             }
//
// //            while ( t.isAlive()){
// //                Thread.sleep(10);
// //            }
//             System.out.println(DateTime.now());
//         }
//     }
//
// //    static class FinalTest{
// //      static int i=100;
// //        public static void main(String[] args) {
// //            i=200;
// //        }
// //    }
//
//     static class StrictfpTest {
//         static int i = 100;
//
//         public static strictfp void main(String[] args) {
//     double d=2d-1.1d;
//             System.out.println(d);
//             System.out.println(2d-1.1d);
//             get1();
//             get2();
//         }
//
//         static strictfp void get1() {
//             System.out.println(1 / 7d);
//         }
//
//         static void get2() {
//             System.out.println(1 / 7d);
//         }
//     }
//
// //    static class StrictfpTest2 {
// //        static int i = 100;
// //
// //        public static strictfp void main(String[] args) {
// //           String s=new String()
// //        }
// //
// //        static strictfp void get1() {
// //            System.out.println(1 / 7d);
// //        }
// //
// //        static void get2() {
// //            System.out.println(1 / 7d);
// //        }
// //    }
//
//
// //    static class ReferenceTest2 {
// //        public static int i = 100;
// //
// //        public List<Integer> list;
// //
// //        public static strictfp void main(String[] args) {
// ////           String s=new String()
// //            ReferenceTest2 referenceTest2 = new ReferenceTest2();
// //            referenceTest2.get3(referenceTest2);
// //            System.out.println(referenceTest2.list);
// //        }
// //
// //        void get3(ReferenceTest2 referenceTest2) {
// //            referenceTest2.list = new ArrayList<>();
// //            list.add(1);
// //        }
// ////        static strictfp void get1(ReferenceTest2 referenceTest2) {
// //////            System.out.println(1 / 7d);
// ////            referenceTest2.i
// ////        }
// //
// //        static void get2() {
// //            System.out.println(1 / 7d);
// //        }
// //    }
//
//
//     /**
//      *
//      * @param obj
//      * @return
//      *
//      */
// //    public boolean myequals(Object obj) {
// //        return super.equals(obj);
// //        i:{
// //             int i= 00;
// //
// //        }
// //    }
// }
