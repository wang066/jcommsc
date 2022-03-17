//package cn.jcomm.test.concurrency.a.a1;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//import java.util.concurrent.*;
//
///**
// *
// */
//public class DelayedTaskTest {
//
//
//    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE);
//        Random rand = new Random(47);
//        DelayQueue<DelayedTask> queue = new DelayQueue<DelayedTask>();
//        ExecutorService exec = Executors.newCachedThreadPool();
//        for (int i = 0; i < 20; i++) {
//            queue.put(new DelayedTask(rand.nextInt(5000)));
////            queue.put(new DelayedTask(i*100));
//        }
//        queue.add(new DelayedTask.EndSentinel(5000, exec));
//        exec.execute(new DelayedTaskConsumer(queue));
//    }
//
//}
//
//
//class DelayedTask implements Delayed, Runnable {
//
//    private static int counter = 0;
//    private final int id = 1;
//    private final int delta;
//    private final long trigger;
//
//    protected static List<DelayedTask> sequence = new ArrayList<>();
//
//    DelayedTask(int delayInMilliseconds) {
//        delta = delayInMilliseconds;
//        trigger = System.nanoTime() + TimeUnit.NANOSECONDS.convert(delayInMilliseconds, TimeUnit.MILLISECONDS);
//        sequence.add(this);
//    }
//
//    @Override
//    public long getDelay(TimeUnit unit) {
//        return unit.convert(trigger - System.nanoTime(), TimeUnit.MILLISECONDS);
//    }
//
//    @Override
//    public int compareTo(Delayed o) {
//        DelayedTask that = (DelayedTask) o;
//        if (this.trigger > that.trigger) return 1;
//        else if (this.trigger < that.trigger) return -1;
//        else return 0;
//    }
//
//    @Override
//    public void run() {
//        System.out.println(this + "  is running");
//    }
//
//    public String toString() {
//        return "  Task:" + id + " delta:" + delta;
//    }
//
//    public String summary() {
//        return " id:" + id + "  delta:" + delta;
//    }
//
//    public static class EndSentinel extends DelayedTask {
//        private ExecutorService exec;
//
//        public EndSentinel(int delayInMilliseconds, ExecutorService exec) {
//            super(delayInMilliseconds);
//            this.exec = exec;
//        }
//
//        public void run() {
//            for (DelayedTask dt : sequence) {
//                System.out.println(dt.summary() + "  ");
//            }
//            System.out.print(' ');
//            System.out.println(this + " Calling ShutdownNow()");
//            exec.shutdownNow();
//        }
//    }
//}
//
//class DelayedTaskConsumer implements Runnable {
//
//    private DelayQueue<DelayedTask> delayTaskDelayedQueue;
//
//    public DelayedTaskConsumer(DelayQueue<DelayedTask> delayTaskDelayedQueue) {
//        this.delayTaskDelayedQueue = delayTaskDelayedQueue;
//    }
//
//    @Override
//    public void run() {
//        try {
//            while (!Thread.interrupted()) {
//                delayTaskDelayedQueue.take().run();
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("finished delayedtask consume!!!!!");
//    }
//}