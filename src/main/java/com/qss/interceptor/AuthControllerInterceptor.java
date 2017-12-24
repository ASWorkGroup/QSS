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
public class AuthControllerInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception{
        try {

            String actionUrl=request.getContextPath() + "/c0001/login.do";
            String url=request.getParameter("url");
            if (url!=null && !url.equals("null") && url.length()!=0){
                actionUrl += "?url=" + url;
            }

            request.setAttribute("form1_action", actionUrl);
            return true;

        }
        catch(Exception ex1)
        {
            throw ex1;
        }
    }
}
