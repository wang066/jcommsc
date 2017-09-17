package cn.jcomm.config;//package cn.jcomm.config;
//
//import com.dangdang.ddframe.rdb.sharding.api.ShardingDataSourceFactory;
//import com.dangdang.ddframe.rdb.sharding.api.rule.DataSourceRule;
//import com.dangdang.ddframe.rdb.sharding.api.rule.ShardingRule;
//import com.dangdang.ddframe.rdb.sharding.api.rule.TableRule;
//import com.dangdang.ddframe.rdb.sharding.api.strategy.table.SingleKeyTableShardingAlgorithm;
//import com.dangdang.ddframe.rdb.sharding.api.strategy.table.TableShardingStrategy;
//import com.dangdang.ddframe.rdb.sharding.jdbc.ShardingDataSource;
//import com.google.common.collect.Lists;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import javax.sql.DataSource;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
///**
// */
//@Configuration
//public class DataSourceConfig {
//
//    @Bean(name = "primaryDataSource")
//    @Qualifier("primaryDataSource")
//    @ConfigurationProperties(prefix="spring.datasource")
//    public DataSource primaryDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "secondaryDataSource")
//    @Qualifier("secondaryDataSource")
//    @Primary
//    @ConfigurationProperties(prefix="spring.datasource")
//    public DataSource secondaryDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "primaryJdbcTemplate")
//    public JdbcTemplate primaryJdbcTemplate(
//            @Qualifier("primaryDataSource") DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }
//
//    @Bean(name = "secondaryJdbcTemplate")
//    public JdbcTemplate secondaryJdbcTemplate(
//            @Qualifier("secondaryDataSource") DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }
//
////    @Bean(name = "shardingDataSource")
////    @Qualifier("shardingDataSource")
////    public DataSource shardingDataSource(DataSource dataSource){
////        HashMap<String, DataSource> map = new HashMap<>();
////        map.put("dataSource", dataSource);
////        DataSourceRule dataSourceRule = new DataSourceRule(map);
////
////        List<TableRule> tableRuleList = new ArrayList<>();
////        List<String> pList = new ArrayList<>();
////        for (int i = 1; i < 14; i++) {
////            pList.add("tb_p_" + i);
////        }
////        //tb_p逻辑表名，pList实际所有的分表
////        tableRuleList.add(new TableRule.TableRuleBuilder("tb_p")
////                .actualTables(pList)
////                .dataSourceRule(dataSourceRule)
////                .tableShardingStrategy(new TableShardingStrategy("item_id", (SingleKeyTableShardingAlgorithm<?>) new ProgramShardingAlgorithm())).build());
////        tableRuleList.add(new TableRule.TableRuleBuilder("tb_item")
////                .actualTables(Lists.newArrayList("tb_item"))
////                .dataSourceRule(dataSourceRule).build());
////        ShardingRule shardingRule = ShardingRule.builder()
////                .dataSourceRule(dataSourceRule)
////                .tableRules(tableRuleList)
////                .build();
////        return  ShardingDataSourceFactory.createDataSource(shardingRule);
////    }
//}
