package cn.jcomm.rpc.module.proxy;

/**
 * @author: jowang
 * @date: 2018-11-29 17:35
 * @description:
 */
public interface ProxyFactory {

    <T> T getProxy(Class<T> clz);
}
