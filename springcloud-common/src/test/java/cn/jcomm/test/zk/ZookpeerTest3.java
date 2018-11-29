package cn.jcomm.test.zk;
//
//import org.apache.curator.framework.CuratorFramework;
//import org.apache.curator.framework.CuratorFrameworkFactory;
//import org.apache.curator.retry.ExponentialBackoffRetry;
//import org.apache.curator.utils.CloseableUtils;
//
//import java.io.Closeable;
//import java.io.IOException;
//
///**
// * Created by jowang on 2017/5/27 0027.
// */
//public class ZookpeerTest3 {
//
//    private static final String PATH = "/example/basic";
//
//    public static void main(String[] args) {
//        TestingServer server = new TestingServer();
//        CuratorFramework client = null;
//        try {
//            client = createSimple(server.getConnectString());
//            client.start();
//            client.create().creatingParentsIfNeeded().forPath(PATH, "Test1".getBytes());
//            CloseableUtils.closeQuietly(client);
//
////            client = createWithOptions(server.getConnectString(), new ExponentialBackoffRetry(1000, 3), 1000, 1000);
////            client.start();
//            System.out.println(new String(client.getData().forPath(PATH)));
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        } finally {
//            CloseableUtils.closeQuietly(client);
//            CloseableUtils.closeQuietly(server);
//        }
//    }
//
//    public static CuratorFramework createSimple(String connectAddress) {
//        //third will wait up 4 seconds
//        ExponentialBackoffRetry retry = new ExponentialBackoffRetry(1000, 3);
//        return CuratorFrameworkFactory.newClient(connectAddress, retry);
//    }
//
//    protected static class TestingServer implements Closeable {
//        public static String connectString = "127.0.0.1:2181";
//
//        public static String getConnectString() {
//            return connectString;
//        }
//
//        public static void setConnectString(String connectString) {
//            TestingServer.connectString = connectString;
//        }
//
//        @Override public void close() throws IOException {
//
//        }
//    }
//}
