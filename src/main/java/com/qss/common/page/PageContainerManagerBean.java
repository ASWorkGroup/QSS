package com.qss.common.page;

import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.lang.Nullable;

import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by yuanaiqing on 26/1/18.
 */
public class PageContainerManagerBean implements FactoryBean<PageContainer>, InitializingBean {
    private final String DEFAULT_PROPERTY_KEY_CONFIG_FILE_PATH = "classpath:defines.xml";
    public static final String PROPERTY_KEY_CONFIG_FILE_PATH = "config_file_path";

    private String configFilePath;
    private PageContainer pageContainer;

    public PageContainerManagerBean(){
        configFilePath = DEFAULT_PROPERTY_KEY_CONFIG_FILE_PATH;
    }

    public PageContainerManagerBean(Properties properties){
        configFilePath = properties.getProperty(PROPERTY_KEY_CONFIG_FILE_PATH);
        if (configFilePath == null){
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

        String _configFilePath = configFilePath;
        if (configFilePath.startsWith("classpath")) {
            URL url = this.getClass().getClassLoader().getResource(configFilePath.replace("classpath:", ""));
            _configFilePath = url.getFile();
        }

        Configuration configuration = new Configuration(pageContainer, _configFilePath);
        configuration.parse();
    }
}
