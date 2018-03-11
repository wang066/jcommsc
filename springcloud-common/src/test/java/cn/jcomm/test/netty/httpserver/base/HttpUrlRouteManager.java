package cn.jcomm.test.netty.httpserver.base;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jowang on 2017/5/23 0023.
 */
public class HttpUrlRouteManager {
    private Map<String, HttpUrlRoute> map = new HashMap<>();

    public HttpUrlRouteManager add(String url, HttpUrlRoute httpUrlRoute) {
        if (map.containsKey(url)) {
            throw new RuntimeException("map has key:" + url);
        }

        map.put(url.toLowerCase(), httpUrlRoute);
        return this;
    }

    public HttpUrlRoute get(String url) {
        return map.get(url.toLowerCase());
    }
}
