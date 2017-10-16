package cn.jcomm.test.thridpack.packtest.netty.netty4.http;

import com.alibaba.fastjson.JSON;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.multipart.Attribute;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

/**
 * Created by jowang on 2017/5/2 0002.
 */
public class HttpHelloWorldServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
//    /**
//     * 返回内容类型：普通文本
//     */
//    public final static String CONTENT_TYPE_TEXT = "text/plain";
//    /**
//     * 返回内容类型：HTML
//     */
//    public final static String CONTENT_TYPE_HTML = "text/html";
//    /**
//     * 返回内容类型：XML
//     */
//    public final static String CONTENT_TYPE_XML = "text/xml";
//    /**
//     * 返回内容类型：JAVASCRIPT
//     */
//    public final static String CONTENT_TYPE_JAVASCRIPT = "application/javascript";
    /**
     * 返回内容类型：JSON
     */
    public final static String CONTENT_TYPE_JSON = "application/json";
    public final static String CONTENT_TYPE_JSON_IE = "text/json";

    private static final Charset CHARSET_UTF8 = Charset.forName("UTF-8");

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

    private static final Map<String, Method> Get_Url_Method = new HashMap<>();
    private static final Map<String, Method> Post_Url_Method = new HashMap<>();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {

//        HttpMethod httpMethod = request.method();
//        if (httpMethod == HttpMethod.GET) {
//            QueryStringDecoder decoder = new QueryStringDecoder(request.uri());
////            data = JsonTools.beanToJson(decoder.parameters());
//            System.out.println(decoder.parameters());
//        } else if (httpMethod == HttpMethod.POST) {
//
////            if (postData != null && postData.trim().length() > 0) {
////                Hashtable<String, Object> postDataMap = new Hashtable<String, Object>();
////                if (contentType.contains("multipart/form-data")) {
////                    postDataMap = parseFromdata(postData, getData);
////                    data = JsonTools.beanToJson(postDataMap);
////                } else if (contentType.contains("x-www-form-urlencoded")) {
////                    postDataMap = parseQueryString(postData + "&" + getData);
////                    data = JsonTools.beanToJson(postDataMap);
////                } else {
////                    data = postData;
////                }
////            }
//        }

        try {
            String url = request.uri();
            HttpMethod httpMethod = request.method();
            Map<String, String> parameters = parameters(request);
            System.out.println(url);
            System.out.println(httpMethod);
            System.out.println(parameters);

            String responseContent = JSON.toJSONString(1);
            writeResponse(ctx, request, responseContent);
        } catch (Exception e) {
            String responseContent = JSON.toJSONString(0);
            writeResponse(ctx, request, responseContent);
        }
    }

    private void writeResponse(ChannelHandlerContext ctx, FullHttpRequest request, String responseContent) throws UnsupportedEncodingException {
        writeResponse(ctx, request, responseContent, HttpResponseStatus.OK);
    }

    private void writeResponse(ChannelHandlerContext ctx, FullHttpRequest request, String responseContent, HttpResponseStatus httpResponseStatus) throws UnsupportedEncodingException {
        FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1,
                httpResponseStatus, Unpooled.wrappedBuffer(responseContent.getBytes(CHARSET_UTF8.name())));
        response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/json; charset=" + CHARSET_UTF8.name());
        response.headers().set(HttpHeaderNames.CONTENT_LENGTH,
                response.content().readableBytes());
        if (HttpUtil.isKeepAlive(request)) {
            response.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
        }
        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }

    private Map<String, String> parameters(FullHttpRequest request) throws IOException {
        HttpMethod method = request.method();

        Map<String, String> parmMap = new HashMap<>();

        if (HttpMethod.GET == method) {
            // 是GET请求
            QueryStringDecoder decoder = new QueryStringDecoder(request.uri());
            decoder.parameters().entrySet().forEach(entry -> {
                // entry.getValue()是一个List, 只取第一个元素
                parmMap.put(entry.getKey(), entry.getValue().get(0));
            });

        } else if (HttpMethod.POST == method) {
            // 是POST请求
            HttpPostRequestDecoder decoder = new HttpPostRequestDecoder(request);
            decoder.offer(request);

            List<InterfaceHttpData> parmList = decoder.getBodyHttpDatas();

            for (InterfaceHttpData parm : parmList) {

                Attribute data = (Attribute) parm;
                parmMap.put(data.getName(), data.getValue());
            }
        }

        return parmMap;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
