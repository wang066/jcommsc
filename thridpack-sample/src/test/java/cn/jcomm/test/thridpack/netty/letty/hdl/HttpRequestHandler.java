package cn.jcomm.test.thridpack.packtest.netty.letty.hdl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

/**
 * Created by jowang on 2017/5/2 0002.
 */
public class HttpRequestHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    /**
     * 返回内容类型：JSON
     */
    public final static String CONTENT_TYPE_JSON = "application/json";
    public final static String CONTENT_TYPE_JSON_IE = "text/json";

    private static final Charset CHARSET_UTF8 = Charset.forName("UTF-8");

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpRequestHandler.class);

    @Override
    protected void channelRead0(final ChannelHandlerContext ctx, final FullHttpRequest request) throws Exception {

        try {
            String url = request.uri();
            HttpMethod httpMethod = request.method();
            Map<String, String> parameters = parameters(request);

            //route

            String responseContent = JSON.toJSONString(1);
            writeResponse(ctx, request, responseContent);
        } catch (IOException e) {
            e.printStackTrace();
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

    /**
     * 只能解析x-www-form-urlencoded 和 url 的数据
     *
     * @param request
     * @return
     * @throws IOException
     */
    private Map<String, String> parameters(FullHttpRequest request) throws IOException {
        HttpMethod method = request.method();

        Map<String, String> parmMap = new HashMap<String, String>();

        if (HttpMethod.GET == method) { // 是GET请求

            QueryStringDecoder decoder = new QueryStringDecoder(request.uri());
            for (Map.Entry<String, List<String>> entry : decoder.parameters().entrySet()) {
                parmMap.put(entry.getKey(), entry.getValue().get(0));
            }

        } else if (HttpMethod.POST == method) { // 是POST请求

            //form-data

            //application/x-www-form-urlencoded
//            HttpPostRequestDecoder decoder = new HttpPostRequestDecoder(request);
//            decoder.offer(request);
//            List<InterfaceHttpData> parmList = decoder.getBodyHttpDatas();
//
//            for (InterfaceHttpData parm : parmList) {
//
//                Attribute data = (Attribute) parm;
//                parmMap.put(data.getName(), data.getValue());
//            }

            //row
            try {
                String json = request.content().toString(CharsetUtil.UTF_8);
                JSONObject jsonObject = JSON.parseObject(json);
                for (String name : jsonObject.keySet()) {
                    parmMap.put(name, (String) jsonObject.get(name));
                }
            } catch (Exception e) {
                LOGGER.error("parameters",e);
            }

            //binary

//            return null;
        }

        return parmMap;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        LOGGER.error("exceptionCaught",cause);
        ctx.close();
    }
}
