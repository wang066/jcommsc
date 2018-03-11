package cn.jcomm.test.netty.httpserver.base;

import io.netty.handler.codec.http.FullHttpRequest;

/**
 * Created by jowang on 2017/5/22 0022.
 */
public abstract class HttpUrlRoute {
    //    public abstract <T> Result<T> execute(FullHttpRequest request);
    public abstract Object execute(FullHttpRequest request);
}
