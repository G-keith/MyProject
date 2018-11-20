package com.springboot.common.utils;

import net.sf.json.JSONObject;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 * @author keith
 * @date 2018-07-10
 */
public class TransformationUtils {

    /**
     * 对象转JSON字符串
     * @param object 对象
     * @return
     */
    public static String objectToString(Object object){
        JSONObject json=JSONObject.fromObject(object);
        String strJson=json.toString();
        return strJson;
    }
}
