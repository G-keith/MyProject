package com.springboot.common.utils;

import cn.hutool.core.lang.ObjectId;
import cn.hutool.core.util.IdUtil;

/**
 * 唯一ID工具类
 *
 * @author keith
 * @date 2018-09-18
 */
public class IdUtils {

    /**
     * 生成的是不带-的UUID
     * @return uuid
     */
    public String getUUID() {
        return IdUtil.simpleUUID();
    }

    /**
     * 生成数据库唯一Id主键
     * @return id
     */
    public String getObjectId(){
        return ObjectId.next();
    }
}
