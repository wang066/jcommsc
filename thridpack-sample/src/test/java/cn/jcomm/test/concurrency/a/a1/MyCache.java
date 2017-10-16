package cn.jcomm.test.concurrency.a.a1;
//
//import java.util.concurrent.*;
//
///**
// *
// */
//public class MyCache {
//    static ConcurrentMap map = new ConcurrentHashMap();
//    private static ExecutorService pool = Executors.newCachedThreadPool();
//
//    public static void main(String[] args) {
//        FutureTask f = (FutureTask) map.get("key");
//        if (f == null) {
//            Callable c=new Callable() {
//                @Override
//                public Object call() throws Exception {
//                    return "ok";
//                }
//            };
//            f=new FutureTask(c);
//            FutureTask old= (FutureTask) map.putIfAbsent("key",f);
//        }
//    }
//}
