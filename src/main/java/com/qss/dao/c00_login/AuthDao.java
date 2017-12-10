package com.qss.dao.c00_login;

import com.qss.model.c00_login.LoginFormInfo;
import com.qss.model.m00_user.SysUserInfo;

/**
 * Created by yuanaiqing on 2/12/17.
 */

public interface AuthDao {
    SysUserInfo getUserInfo(LoginFormInfo loginFormInfo);
}
