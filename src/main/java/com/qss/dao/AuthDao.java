package com.qss.dao;

import com.qss.model.LoginFormInfo;
import com.qss.model.SampleModel;
import com.qss.model.SysUserInfo;

import java.util.List;

/**
 * Created by yuanaiqing on 2/12/17.
 */

public interface AuthDao {
    SysUserInfo getUserInfo(LoginFormInfo loginFormInfo);
}
