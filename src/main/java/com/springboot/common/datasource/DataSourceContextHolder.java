package com.springboot.common.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author keith
 * @date 2018-10-14
 */
public class DataSourceContextHolder {
    private static final Logger log = LoggerFactory.getLogger(DataSourceContextHolder.class);

    /**
     * 默认数据源
     */
    static final String DEFAULT_DS = "test";

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    /**
     * 设置数据源名
     * @param dbType 数据源名称
     */
    static void setDB(String dbType) {
        log.debug("切换到{}数据源", dbType);
        contextHolder.set(dbType);
    }

    /**
     * 获取数据源名
     * @return
     */
    public static String getDB() {
        return (contextHolder.get());
    }

    /**
     * 清除数据源名
     */
    static void clearDB() {
        contextHolder.remove();
    }

}
