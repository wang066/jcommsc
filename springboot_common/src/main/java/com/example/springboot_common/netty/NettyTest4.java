package com.example.springboot_common.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: jowang
 * @date: 2019-01-24 15:02
 * @description:
 */
public class NettyTest4 {
}

class Server {
    public static void main(String[] args) {
        //EventLoopGroup boss = new NioEventLoopGroup();
        //EventLoopGroup work = new NioEventLoopGroup();
        //ServerBootstrap bootstrap = new ServerBootstrap()
        //        .group(boss, work)
        //        .channel(NioServerSocketChannel.class)
        //        .option(ChannelOption.SO_BACKLOG,1024*1024)
        //        .option(ChannelOption.TCP_NODELAY,true)
        //        .childHandler();
    }
}

class Client {

}

@ChannelHandler.Sharable
class NettyServerHandler extends SimpleChannelInboundHandler<ByteBuf> {
    private static final Logger log = LoggerFactory.getLogger(NettyServerHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

    }


    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {

    }

}