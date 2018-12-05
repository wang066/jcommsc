package cn.jcomm.rpc.module.transport;

import cn.jcomm.rpc.core.domain.Request;
import cn.jcomm.rpc.core.domain.Response;

/**
 * @author: jowang
 * @date: 2018-11-30 11:14
 * @description:
 */
public interface Channel {

    ChannelConfig getChannelConfig();

    ChannelStatus getChannelStatus();

    /**
     * 状态机
     * @param channelStatus
     */
    void setChannelStatus(ChannelStatus channelStatus);

    Response request(Request request);
}
