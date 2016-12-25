package com.xc.jedis;

import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 * User: lenovo
 * Date: 2016/12/17
 * Time: 16:51
 * To change this template use File | Settings | File Templates
 */
public class JedisUtil {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    private static Map<String,JedisPool> maps = new HashMap<String,JedisPool>();

    private static class RedisUtilHolder{
        private static final JedisUtil instance = new JedisUtil();
    }

    public static JedisUtil getInstance(){
        return RedisUtilHolder.instance;
    }

    private static JedisPool getPool(String ip, int port){
        String key = ip+":"+port;
        JedisPool pool = null;
        if(!maps.containsKey(key)){
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(RedisConfig.MAX_ACTIVE);
            config.setMaxIdle(RedisConfig.MAX_IDLE);
            config.setMaxWaitMillis(RedisConfig.MAX_WAIT);
            config.setTestOnBorrow(true);
            config.setTestOnReturn(true);

            pool = new JedisPool(config,ip,port,RedisConfig.TIMEOUT);
            maps.put(key, pool);
        }else{
            pool = maps.get(key);
        }
        return pool;
    }

    public Jedis getJedis(String ip, int port){
        Jedis jedis = null;
        int count = 0;
        do{
            try{
                jedis = getPool(ip,port).getResource();
            }catch (Exception e)
            {
                logger.error("get redis master1 failed!",e);
                getPool(ip,port).returnBrokenResource(jedis);
            }
        }while (jedis == null && count<RedisConfig.RETRY_NUM);
        return jedis;
    }

    public void closeJedis(Jedis jedis, String ip, int port){
        if(jedis != null)
        {
//            getPool(ip,port).returnResource(jedis);
            jedis.close();
        }
    }

}
