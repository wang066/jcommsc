package cn.jcomm.test.concurrency.c;

/**
 * @author: jowang
 * @date: 2018-09-18 9:43
 * @description:
 */
public class PossibleReordering {
    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for (; ; ) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            Thread one = new Thread(new Runnable() {
                public void run() {
                    //由于线程one先启动，下面这句话让它等一等线程two. 读着可根据自己电脑的实际性能适当调整等待时间.
                    // shortWait(100000);
                    // a = 1;
                    System.out.println(a + "" + a);
                    // System.out.println(a);
                    // x = b;
                }
            });

            Thread other = new Thread(new Runnable() {
                public void run() {
                    // b = 1;
                    // y = a;
                    if (a == 0) {
                        a = 1;
                    } else {
                        a = 0;
                    }
                }
            });
            one.start();
            other.start();
            one.join();
            other.join();
            String result = "第" + i + "次 (" + x + "," + y + "）";
            if (x == 0 && y == 0) {
                // System.err.println(result);
                // break;
            } else {
                // System.out.println(result);
            }
        }
    }


    public static void shortWait(long interval) {
        long start = System.nanoTime();
        long end;
        do {
            end = System.nanoTime();
        } while (start + interval >= end);
    }
}
