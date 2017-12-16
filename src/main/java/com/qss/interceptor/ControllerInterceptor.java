package com.qss.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yuanaiqing on 16/12/17.
 */
public class ControllerInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception{
        try {
            String uri = request.getRequestURI();
            if (uri == null || uri.toLowerCase().equals("null")){
                throw new RuntimeException("Request URI is invalid. Respected: /{}/{}.do Actual is null");
            }

            int firstIndexOfSlash = uri.indexOf('/');
            int lastIndexOfSlash = uri.lastIndexOf('/');
            if (firstIndexOfSlash<0 || lastIndexOfSlash<0 || firstIndexOfSlash >= lastIndexOfSlash) {
                throw new RuntimeException("Request URI is invalid. Respected: /{}/{}.do Actual: " + uri);
            }

            String rootURI = uri.substring(0,lastIndexOfSlash);
            String action = rootURI + "/post.do";
            request.setAttribute("form1_action", action);
            return true;

        }
        catch(Exception ex1)
        {
            throw ex1;
        }
    }
}
