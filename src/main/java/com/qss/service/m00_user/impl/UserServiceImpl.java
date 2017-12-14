package com.qss.service.m00_user.impl;

import com.qss.dao.m00_user.UserDao;
import com.qss.model.m00_user.SysUserInfo;
import com.qss.model.m00_user.UserListQueryCondition;
import com.qss.service.m00_user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by yuanaiqing on 13/12/17.
 */
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public List<SysUserInfo> getUserList(UserListQueryCondition condition) {
        return userDao.getUserInfo(condition);
    }
}