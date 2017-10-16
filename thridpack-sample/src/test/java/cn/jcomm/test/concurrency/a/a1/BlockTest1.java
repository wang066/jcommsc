package cn.jcomm.test.concurrency.a.a1;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RecursiveTask;

/**
 * Created by jowang on 2017/1/2 0002.
 */
public class BlockTest1 {


//    static class Test1{
//        public static void main(String[] args) {
//
//        }
//    }

    static class Test1{
        public static void main(String[] args) {
//            TransferQueue<Integer>

            ConcurrentHashMap concurrentHashMap=new ConcurrentHashMap();
//            Map map;
        }

        class Counter extends RecursiveTask{

            @Override
            protected Object compute() {
                Counter first=new Counter();
                invokeAll(first);
                return first.join();
            }
        }
    }
}
