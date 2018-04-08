package cn.jcomm.handler;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author: jowang
 * @date: 2018/4/8 0008 15:25
 * @description:
 */
@WebFilter
@Slf4j
public class WebLogFilter  implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
log.info("WebLogFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("WebLogFilter dofilter");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override public void destroy() {
        log.info("WebLogFilter destroy");
    }
}
