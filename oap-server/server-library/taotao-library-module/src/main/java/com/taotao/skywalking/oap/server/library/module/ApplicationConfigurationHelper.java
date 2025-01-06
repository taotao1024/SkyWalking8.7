package com.taotao.skywalking.oap.server.library.module;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.oap.server.library.module.ApplicationConfiguration;
import org.apache.skywalking.oap.server.library.module.ModuleConfig;
import org.apache.skywalking.oap.server.starter.config.ApplicationConfigLoader;

import java.lang.reflect.Field;
import java.util.Enumeration;
import java.util.Properties;

/**
 * 用于测试时 获取对应的 Module,Provider,Configuration.
 */
@Getter
@Slf4j
public class ApplicationConfigurationHelper extends ApplicationConfigLoader {

    private final ApplicationConfiguration applicationConfiguration;

    public ApplicationConfigurationHelper() throws Exception {
        applicationConfiguration = load();
    }

    public <T extends ModuleConfig> T setConfigBean(String module, String provider, T config) {
        Properties providerConfig = applicationConfiguration
                .getModuleConfiguration(module)
                .getProviderConfiguration(provider);
        Class<? extends ModuleConfig> destClass = config.getClass();
        Enumeration<?> propertyNames = providerConfig.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String propertyName = (String) propertyNames.nextElement();
            try {
                Field field = getDeclaredField(destClass, propertyName);
                field.setAccessible(true);
                field.set(config, providerConfig.get(propertyName));
            } catch (Exception ex) {
                log.error(propertyName + " setting is not supported in " + config);
            }
        }
        return config;
    }

    private Field getDeclaredField(Class<?> destClass, String fieldName) throws NoSuchFieldException {
        if (destClass != null) {
            Field[] fields = destClass.getDeclaredFields();
            for (Field field : fields) {
                if (field.getName().equals(fieldName)) {
                    return field;
                }
            }
            return getDeclaredField(destClass.getSuperclass(), fieldName);
        }
        throw new NoSuchFieldException();
    }
}
