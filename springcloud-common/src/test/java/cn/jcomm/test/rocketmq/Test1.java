// package cn.jcomm.test.rocketmq;
//
// public class Test1 {
//     @Transactional
//     public void bussiness(){
//         // 处理业务
//         // ---
//         // 下面的代码事务提交后才执行
//         TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
//             @Override
//             public void afterCommit() {
//                 //这里面是业务代码,例如发送mq
//                 //mqClient.send(mqMessage);
//             }
//         });
//     }
//
// }
