package com.qss.common.page;

import com.qss.dao.MasterCommonDao;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import sun.jvm.hotspot.debugger.Page;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by yuanaiqing on 28/1/18.
 */
public class PageDaoImpl implements PageDao {

    @Autowired
    private MasterCommonDao masterCommonDao;

    @Override
    public List<Map<String, Object>> selectMasterItemList(@NotNull String table, @NotNull List<String> itemColumns, @NotNull Map<String, String> conditions) {
        if (itemColumns.size() == 0){
            throw new PageDefineConfigParsingException("item columns is needed.");
        }
        if (conditions.size() == 0){
            throw new PageDefineConfigParsingException("conditions are needed.");
        }

        StringBuilder builder = new StringBuilder("SELECT ");
        itemColumns.forEach((column) -> {
            builder.append(" ");
            builder.append(column);
            builder.append(",");
        });
        StringBuilder newBuilder = builder.replace(builder.length()-1, builder.length(), "");
        newBuilder.append(" FROM ");
        newBuilder.append(table);

        newBuilder.append(" WHERE 1=1 ");
        conditions.forEach((k, v) -> {
            if (v != null && v.length() != 0) {
                newBuilder.append(" AND ");
                newBuilder.append(k);
                newBuilder.append(" = '");
                newBuilder.append(v);
                newBuilder.append("' ");
            }
        });

        return masterCommonDao.selectMasterItemList(newBuilder.toString());
    }
}
