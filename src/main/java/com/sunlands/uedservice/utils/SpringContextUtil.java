package com.sunlands.uedservice.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @Author : lvpenghui
 * @Description :
 * @Date : Created in 15:39 2017/12/6
 * @ModifiedBy :
 */
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }

    public static boolean containsBean(String beanName) {
        return applicationContext.containsBean(beanName);
    }
}
