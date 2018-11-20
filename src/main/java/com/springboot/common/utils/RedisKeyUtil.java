package com.springboot.common.utils;

/**
 * RedisKey键类
 * @author keith
 * @date 2018-07-23
 */
public class RedisKeyUtil {

    private static String SPLIT = ":";
    private static String BIZ_LIKE = "LIKE";

    /**
     * 产生key:如在newsId为2上的咨询点赞后会产生key: LIKE:2
     * @param entityId
     * @return
     */
    public static String getLikeKey(int entityId){
        return BIZ_LIKE + SPLIT +String.valueOf(entityId);
    }
}
