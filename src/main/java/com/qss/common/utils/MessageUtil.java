package com.qss.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * Created by yuanaiqing on 9/12/17.
 */
@Component
public class MessageUtil {

    @Autowired
    @Qualifier("messageSource")
    private MessageSource messageSource;

    public String getMessage(String key, Locale locale, String ... messages) {
        String message = this.messageSource.getMessage(key, messages, locale);
        return message;
    }
}
