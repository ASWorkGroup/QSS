package com.qss.service.c00_login;

import com.qss.model.c00_login.LoginFormInfo;
import com.qss.model.m00_user.SysUserInfo;

/**
 * Created by YuanAiQing on 2017/12/6.
 */
public interface IAuth {
    SysUserInfo validateUser(LoginFormInfo loginFormInfo);
}
