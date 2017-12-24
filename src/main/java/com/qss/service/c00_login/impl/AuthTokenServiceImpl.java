package com.qss.service.c00_login.impl;

import com.qss.service.c00_login.AuthTokenService;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by YuanAiQing on 2017/12/6.
 */
@Component
public class AuthTokenServiceImpl implements AuthTokenService {
    public String getTokenKey() {
        return UUID.randomUUID().toString();
    }
}
