package com.qss.common.page;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.lang.Nullable;

import java.util.Properties;

/**
 * Created by yuanaiqing on 26/1/18.
 */
public class PageContainerManagerBean implements FactoryBean<PageContainer>, InitializingBean {
    private final String DEFAULT_PROPERTY_KEY_CONFIG_FILE_PATH = "classpath:pageContainer.properties";
    public static final String PROPERTY_KEY_CONFIG_FILE_PATH = "config_file_path";

    private String configFilePath;
    private PageContainer pageContainer;

    public PageContainerManagerBean(Properties properties){
        if (properties.contains(PROPERTY_KEY_CONFIG_FILE_PATH)){
            configFilePath = properties.getProperty(PROPERTY_KEY_CONFIG_FILE_PATH);
        }
        else {
            configFilePath = DEFAULT_PROPERTY_KEY_CONFIG_FILE_PATH;
        }
    }

    @Nullable
    public PageContainer getObject() throws Exception {
        return pageContainer;
    }

    @Nullable
    public Class<?> getObjectType() {
        return PageContainer.class;
    }

    public boolean isSingleton() {
        return true;
    }

    public void afterPropertiesSet() throws Exception {
        pageContainer = new PageContainerImpl();
    }
}
