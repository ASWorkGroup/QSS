package com.qss.common.page;

import com.qss.common.utils.GsonUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by yuanaiqing on 26/1/18.
 */
public class PageContainerImpl implements PageContainer {

    //Map<pageId, Map<condition, content>>
    private Map<String, Map<String, String>> defines = new HashMap<String, Map<String, String>>();

    public <T> T getDefine(String pageId, String zone, Class<T> clazz) {
        Map<String, String> zoneDefine = defines.get(pageId);
        if (zoneDefine == null) {
            return null;
        }
        String _define = zoneDefine.get(zone);
        if (_define == null) {
            return null;
        }
        T define = GsonUtil.gson.fromJson(_define, clazz);
        return define;
    }

    public <T> void registerDefine(String pageId, String zone, T define) {
        String _define = GsonUtil.gson.toJson(define);
        Map<String, String> zoneDefine = new HashMap<String, String>();
        zoneDefine.put(zone, _define);
        defines.put(pageId, zoneDefine);
    }
}
