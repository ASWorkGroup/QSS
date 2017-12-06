package com.qss.service.impl;

import com.qss.service.IAuthToken;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by YuanAiQing on 2017/12/6.
 */
@Component
public class AuthToken implements IAuthToken {
    public String getTokenKey() {
        return UUID.randomUUID().toString();
    }
}
