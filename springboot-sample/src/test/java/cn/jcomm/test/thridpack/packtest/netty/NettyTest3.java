package cn.jcomm.test.thridpack.packtest.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.StringUtil;

/**
 * Created by 066 on 2017/3/20 0020.
 * 请求返回时间
 */
public class NettyTest3 {
    private static class TimeServer {
        public static void main(String[] args) throws InterruptedException {
            EventLoopGroup bossGroup = new NioEventLoopGroup();
            EventLoopGroup workerGroup = new NioEventLoopGroup();

            ServerBootstrap b = new ServerBootstrap()
                    .group(bossGroup, workerGroup)
//                    .channel(NioServerSocketChannel.class)
//                    .option(ChannelOption.SO_BACKLOG, 1024)        //设置tcp缓冲区
//                    .option(ChannelOption.SO_SNDBUF, 32 * 1024)    //设置发送缓冲大小
//                    .option(ChannelOption.SO_RCVBUF, 32 * 1024)    //这是接收缓冲大小
//                    .option(ChannelOption.SO_KEEPALIVE, true)    //保持连接
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
//                            ByteBuf buf = Unpooled.copiedBuffer("$_".getBytes());
                            ch.pipeline().addLast(new ChannelHandlerAdapter() {

                            });
                        }
                    });

            ChannelFuture channelFuture = b.bind(8080).sync();

            channelFuture.channel().closeFuture().sync();

            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();

        }
    }


    private static class TimeClient {
        public static void main(String[] args) throws InterruptedException {
            EventLoopGroup workerGroup = new NioEventLoopGroup();
            Bootstrap b = new Bootstrap()
                    .group(workerGroup)
                    .channel(SocketChannel.class)
                    .handler(new SimpleChannelInboundHandler<ByteBuf>() {
                        @Override
                        protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
                            try {
                                String response = StringUtil.toHexString(ByteBufUtil.getBytes(msg));
                                System.out.println("Client: " + response);
                            } finally {
                                ReferenceCountUtil.release(msg);
                            }
                        }
                    });
            ChannelFuture channelFuture = b.connect("127.0.0.1", 8080).sync();

            channelFuture.channel().writeAndFlush(Unpooled.wrappedBuffer("bbbb$_".getBytes()));
            channelFuture.channel().writeAndFlush(Unpooled.wrappedBuffer("cccc$_".getBytes()));


            //等待客户端端口关闭
            channelFuture.channel().closeFuture().sync();
            workerGroup.shutdownGracefully();

        }
    }

}
