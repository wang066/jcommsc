package com.example.springboot2.pack3;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

/**
 * @author: jowang
 * @date: 2018-07-02 11:24
 * @description:
 */
public class JsonTest {
    @Test
    public void test() {
        JSONObject object = new JSONObject();
        object.put("a", null);
        System.out.println(object.toJSONString());
    }
}
