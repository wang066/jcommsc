package cn.jcomm.test.netty.httpserver.base;

import com.alibaba.fastjson.JSON;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jowang on 2017/5/2 0002.
 */
public class HttpServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpServerHandler.class);

    private HttpUrlRouteManager httpUrlRouteManager;

    public HttpServerHandler(HttpUrlRouteManager httpUrlRouteManager) {
        this.httpUrlRouteManager = httpUrlRouteManager;
    }

    @Override
    protected void channelRead0(final ChannelHandlerContext ctx, final FullHttpRequest request) throws Exception {
        HttpUrlRoute httpUrlRoute = httpUrlRouteManager.get(request.uri());
        if(httpUrlRoute==null){
            String responseContent = JSON.toJSONString(Result.error("没有路由对象"));
            HttpServerUtils.response(ctx, request, responseContent);
        }else{
            Object  result = httpUrlRouteManager.get(request.uri()).execute(request);
            String responseContent = JSON.toJSONString(result);
            HttpServerUtils.response(ctx, request, responseContent);
        }
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        LOGGER.error("exceptionCaught", cause);
        ctx.close();
    }
}
