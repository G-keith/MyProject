package com.springboot.redis;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.springboot.common.utils.RedisUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.io.*;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisUtil redisUtil;


    private static Logger logger = LoggerFactory.getLogger(TestRedis.class);


    @Test
    public void test() throws Exception {
        redisTemplate.opsForValue().set("aaa", "111");
        redisTemplate.opsForValue().set("aaaa", "2222");
        Assert.assertEquals("2222", redisTemplate.opsForValue().get("aaaa"));
    }

    /**
     * TimeUnit
     * MICROSECONDS    微秒   一百万分之一秒（就是毫秒/1000）
     * MILLISECONDS    毫秒   千分之一秒
     * NANOSECONDS   毫微秒  十亿分之一秒（就是微秒/1000）
     * SECONDS          秒
     * MINUTES     分钟
     * HOURS      小时
     * DAYS      天
     *
     * @throws Exception
     */
    @Test
    public void testObj() throws Exception {
//        Set<String> sets = redisUtil.findKey("LIKE");
//        for (String str : sets) {
//            String[] strs = str.split(":");
//            System.out.println(strs[1].toString());
//        }
      //  redisUtil.sSet("LI_KE:52", 1);
    }

    @Test
    public void testSession() {

        Set<String> infoViewSet=redisTemplate.keys("*:*");
        for(String s:infoViewSet){
            redisUtil.del(s);
        }

//        String name=stringRedisTemplate.opsForValue().get("name");
//        System.out.println(name);
    }

    //连接本地的 Redis 服务
    @Test
    public void testJedis() {
        //连接本地的 Redis 服务
        Jedis jedis=new Jedis();
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setDatabase(0);
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
    }

    public static String getType(Object o) { //获取变量类型方法
        return o.getClass().toString(); //使用int类型的getClass()方法
    }

    public static byte[] serialize(Object obj) {
        ObjectOutputStream obi = null;
        ByteArrayOutputStream bai = null;
        try {
            bai = new ByteArrayOutputStream();
            obi = new ObjectOutputStream(bai);
            obi.writeObject(obj);
            byte[] byt = bai.toByteArray();
            return byt;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //反序列化
    public static Object unserizlize(byte[] byt) {
        ObjectInputStream oii = null;
        ByteArrayInputStream bis = null;
        bis = new ByteArrayInputStream(byt);
        try {
            oii = new ObjectInputStream(bis);
            Object obj = oii.readObject();
            return obj;
        } catch (Exception e) {

            e.printStackTrace();
        }
        return null;
    }
    @Test
    public void testGuaua(){
       List<String> list= Lists.newArrayList("a","b","c",null,"d","","e");
//        System.out.println(Joiner.on(",").skipNulls().join(list));

        Multimap<String,String> multimap= ArrayListMultimap.create();
        multimap.put("张三","1");
        multimap.put("张三","2");
        System.out.println(multimap);
    }
}