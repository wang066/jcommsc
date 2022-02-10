package com.example.springboot_dubbo.exchange;

import java.nio.channels.Channel;

public interface ChannelHandler {

    void connect(Channel channel);

    void disconnected(Channel channel);

    void channelRead(Channel channel, Object msg);

    void channelWrite(Channel channel, Object msg);

    void caught(Channel channel, Throwable e);
}
