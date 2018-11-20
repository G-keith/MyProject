package com.springboot.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 获取配置文件工具类
 *
 * @author Keith
 */
public class PropertiesUtil {
    private static Properties prop = new Properties();
    private final static String fileName = "application.properties";

    static {
        try {
            prop.load(new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName), "UTF-8"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        String value = prop.getProperty(key.trim());
        if (StringUtils.isBlank(value)) {
            return null;
        }
        return value.trim();
    }

    public static String getValue(String key, String defaultValue) {
        String value = prop.getProperty(key.trim());
        if (StringUtils.isBlank(value)) {
            value = defaultValue;
        }
        return value.trim();
    }

    public static void setValue(String key, String value) {
        /**
         * 将文件加载到内存中，在内存中修改key对应的value值，再将文件保存
         */
        try {
            prop.setProperty(key, value);
            FileOutputStream fos = new FileOutputStream(fileName);
            prop.store(fos, null);
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
