//package com.jiawa.wiki.utils;
//
//
//
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.stereotype.Component;
// import org.springframework.web.servlet.HandlerInterceptor;
// import org.springframework.web.servlet.ModelAndView;
//
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
//
// /**
//  * 拦截器：Spring框架特有的，常用于登录校验，权限校验，请求日志打印 /login
//  */
// @Component
// public class LogInterceptor implements HandlerInterceptor {
//
//     private static final Logger LOG = LoggerFactory.getLogger(LogInterceptor.class);
//
//     @Override
//     public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//         // 打印请求信息
//         LOG.info("------------- LogInterceptor -------------");
//         LOG.info("Request url: {} {}", request.getRequestURL().toString(), request.getMethod());
//         LOG.info("Remote url: {}", request.getRemoteAddr());
//
//         long startTime = System.currentTimeMillis();
//         request.setAttribute("requestStartTime", startTime);
//         return true;
//     }
//
//     @Override
//     public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//         long startTime = (Long) request.getAttribute("requestStartTime");
//         LOG.info("------------- LogInterceptor  Time：{} ms -------------", System.currentTimeMillis() - startTime);
//     }
// }