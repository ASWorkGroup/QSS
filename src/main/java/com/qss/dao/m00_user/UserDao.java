package com.qss.dao.m00_user;

import com.qss.model.c00_login.LoginFormInfo;
import com.qss.model.m00_user.SysUserInfo;
import com.qss.model.m00_user.UserListQueryCondition;

import java.util.List;

/**
 * Created by yuanaiqing on 2/12/17.
 */

public interface UserDao {
    List<SysUserInfo> getUserInfo(UserListQueryCondition condition);
}
