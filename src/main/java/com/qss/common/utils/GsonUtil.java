package com.qss.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by YuanAiQing on 2017/12/6.
 */
public class GsonUtil {
    public final static Gson gson = new GsonBuilder().enableComplexMapKeySerialization().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
}
