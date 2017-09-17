package cn.jcomm.config;//package cn.jcomm.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
///**
// * @author 程序猿DD
// * @version 1.0.0
// * @date 16/4/15 下午3:19.
// * @blog http://blog.didispace.com
// */
//@Configuration
//public class RedisConfig {
//
//    @Bean
//    private JedisConnectionFactory jedisConnectionFactory() {
//        return new JedisConnectionFactory();
//    }
//
//    @Bean
//    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
//        RedisTemplate<String, String> template = new RedisTemplate<String, String>();
//        template.setConnectionFactory(jedisConnectionFactory());
//        return template;
//    }
//
//}
