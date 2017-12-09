package com.qss.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

/**
 * Created by yuanaiqing on 9/12/17.
 */

@Component
public class MessageUtil {

    @Autowired
    @Qualifier("messageSource")
    private MessageSource messages;

    private String getMessage(String key, String ... messages) {
        String message = this.messages.getMessage(key, messages, null);//todo local
        return message;
    }
}
