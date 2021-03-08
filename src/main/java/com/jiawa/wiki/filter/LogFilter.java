 package com.jiawa.wiki.filter;

 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.stereotype.Component;

 import javax.servlet.*;
 import javax.servlet.http.HttpServletRequest;
 import java.io.IOException;

 @Component
 public class LogFilter implements Filter {

     private static final Logger LOG = LoggerFactory.getLogger(LogFilter.class);

     @Override
     public void init(FilterConfig filterConfig) throws ServletException {

     }

     @Override
     public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
         // 打印请求信息
         HttpServletRequest request = (HttpServletRequest) servletRequest;
         LOG.info("------------- LogFilter starts -------------");
         LOG.info("Request url: {} {}", request.getRequestURL().toString(), request.getMethod());
         LOG.info("Remote url: {}", request.getRemoteAddr());

         long startTime = System.currentTimeMillis();
         filterChain.doFilter(servletRequest, servletResponse);
         LOG.info("------------- LogFilter ends time：{} ms -------------", System.currentTimeMillis() - startTime);
     }
 }