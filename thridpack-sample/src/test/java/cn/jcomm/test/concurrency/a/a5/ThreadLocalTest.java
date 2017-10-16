package cn.jcomm.test.concurrency.a.a5;

/**
 *
 */
public class ThreadLocalTest {

    private static ThreadLocal<Integer> threadLocal=new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }

    };

    public int getNextNum(){
        threadLocal.set(threadLocal.get()+1);
        return threadLocal.get();
    }
    private static class TestClient extends Thread{
        private ThreadLocalTest sn;
        public TestClient(ThreadLocalTest sn){
            this.sn = sn;
        }

        public void run(){
            //④每个线程打出3个序列值
            for (int i = 0 ;i<3;i++){
                System.out.println("thread["+Thread.currentThread().getName()+"] sn["+sn.getNextNum()+"]");
            }
        }
    }


    public static void main(String[] args) {
        ThreadLocalTest sn = new ThreadLocalTest();
        //③ 3个线程共享sn，各自产生序列号
        TestClient t1 = new TestClient(sn);
        TestClient t2 = new TestClient(sn);
        TestClient t3 = new TestClient(sn);
        t1.start();
        t2.start();
        t3.start();
    }
}
