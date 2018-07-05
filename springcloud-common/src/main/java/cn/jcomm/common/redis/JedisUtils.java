package cn.jcomm.common.redis;

import com.google.common.base.Throwables;
import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public abstract class JedisUtils {

    private static final Logger logger = Logger.getLogger(JedisUtils.class);

    /**
     * pop list
     * @param jedisPool
     * @param key
     * @return
     */
    public static String lpop(JedisPool jedisPool, String key) {
        String result = null;
        Jedis jedis = jedisPool.getResource();
        try {
            result = jedis.lpop(key);
        } catch (Exception e) {
            Throwables.throwIfUnchecked(e);
        } finally {
            jedis.close();
        }
        return result;
    }


    /**
     * pop set
     * @param jedisPool
     * @param key
     * @return
     */
    public static String spop(JedisPool jedisPool, String key) {
        String result = null;
        Jedis jedis = jedisPool.getResource();
        try {
            result = jedis.spop(key);
        } catch (Exception e) {
            Throwables.throwIfUnchecked(e);
        } finally {
            jedis.close();
        }
        return result;
    }


    public static String set(JedisPool jedisPool, String key, String value, int seconds) {
        String result = null;
        Jedis jedis = jedisPool.getResource();
        try {
            result = jedis.set(key, value);
            jedis.expire(key, seconds);
        } catch (Exception e) {
            Throwables.throwIfUnchecked(e);
        } finally {
            jedis.close();
        }
        return result;
    }

    public static String get(JedisPool jedisPool, String key) {
        String result = null;
        Jedis jedis = jedisPool.getResource();
        try {
            result = jedis.get(key);
        } catch (Exception e) {
            Throwables.throwIfUnchecked(e);
        } finally {
            jedis.close();
        }
        return result;
    }


    public static void rpush(JedisPool jedisPool, String key, String value) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.rpush(key, value);
        } catch (Exception e) {
            Throwables.throwIfUnchecked(e);
        } finally {
            jedis.close();
        }
    }

    public static void sadd(JedisPool jedisPool, String key, String value) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.sadd(key, value);
        } catch (Exception e) {
            Throwables.throwIfUnchecked(e);
        } finally {
            jedis.close();
        }
    }
}
