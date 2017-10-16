//package cn.jcomm.test.thridpack.genid;
//
//import junit.framework.TestCase;
//import org.joda.time.DateTime;
//
//import java.util.HashSet;
//import java.util.Set;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.TimeUnit;
//
///**
// * Created by jowang on 2017/4/19 0019.
// */
//public class IDUtilsTest extends TestCase {
//
//    public void testSet() {
//        Set<Long> set = new HashSet();
//        set.add(1L);
//        set.add(1L);
//    }
//
//    public void testGenBySnowFlake() throws Exception {
//////        Set<Long> set = new HashSet();
//////        set = Collections.synchronizedSet(set);
////        CopyOnWriteArraySet set = new CopyOnWriteArraySet();
////
////        ExecutorService executorService = Executors.newFixedThreadPool(5);
////        for (int i = 0; i < 100000; i++) {
//////            Set<Long> finalSet = set;
////            executorService.execute(new Runnable() {
////                @Override
////                public void run() {
////                    set.add(IDUtils.genBySnowFlake());
////                }
////            });
////        }
////        System.out.println(set.size());
////
////        assertTrue(set.size() == 100000);
//    }
//
//    public void testGenBySnowFlakeSingleThread() throws Exception {
//        Set<Long> set = new HashSet();
//        for (int i = 0; i < 10000; i++) {
//            set.add(IDUtils.genBySnowFlake());
//        }
//        System.out.println(set.size());
//
//        assertTrue(set.size() == 10000);
//    }
//
//    public void testGenByRandom() throws Exception {
//        Set<Long> set = new HashSet();
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        for (int i = 0; i < 100000; i++) {
//            executorService.execute(new Runnable() {
//                @Override
//                public void run() {
//                    set.add(IDUtils.genBySnowFlake());
//                }
//            });
//        }
//        assertTrue(set.size() == 100000);
////        System.out.println(IDUtils.genByRandom());
//    }
//
//    public void testGenByRandom2() throws Exception {
//        Set<Long> set = new HashSet();
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        for (int i = 0; i < 100000; i++) {
//            executorService.execute(new Runnable() {
//                @Override
//                public void run() {
//                    set.add(IdWorker.getId());
//                }
//            });
//        }
//        assertTrue(set.size() == 100000);
////        System.out.println(IDUtils.genByRandom());
//    }
//
//    public void test() throws InterruptedException {
//       Set set=new HashSet();
//       ExecutorService executorService=Executors.newFixedThreadPool(5);
//       DateTime dateTime=DateTime.now().plusSeconds(1);
//       while (DateTime.now().isBefore(dateTime))
//       executorService.execute(new Runnable() {
//           @Override public void run() {
//               set.add(IdWorker.getId());
//           }
//       });
//        System.out.println(executorService.awaitTermination(2, TimeUnit.SECONDS));
//        System.out.println(set.size());
//    }
//}