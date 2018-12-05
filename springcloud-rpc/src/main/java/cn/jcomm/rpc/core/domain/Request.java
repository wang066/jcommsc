package cn.jcomm.rpc.core.domain;

import lombok.Data;

/**
 * @author: jowang
 * @date: 2018-11-30 10:52
 * @description:
 */
@Data
public class Request {
    private String url;

    public Caller caller(){
        return null;
    }

    public Callee callee(){
        return null;
    }
}
