package cn.jcomm.config;//package cn.jcomm.config;
//
//import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
//import com.dangdang.ddframe.rdb.sharding.api.strategy.database.SingleKeyDatabaseShardingAlgorithm;
//
//import java.util.Collection;
//
///**
// * Created by 066 on 2017/7/10 0010.
// */
//public class ProgramShardingAlgorithm implements SingleKeyDatabaseShardingAlgorithm<Integer> {
//    @Override
//    public String doEqualSharding(Collection<String> collection, ShardingValue<Integer> shardingValue) {
//        for (String s : collection) {
//            if (s.endsWith(shardingValue.getValue() % 14 + "")) {
//                return s;
//            }
//        }
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    public Collection<String> doInSharding(Collection<String> collection, ShardingValue<Integer> shardingValue) {
//        return null;
//    }
//
//    @Override
//    public Collection<String> doBetweenSharding(Collection<String> collection, ShardingValue<Integer> shardingValue) {
//        return null;
//    }
//}
