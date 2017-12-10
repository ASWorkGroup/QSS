package com.qss.service.c00_login.impl;

import com.qss.dao.c00_login.AuthDao;
import com.qss.model.c00_login.LoginFormInfo;
import com.qss.model.m00_user.SysUserInfo;
import com.qss.service.c00_login.IAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by YuanAiQing on 2017/12/6.
 */
@Component
public class Auth implements IAuth {
    @Autowired
    private AuthDao authDao;

    public SysUserInfo validateUser(LoginFormInfo loginFormInfo) {
        SysUserInfo sysUserInfo = authDao.getUserInfo(loginFormInfo);
        return sysUserInfo;
    }
}
