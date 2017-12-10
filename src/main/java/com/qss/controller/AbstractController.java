package com.qss.controller;

import com.qss.common.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yuanaiqing on 10/12/17.
 */
public class AbstractController {
    @Autowired
    protected MessageUtil messageUtil;
}
