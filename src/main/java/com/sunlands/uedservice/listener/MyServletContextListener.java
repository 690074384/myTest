package com.sunlands.uedservice.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebListener;

/**
 * @Author : lvpenghui
 * @Description :
 * @Date : Created in 18:04 2017/12/7
 * @ModifiedBy :
 */

@WebListener
@WebInitParam(name = "contextConfigLocation",value = "classpath:casFilter.xml")
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println(servletContextEvent.getServletContext().getServerInfo());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
