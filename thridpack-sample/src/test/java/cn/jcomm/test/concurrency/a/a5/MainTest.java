package cn.jcomm.test.concurrency.a.a5;

/**
 *
 */
public class MainTest {

    /**
     * 测试启动线程会不会被关闭----result 不会
     *
     * @param args
     */
    public static void main(String[] args) {
//                new Thread(new Runnable() {
//            @Override
//            public void run() {
//               while (true){
//                   try {
//                       Thread.sleep(100);
//                   } catch (InterruptedException e) {
//                       e.printStackTrace();
//                   }
//                   System.out.println(1);
//               }
//            }
//        }).start();

//        new Thread(new MyThread()).start();

//        BlockingQueue<String> list = new LinkedBlockingDeque<>();
//        ThreadPoolExecutor poolExecutor=new ThreadPoolExecutor(2,3,4, TimeUnit.SECONDS,block)


    }


    static class MyThread implements Runnable {

        private int i = 10;

        @Override
        public void run() {
            i++;
            System.out.println(i++);
        }
    }


}

