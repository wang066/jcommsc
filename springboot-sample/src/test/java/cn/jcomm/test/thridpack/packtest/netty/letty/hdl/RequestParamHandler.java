package cn.jcomm.test.thridpack.packtest.netty.letty.hdl;

import io.netty.handler.codec.http.FullHttpRequest;

import java.util.Map;

/**
 * Created by jowang on 2017/5/16 0016.
 */
public interface RequestParamHandler {
    Map<String,Object> getParam(FullHttpRequest request);
}
