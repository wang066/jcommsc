package cn.jcomm.test.concurrency.a.a4;

/**
 *生产者消费者
 */
public class ProducerConsumerTest {

    private static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread1 t1=new Thread1();
        t1.setName("1");
        Thread2 t2=new Thread2();
        t2.setName("2");
        t1.start();

        t1.sleep(500);
        t2.start();
    }

    static class Thread1 extends Thread{
        @Override
        public void run() {
            synchronized (object) {
                try {
                    object.wait();
                }catch (Exception e){

                }

                System.out.println("线程"+Thread.currentThread().getName()+"获得了锁");
            }
        }
    }

    static class Thread2 extends Thread{
        @Override
        public void run() {
            synchronized (object) {
                object.notify();
                System.out.println("线程"+Thread.currentThread().getName()+"调用了notify");
            }
            System.out.println("线程"+Thread.currentThread().getName()+"释放了锁");
        }
    }
}
