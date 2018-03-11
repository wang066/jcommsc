package cn.jcomm.test.concurrency.b.b1;

/**
 * 关键字synchronized取得的锁都是对象锁，而不是把一段代码（方法）当做锁，
 * 所以代码中哪个线程先执行synchronized关键字的方法，哪个线程就持有该方法所属对象的锁（Lock），
 * <p>
 * 在静态方法上加synchronized关键字，表示锁定.class类，类一级别的锁（独占.class类）。
 * 线程安全概念：当多个线程访问某一个类（对象或方法）时，这个对象始终都能表现出正确的行为，那么这个类（对象或方法）就是线程安全的。
 * synchronized：可以在任意对象及方法上加锁，而加锁的这段代码称为"互斥区"或"临界区"
 */
public class SynchronizedMethodTest {
    private int num = 0;

    //注意观察run方法输出顺序
    public static void main(String[] args) {

        //俩个不同的对象
        final SynchronizedMethodTest m1 = new SynchronizedMethodTest();
        final SynchronizedMethodTest m2 = new SynchronizedMethodTest();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                m1.printNum("a");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                m2.printNum("b");
            }
        });

        t1.start();
        t2.start();
    }

    /**
     * static
     */
    public synchronized void printNum(String tag) {
        try {

            if (tag.equals("a")) {
                num = 100;
                System.out.println("tag a, set num over!");
                Thread.sleep(1000);
            } else {
                num = 200;
                System.out.println("tag b, set num over!");
            }

            System.out.println("tag " + tag + ", num = " + num);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

