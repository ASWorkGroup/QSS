package com.qss.service.impl;

import com.qss.dao.AuthDao;
import com.qss.model.LoginFormInfo;
import com.qss.model.SysUserInfo;
import com.qss.service.IAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

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
