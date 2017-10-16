package cn.jcomm.test.concurrency.a.a3;

/**
 * 线程让步 cpu 时间让步
 */
public class YieldTest implements  Runnable{
    Thread t;

    YieldTest(String str) {

        t = new Thread(this, str);
        // this will call run() function
        t.start();
    }

    public void run() {

        for (int i = 0; i < 5; i++) {
            // yields control to another thread every 5 iterations
            System.out.println(i);
            if ((i % 5) == 1) {
                System.out.println(Thread.currentThread().getName() + " yielding control...");

   /* causes the currently executing thread object to temporarily
   pause and allow other threads to execute */
                Thread.yield();
            }
        }

        System.out.println(Thread.currentThread().getName() + " has finished executing.");
    }

    public static void main(String[] args) {
        new YieldTest("Thread 1");
        new YieldTest("Thread 2");
        new YieldTest("Thread 3");
    }
}
