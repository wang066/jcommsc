package cn.jcomm.rpc.core.domain;

/**
 * @author: jowang
 * @date: 2018-11-29 18:28
 * @description:
 */
public interface Caller {
    Response call(Request request);
}
