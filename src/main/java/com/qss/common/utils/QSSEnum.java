package com.qss.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by yuanaiqing on 16/12/17.
 */
@Component
public class QSSEnum {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PropertiesFactoryBean props;

    @Autowired
    private MessageUtil messageUtil;

    public Map<String, String> getEnum(String key, Locale locale) {
        Map<String, String> map = new HashMap<String, String>();

        try {
            String entriesStr = props.getObject().getProperty(key);
            entriesStr = entriesStr.trim();
            String[] entryPairs = entriesStr.split(",");
            for(String entryPair : entryPairs) {
                String[] entryKVs = entryPair.split("=");
                String k = entryKVs[0];
                String v = entryKVs[1];
                String vWithLocales = messageUtil.getMessage(v, locale);

                map.put(k, vWithLocales);
            }
        }
        catch(Exception ex)
        {
            logger.error("getEnum failed. key: {}, locale: {}", key, locale.getCountry(), ex);
        }

        return map;
    }
}
