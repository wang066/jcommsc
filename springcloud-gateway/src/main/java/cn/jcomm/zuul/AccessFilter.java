package cn.jcomm.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Created by jowang on 2017/8/11 0011.
 */
@Slf4j
public class AccessFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String value = request.getHeader(name);
            log.info(name + "=" + value);
        }

        //acessToken
        Object accessToken = request.getParameter("accessToken");
        if (accessToken != null) {
            //根据url 判断
            //1、api 找到所属页面

            //2、page 直接判断权限
        } else {

        }
        return null;
    }
}
