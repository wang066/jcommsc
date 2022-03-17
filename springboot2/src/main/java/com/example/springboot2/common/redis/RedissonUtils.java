// package com.example.springboot2.common.redis;
//
// import org.redisson.Redisson;
// import org.redisson.api.RLock;
// import org.redisson.api.RedissonClient;
// import org.redisson.config.Config;
//
// /**
//  * @author: jowang
//  * @date: 2018/4/8 0008 16:17
//  * @description:
//  */
// // @Slf4j
// public abstract class RedissonUtils {
//     private RedissonUtils(){
//
//     }
//
//     /**
//      * 使用ip地址和端口创建Redisson
//      * @param ip
//      * @param port
//      * @return
//      */
//     public static RedissonClient getRedisson(String ip,String port){
//         Config config=new Config();
//         config.useSingleServer().setAddress(ip+":"+port);
//         RedissonClient redisson= Redisson.create(config);
//         // log.debug("成功连接Redis Server"+"\t"+"连接"+ip+":"+port+"服务器");
//         return redisson;
//     }
//
//     /**
//      * 关闭Redisson客户端连接
//      * @param client
//      */
//     public static void closeRedisson(RedissonClient client){
//         client.shutdown();
//         // log.debug("成功关闭Redis Client连接");
//     }
//
//     /**
//      * 获取锁
//      * @param client
//      * @param name
//      * @return
//      */
//     public RLock getRLock(RedissonClient client,String name){
//         RLock rLock=client.getLock(name);
//         return rLock;
//     }
// }
