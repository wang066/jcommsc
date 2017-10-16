package cn.jcomm.test.thridpack.packtest.netty.letty.hdl;

import com.google.common.collect.ImmutableBiMap;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * Created by jowang on 2017/5/16 0016.
 */
public class JsonParamHandler implements RequestParamHandler {
    @Override
    public ImmutableBiMap<String, Object> getParam(FullHttpRequest request) {
        return null;
    }
}
