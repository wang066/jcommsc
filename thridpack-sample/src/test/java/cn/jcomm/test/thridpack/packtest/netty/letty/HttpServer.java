package cn.jcomm.test.thridpack.packtest.netty.letty;

import cn.jcomm.test.thridpack.packtest.netty.letty.hdl.HttpRequestHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.cors.CorsConfig;
import io.netty.handler.codec.http.cors.CorsConfigBuilder;
import io.netty.handler.codec.http.cors.CorsHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * An HTTP server that sends back the content of the received HTTP request
 * in a pretty plaintext form.
 */
public final class HttpServer {

    public static final int PORT = 8080;

    public static void start() throws Exception {

        // Configure the server.
        EventLoopGroup bossGroup = new NioEventLoopGroup();//(1)
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.option(ChannelOption.SO_BACKLOG, 1024);
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        public final EventExecutorGroup group = new DefaultEventExecutorGroup(16);

                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            CorsConfig corsConfig = CorsConfigBuilder.forAnyOrigin().build();
                            ChannelPipeline p = ch.pipeline();
                            p.addLast(new HttpServerCodec());
                            p.addLast(new HttpObjectAggregator(65536));//把多个消息转换为一个单一的FullHttpRequest或是FullHttpResponse
                            p.addLast(new ChunkedWriteHandler());//大文件支持
                            p.addLast(new CorsHandler(corsConfig));
//                            p.addLast(new HttpServerExpectContinueHandler());

                            p.addLast(group, new HttpRequestHandler());
                        }
                    });

            Channel ch = b.bind(PORT).sync().channel();

            System.out.println("Open your web browser and navigate to " + "http" + "://127.0.0.1:" + PORT + '/');

            ch.closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
