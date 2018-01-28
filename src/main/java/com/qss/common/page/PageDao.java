package com.qss.common.page;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by yuanaiqing on 28/1/18.
 */
public interface PageDao {
    List<Map<String, Object>> selectMasterItemList(String table, List<String> itemColumns, Map<String, String> conditions);
}
