package com.qss.common.page;

import com.google.gson.reflect.TypeToken;
import com.qss.common.utils.GsonUtil;

import java.lang.reflect.Type;
import java.util.*;

/**
 * Created by yuanaiqing on 26/1/18.
 */
public class PageContainerImpl implements PageContainer {

    //Map<pageId, Map<condition, content>>
    private Map<String, Map<String, List<String>>> defines = new HashMap<String, Map<String, List<String>>>();

    public <T> List<T> getDefine(String pageId, String zone, Class<T> clazz) {
        Map<String, List<String>> zoneDefine = defines.get(pageId);
        if (zoneDefine == null) {
            return null;
        }
        List<String> _defines = zoneDefine.get(zone);
        if (_defines == null) {
            return null;
        }
        List<T> defines = new ArrayList<T>();
        for (String _define : _defines) {
            T define = GsonUtil.gson.fromJson(_define, clazz);
            defines.add(define);
        }
        return defines;
    }

    public <T> void registerDefine(String pageId, String zone, T define) {
        String _define = GsonUtil.gson.toJson(define);

        Map<String, List<String>> zoneDefine = defines.get(pageId);
        if (zoneDefine == null) {
            zoneDefine = new HashMap<String, List<String>>();
            defines.put(pageId, zoneDefine);
        }

        List<String> list = zoneDefine.get(zone);
        if (list == null){
            list = new ArrayList<String>();
            zoneDefine.put(zone, list);
        }

        list.add(_define);
    }
}
