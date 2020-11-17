package com.cyf.jedisdemo.base1;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @author chenyifan
 * @description TODO
 * @date 2020/8/31 10:42 上午
 */
public class JedisTranscation {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("120.26.163.40", 6379);
        jedis.auth("123456");
        jedis.select(2);
        jedis.flushDB();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("color", "Blue");
        jsonObject.put("animal", "pig");

        String s = jsonObject.toJSONString();

        Transaction multi = jedis.multi();
        try {
            multi.set("things1",s);
            multi.set("things2",s);
            int i = 1 / 0;
            multi.exec();
        } catch (Exception e) {
            multi.discard();
            e.printStackTrace();
        } finally {
            System.out.println(jedis.get("things1"));
            System.out.println(jedis.get("things2"));
            jedis.close();
        }
    }
}
