package com.qss.controller;

import com.qss.common.utils.MessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yuanaiqing on 10/12/17.
 */
public class AbstractController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected MessageUtil messageUtil;
}
