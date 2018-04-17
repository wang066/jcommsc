package cn.jcomm.handler;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author: jowang
 * @date: 2018/4/8 0008 15:36
 * @description:
 */
@WebListener
@Slf4j
public class WebServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
      log.info("InitServletContextListener contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        log.info("InitServletContextListener contextDestroyed");
    }
}
