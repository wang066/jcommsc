package cn.jcomm.test.thridpack.zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.CloseableUtils;
import org.joda.time.DateTime;

/**
 * Created by jowang on 2017/5/31 0031.
 * zk 能做哪些事
 * 负载均衡
 * 命名服务
 * 分布式锁
 * 分布式队列
 * 配置中心
 */
public class ZookeeperTest {
    private static final int SESSION_OUTTIME = 5000;//ms
    private static String ZOOKEEPER_CONNECTION_STRING = "127.0.0.1:2181";
    private static String PATH = "/a/b";
    private static byte[] bytes = "ab".getBytes();

    public static void main(String[] args) {

        //Curator 版本3 以下 可以运行???

//        RetryPolicy retryPolicy = new ExponentialBackoffRetry(100, 3);
//        CuratorFramework client = CuratorFrameworkFactory.newClient(ZOOKEEPER_CONNECTION_STRING, retryPolicy);
//        client.start();


        System.out.println(DateTime.now());
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(100, 3);
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString(ZOOKEEPER_CONNECTION_STRING)
                .sessionTimeoutMs(SESSION_OUTTIME)
                .retryPolicy(retryPolicy)
                .build();
        client.start();


        System.out.println("client start");
        System.out.println(DateTime.now());
        try {

//            增 默认持久化
//            client.create().creatingParentsIfNeeded().forPath("/e/f", "cd".getBytes());

//            读
//            System.out.println(new String(client.getData().forPath(PATH)));


//            删除 inBackgroud 在后台执行
//            client.delete().inBackground().forPath(PATH);

//            临时顺序节点
//            client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath("/c/d", "cd".getBytes());

//            在事务中
//            client.inTransaction().check().

//            client.setData().inBackground().forPath("/a","zzzzz".getBytes());

//            Stat stat = client.checkExists().inBackground().forPath("/a");
//            System.out.println(stat);

//            client.getData().watched().inBackground().forPath("/a");

//            CuratorFramework MyAppclient = CuratorFrameworkFactory.builder()
//                    .connectString(ZOOKEEPER_CONNECTION_STRING)
//                    .sessionTimeoutMs(SESSION_OUTTIME)
//                    .retryPolicy(retryPolicy)
//                    .namespace("MyApp")
//                    .build();
//
//            MyAppclient.start();
//            MyAppclient.create().forPath("/a", "a".getBytes());
//            MyAppclient.close();

//            事务
//            Collection<CuratorTransactionResult> results = client.inTransaction().create().forPath("/a/b", "some data".getBytes()).and().commit();
//            // called
//            for (CuratorTransactionResult result : results) {
//                System.out.println(result.getForPath() + " - " + result.getType());
//            }
//            System.out.println(results);

        } catch (Exception e) {
            e.printStackTrace();
        }

        CloseableUtils.closeQuietly(client);
        System.out.println("client stop");


//        ---------------------------------分布式锁------------------------------------------------
//        InterProcessMutex lock = new InterProcessMutex(client, lockPath);
//        if ( lock.acquire(maxWait, waitUnit) )
//        {
//            try
//            {
//                // do some work inside of the critical section here
//            }
//            finally
//            {
//                lock.release();
//            }
//        }

        //--------------------------------选举-------------------------------------------------
//        LeaderSelectorListener listener = new LeaderSelectorListenerAdapter()
//        {
//            public void takeLeadership(CuratorFramework client) throws Exception
//            {
//                // this callback will get called when you are the leader
//                // do whatever leader work you need to and only exit
//                // this method when you want to relinquish leadership
//            }
//        }
//
//        LeaderSelector selector = new LeaderSelector(client, path, listener);
//        selector.autoRequeue();  // not required, but this is behavior that you will probably expect
//        selector.start();

    }


}
