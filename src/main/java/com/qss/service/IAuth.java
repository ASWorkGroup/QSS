package com.qss.service;

import com.qss.model.LoginFormInfo;
import com.qss.model.SysUserInfo;

/**
 * Created by YuanAiQing on 2017/12/6.
 */
public interface IAuth {
    SysUserInfo validateUser(LoginFormInfo loginFormInfo);
}
