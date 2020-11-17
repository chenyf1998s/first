package com.cyf.jedisdemo.base1;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Set;

/**
 * @author chenyifan
 * @description TODO
 * @date 2020/8/31 10:15 上午
 */
public class JedisTest {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("120.26.163.40", 6379);
        jedis.auth("123456");
        System.out.println(jedis.ping());
        jedis.set("size", "XXL");
        System.out.println("当前数据库中所有数据:" + jedis.keys("*"));
        Set<String> keys = jedis.keys("*");
        System.out.println(jedis.get("name"));
        System.out.println(jedis.get("animal"));
    }
}
