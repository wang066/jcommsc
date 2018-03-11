package cn.jcomm.test.zk;
//
//import org.apache.zookeeper.WatchedEvent;
//import org.apache.zookeeper.Watcher;
//import org.apache.zookeeper.ZooKeeper;
//
//import java.io.IOException;
//import java.util.concurrent.CountDownLatch;
//
///**
// * Created by 066 on 2017/5/26 0026.
// */
//public class ZookpeerTest2 {
//    /**
//     * zookeeper地址
//     */
//    private static final String CONNECT_ADDR = "127.0.0.1:2181";
//    /**
//     * session超时时间
//     */
//    private static final int SESSION_OUTTIME = 5000;//ms
//
//    private static final CountDownLatch LATCH = new CountDownLatch(1);
//
//    public static void main(String[] args) throws IOException, InterruptedException {
//        ZooKeeper zk = new ZooKeeper(CONNECT_ADDR, SESSION_OUTTIME, new Watcher() {
//            @Override
//            public void process(WatchedEvent watchedEvent) {
//                Event.KeeperState keeperState = watchedEvent.getState();
//                Event.EventType eventType = watchedEvent.getType();
//                if (Event.KeeperState.SyncConnected == keeperState && Event.EventType.None == eventType) {
//                    LATCH.countDown();
//                    System.out.println("zk connecting");
//                }
//            }
//        });
//
//        LATCH.await();
//    }
//}
