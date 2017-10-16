package cn.jcomm.test.thridpack.packtest.netty.letty.rte;

import cn.jcomm.test.thridpack.packtest.netty.letty.hdl.RequestParamHandler;
import io.netty.handler.codec.http.HttpMethod;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by jowang on 2017/5/22 0022.
 */
public class UrlRoute {
    private Class clazz;
    /**
     * 队列 待调用
     */
    private Queue<Method> method;

    private String urlPattern;

    /**
     * 参数名称 - 参数类型
     */
    private Map<String, Class> parameter;

    private Set<HttpMethod> httpMethod;

    private RequestParamHandler requestParamHandler;
}
