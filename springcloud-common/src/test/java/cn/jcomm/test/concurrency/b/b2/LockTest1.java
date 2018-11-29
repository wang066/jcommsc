package cn.jcomm.test.concurrency.b.b2;

/**
 * Created by jowang on 2017/6/6 0006.
 */
public class LockTest1 {
}


class Sync {

    //锁住当前对象
//    public synchronized void Test1() {
//        System.out.println("test开始..");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("test结束..");
//    }

    //锁住当前对象
//    public void Test1() {
//        synchronized(this){
//            System.out.println("test开始..");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("test结束..");
//        }
//    }


    //锁住当前类
    public void test() {
        synchronized (Sync.class) {
            System.out.println("test开始..");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test结束..");
        }
    }
}

class MyThread extends Thread {

    public void run() {
        Sync sync = new Sync();
        sync.test();
    }
}

class Main {

   public static void main(String[] args) {
       for (int i = 0; i < 3; i++) {
           Thread thread = new MyThread();
           thread.start();
       }
   }
}


