package com.qss.common.page;

/**
 * Created by yuanaiqing on 26/1/18.
 */
public interface PageContainer{
    <T> T getDefine(String pageId, String zone, Class<T> clazz);
    <T> void registerDefine(String pageId, String zone, T define);
}
