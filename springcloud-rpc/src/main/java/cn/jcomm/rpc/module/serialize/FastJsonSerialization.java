package cn.jcomm.rpc.module.serialize;

import com.alibaba.fastjson.JSON;

/**
 * @author: jowang
 * @date: 2018-11-30 11:03
 * @description:
 */
public class FastJsonSerialization implements Serialization {
    public byte[] serialize(Object obj) {
        return JSON.toJSONString(obj).getBytes();
    }

    public <T> T deserialize(byte[] bytes, Class<T> clz) {
        return JSON.parseObject(new String(bytes), clz);
    }
}
