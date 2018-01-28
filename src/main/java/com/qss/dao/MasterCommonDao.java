package com.qss.dao;

import com.qss.model.m00_user.SysUserInfo;
import com.qss.model.m00_user.UserListQueryCondition;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by yuanaiqing on 2/12/17.
 */

public interface MasterCommonDao {
    List<Map<String, Object>> selectMasterItemList(@Param(value="sqlStr") String sqlStr);
}
