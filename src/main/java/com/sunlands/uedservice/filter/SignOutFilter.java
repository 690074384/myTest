package com.sunlands.uedservice.filter;/**
 * @Author : lvpenghui
 * @Description :
 * @Date : Created in 18:50 2017/12/7
 * @ModifiedBy :
 */


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author : lvpenghui
 * @Description : 
 * @Date : Created in 18:50 2017/12/7
 * @ModifiedBy :
 *
 */
@WebFilter(filterName = "signOutFilter",urlPatterns = "/*")
public class SignOutFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
