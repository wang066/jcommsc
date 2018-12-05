package cn.jcomm.rpc.module.serialize;

/**
 * @author: jowang
 * @date: 2018-11-30 11:00
 * @description:
 */
public interface Serialization {

    byte[] serialize(Object obj);

    <T> T deserialize(byte[] bytes, Class<T> clz);
}
