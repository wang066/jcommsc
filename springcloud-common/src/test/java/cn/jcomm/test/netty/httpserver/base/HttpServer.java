package cn.jcomm.test.netty.httpserver.base;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.cors.CorsConfig;
import io.netty.handler.codec.http.cors.CorsConfigBuilder;
import io.netty.handler.codec.http.cors.CorsHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * An HTTP server that sends back the content of the received HTTP request
 * in a pretty plaintext form.
 */
public final class HttpServer {

    public static final int PORT = 8080;

    public static void main(String[] args) throws Exception {

        start(PORT, new HttpUrlRouteManager().add("/", new HttpUrlRoute() {
            @Override
            public Object execute(FullHttpRequest request) {
                return 1;
            }
        }));
    }

    public static void start(int port, HttpUrlRouteManager manager) throws Exception {

        // Configure the server.
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        EventExecutorGroup group = new DefaultEventExecutorGroup(32);

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.option(ChannelOption.SO_BACKLOG, 1024);
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            CorsConfig corsConfig = CorsConfigBuilder.forAnyOrigin().build();
                            //业务线程
                            ChannelPipeline p = ch.pipeline();
                            //空闲处理
                            ch.pipeline().addLast(new IdleStateHandler(40, 50, 100));
                            p.addLast(new HttpServerCodec());
                            //把多个消息转换为一个单一的FullHttpRequest或是FullHttpResponse
                            p.addLast(new HttpObjectAggregator(65536));
                            //大文件支持
                            p.addLast(new ChunkedWriteHandler());
                            p.addLast(new CorsHandler(corsConfig));
                            //pipeline.addLast(group, "handler", new MyBusinessLogicHandler());
                            p.addLast(group, new HttpServerHandler(manager));
                        }
                    });

            Channel ch = b.bind(port).sync().channel();

            System.out.println("Open your web browser and navigate to " + "http" + "://127.0.0.1:" + port + '/');

            ch.closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
