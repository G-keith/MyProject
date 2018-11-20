package com.springboot.common.utils;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.util.Map;

/**
 * Json工具类
 * @author keith
 * @date 2018-09-21
 */
public class JSONUtils {

    /**
     * json字符串转Json对象
     * @param jsonStr json字符串
     * @return json对象
     */
    public static JSONObject strToJson(String jsonStr){
        return JSONUtil.parseObj(jsonStr);
    }

    /**
     * JavaBen对象转Json对象
     * @param o JavaBen对象
     * @return  Json对象
     */
    public static JSONObject objectToJson(Object o){
        return JSONUtil.parseObj(o);
    }

    /**
     * map转Json对象
     * @param map map集合
     * @return Json对象
     */
    public static JSONObject mapToJson(Map<String,Object> map){
        return JSONUtil.parseFromMap(map);
    }

    /**
     * xml字符串转Json对象
     * @param xmlStr  xml字符串
     * @return Json对象
     */
    public static JSONObject xmlToJson(String xmlStr){
        return JSONUtil.parseFromXml(xmlStr);
    }

    /**
     * Json对象转json字符串
     * @param jsonStr json对象
     * @return json字符串
     */
    public static String jsonToStr(JSONObject jsonStr){
        return JSONUtil.toJsonStr(jsonStr);
    }

    /**
     * Json对象转JavaBen对象
     * @param o Json对象
     * @return  JavaBen对象
     */
    public static Object jsonToObject(JSONObject jsonObject,Object o){
        return JSONUtil.toBean(jsonObject,o.getClass());
    }

    /**
     * Json对象转xml字符串
     * @param jsonObject  Json对象
     * @return xml字符串
     */
    public static String xmlToJson(JSONObject jsonObject){
        return JSONUtil.toXmlStr(jsonObject);
    }

    /**
     * json字符串转Json数组
     * @param jsonStr json数组
     * @return json数组
     */
    public static JSONArray strToJsonArray(String jsonStr){
        return JSONUtil.parseArray(jsonStr);
    }
}
