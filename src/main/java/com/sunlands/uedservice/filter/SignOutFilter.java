package com.sunlands.uedservice.filter;


import org.jasig.cas.client.util.AssertionThreadLocalFilter;
import org.jasig.cas.client.util.HttpServletRequestWrapperFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.DelegatingFilterProxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : lvpenghui
 * @Description : 
 * @Date : Created in 18:50 2017/12/7
 * @ModifiedBy :
 *
 */
@Configuration
@Component
public class SignOutFilter {

    @Bean
    public FilterRegistrationBean cASSingleSignOutFilterRegistrationBean() {
        FilterRegistrationBean cASSingleSignOutFilter = new FilterRegistrationBean();
        cASSingleSignOutFilter.setFilter(new DelegatingFilterProxy());
        Map<String, String> initParameters = new HashMap<>(10);
        initParameters.put("targetFilterLifecycle", "true");
        initParameters.put("targetBeanName", "singleSignOutFilter");
        cASSingleSignOutFilter.setInitParameters(initParameters);
        cASSingleSignOutFilter.setOrder(1);
        List<String> urlPatterns = new ArrayList<>();
        urlPatterns.add("/*");
        cASSingleSignOutFilter.setUrlPatterns(urlPatterns);
        return cASSingleSignOutFilter;
    }

    @Bean
    public FilterRegistrationBean cASAuthenticationFilterRegistrationBean() {
        FilterRegistrationBean cASAuthenticationFilter = new FilterRegistrationBean();
        cASAuthenticationFilter.setFilter(new DelegatingFilterProxy());
        Map<String, String> initParameters = new HashMap<>(10);
        initParameters.put("targetFilterLifecycle", "true");
        initParameters.put("targetBeanName", "authenticationFilter");
        cASAuthenticationFilter.setInitParameters(initParameters);
        cASAuthenticationFilter.setOrder(2);
        List<String> urlPatterns = new ArrayList<>();
        urlPatterns.add("/*");
        cASAuthenticationFilter.setUrlPatterns(urlPatterns);
        return cASAuthenticationFilter;
    }

    @Bean
    public FilterRegistrationBean cASValidationFilterRegistrationBean() {
        FilterRegistrationBean cASValidationFilter = new FilterRegistrationBean();
        cASValidationFilter.setFilter(new DelegatingFilterProxy());
        Map<String, String> initParameters = new HashMap<>(10);
        initParameters.put("targetFilterLifecycle", "true");
        initParameters.put("targetBeanName", "ticketValidationFilter");
        cASValidationFilter.setInitParameters(initParameters);
        cASValidationFilter.setOrder(5);
        List<String> urlPatterns = new ArrayList<>();
        urlPatterns.add("/*");
        cASValidationFilter.setUrlPatterns(urlPatterns);
        return cASValidationFilter;
    }

    @Bean
    public FilterRegistrationBean cASHttpServletRequestWrapperFilterRegistrationBean() {
        FilterRegistrationBean cASHttpServletRequestWrapperFilter = new FilterRegistrationBean();
        cASHttpServletRequestWrapperFilter.setFilter(new HttpServletRequestWrapperFilter());
        cASHttpServletRequestWrapperFilter.setOrder(6);
        List<String> urlPatterns = new ArrayList<>();
        urlPatterns.add("/*");
        cASHttpServletRequestWrapperFilter.setUrlPatterns(urlPatterns);
        return cASHttpServletRequestWrapperFilter;
    }

    @Bean
    public FilterRegistrationBean casAssertionThreadLocalFilter(){
        FilterRegistrationBean authenticationFilter = new FilterRegistrationBean();
        authenticationFilter.setFilter(new AssertionThreadLocalFilter());
        authenticationFilter.setOrder(7);
        List<String> urlPatterns = new ArrayList<>();
        urlPatterns.add("/*");
        authenticationFilter.setUrlPatterns(urlPatterns);
        return authenticationFilter;
    }
}
