package com.example.springboot_common.netty.httpserver.base;

import io.netty.handler.codec.http.FullHttpRequest;

/**
 * Created by jowang on 2017/5/22 0022.
 */
public abstract class HttpUrlRoute {

    public abstract Object execute(FullHttpRequest request);
}
