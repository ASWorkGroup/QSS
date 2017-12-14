package com.qss.service.m00_user;

import com.qss.model.m00_user.SysUserInfo;
import com.qss.model.m00_user.UserListQueryCondition;

import java.util.List;

/**
 * Created by yuanaiqing on 13/12/17.
 */
public interface UserService {
    List<SysUserInfo> getUserList(UserListQueryCondition condition);
}
