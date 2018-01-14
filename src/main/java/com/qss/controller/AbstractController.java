package com.qss.controller;

import com.qss.common.utils.MessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by yuanaiqing on 10/12/17.
 */
public class AbstractController{
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected MessageUtil messageUtil;

    @Autowired
    private  HttpServletRequest request;

    protected String getMessage(String key) throws Exception{

        return messageUtil.getMessage(key, RequestContextUtils.getLocale(request));
    }
}
