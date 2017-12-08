package com.qss.auth;

import com.qss.consts.AuthConsts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by YuanAiQing on 2017/12/6.
 */
public class AuthFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private  FilterConfig config;
    private ServletContext servletContext;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        logger.info("do filter");
        HttpServletRequest request=(HttpServletRequest) req;
        HttpServletResponse response=(HttpServletResponse) resp;
        String uri=request.getRequestURI();//从应用开始的部分地址
        if(uri.toLowerCase().contains("login")){
            //无需登录，放行
            chain.doFilter(request, response);
        }else{//不存在的访问地址留待其他机制去处理！特定部件只管特定事情！
            Object user=request.getSession().getAttribute(AuthConsts.AuthTokenKey);
            if(user==null){
                //检查带过来的Cookie,前提是上次登录设置了该Cookie
                Cookie[] cookies = request.getCookies();
                String authToken = null;
                if(cookies != null) {
                    for(int i = 0; i < cookies.length; i ++) {
                        String cookieName = cookies[i].getName();
                        if(AuthConsts.AuthTokenKey.equals(cookieName)) {
                            authToken = cookies[i].getValue();
                            break;
                        }
                    }
                }
                if(authToken!=null){
                    //已登录，放行
                    chain.doFilter(request, response);
                }else{//没登录也没有上次登录时效信息
                    String requestUrl = ((HttpServletRequest) req).getRequestURL().toString();
                    ((HttpServletResponse) resp).sendRedirect("/auth/login.do?url=" + requestUrl);
                }
            }else{
                //已登录，放行
                chain.doFilter(request, response);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {
        this.config = config;
        this.servletContext = config.getServletContext();
    }

}
