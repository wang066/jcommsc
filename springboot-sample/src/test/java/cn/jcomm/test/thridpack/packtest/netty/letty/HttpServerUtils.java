package cn.jcomm.test.thridpack.packtest.netty.letty;

import com.google.common.base.Throwables;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.io.UnsupportedEncodingException;

/**
 * Created by jowang on 2017/5/16 0016.
 */
public final class HttpServerUtils {

//    public   static void response(ChannelHandlerContext ctx, FullHttpRequest request, String responseContent, HttpResponseStatus httpResponseStatus){
//
//    }

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
    private void response(ChannelHandlerContext ctx, FullHttpRequest request, String responseContent) {
        response(ctx, request, responseContent, HttpResponseStatus.OK);
    }
}
