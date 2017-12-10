package com.qss.dao.m00_user;

import com.qss.model.c00_login.LoginFormInfo;
import com.qss.model.m00_user.SysUserInfo;

/**
 * Created by yuanaiqing on 2/12/17.
 */

public interface UserDao {
    SysUserInfo getUserInfo(LoginFormInfo loginFormInfo);
}
