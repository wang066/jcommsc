package com.example.springboot_common.netty.httpserver.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Throwables;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.multipart.Attribute;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import io.netty.util.CharsetUtil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jowang on 2017/5/16 0016.
 */
public final class HttpServerUtils {

    public final static String CONTENT_TYPE_JSON = "application/json";
    public final static String CONTENT_TYPE_JSON_IE = "text/json";
    private final static Charset CHARSET_UTF8 = Charset.forName("UTF-8");

    /**
     * 只能解析x-www-form-urlencoded 和 url 的数据
     *
     * @param request
     * @return
     * @throws IOException
     */
    public static Map<String, String> parameters(FullHttpRequest request) throws IOException {
        HttpMethod method = request.method();
        Map<String, String> parmMap = new HashMap<String, String>();

        if (HttpMethod.GET == method) { // 是GET请求
            QueryStringDecoder decoder = new QueryStringDecoder(request.uri());
            for (Map.Entry<String, List<String>> entry : decoder.parameters().entrySet()) {
                parmMap.put(entry.getKey(), entry.getValue().get(0));
            }
        } else if (HttpMethod.POST == method) { // 是POST请求
            String contentType = request.headers().get(HttpHeaderNames.CONTENT_TYPE);
            switch (contentType) {
                case "application/x-www-form-urlencoded":
                    HttpPostRequestDecoder decoder = new HttpPostRequestDecoder(request);
                    decoder.offer(request);
                    List<InterfaceHttpData> parmList = decoder.getBodyHttpDatas();
                    for (InterfaceHttpData parm : parmList) {
                        Attribute data = (Attribute) parm;
                        parmMap.put(data.getName(), data.getValue());
                    }
                    break;
                case "multipart/form-data":
                    break;
                case "application/json":
                    String json = request.content().toString(CharsetUtil.UTF_8);
                    JSONObject jsonObject = JSON.parseObject(json);
                    for (String name : jsonObject.keySet()) {
                        parmMap.put(name, (String) jsonObject.get(name));
                    }
                    break;
                default:
                    throw new RuntimeException("无法处理的" + HttpHeaderNames.CONTENT_TYPE + ":" + contentType);
            }
        }

        return parmMap;
    }

    public static Map<String, String> parametersFromEncryptJson(FullHttpRequest request) throws IOException {
        HttpMethod method = request.method();
        Map<String, String> parmMap = new HashMap<String, String>();

        return parmMap;
    }


    /**
     * @param ctx
     * @param request
     * @param responseContent
     * @param httpResponseStatus
     */
    public static void response(ChannelHandlerContext ctx, FullHttpRequest request, String responseContent, HttpResponseStatus httpResponseStatus) {
        FullHttpResponse response = null;
        try {
            response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
                    httpResponseStatus, Unpooled.wrappedBuffer(responseContent.getBytes(CharsetUtil.UTF_8.name())));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            Throwables.throwIfUnchecked(e);
        }

        response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/json; charset=" + CharsetUtil.UTF_8.name());
        response.headers().set(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes());

        if (HttpUtil.isKeepAlive(request)) {
            response.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
        }
        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }

    public static void response(ChannelHandlerContext ctx, FullHttpRequest request, String responseContent, HttpResponseStatus httpResponseStatus, HttpHeaders httpHeaders) throws UnsupportedEncodingException {
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
                httpResponseStatus, Unpooled.wrappedBuffer(responseContent.getBytes(CharsetUtil.UTF_8.name())), httpHeaders, null);
        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }

    /**
     * @param ctx
     * @param request
     * @param responseContent
     * @throws UnsupportedEncodingException
     */
    public static void response(ChannelHandlerContext ctx, FullHttpRequest request, String responseContent) {
        response(ctx, request, responseContent, HttpResponseStatus.OK);
    }
}
