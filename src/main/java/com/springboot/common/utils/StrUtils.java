package com.springboot.common.utils;

import cn.hutool.core.codec.Base32;
import cn.hutool.core.codec.Base64;
import cn.hutool.core.text.StrBuilder;
import cn.hutool.core.util.StrUtil;

/**
 * 字符串工具类
 *
 * @author keith
 * @date 2018-09-17
 */
public class StrUtils {

    /**
     * 去除字符串前缀
     *
     * @param strName    字符串名
     * @param prefixName 前缀名
     * @return 去除后字符串名称
     */
    public static String removePrefix(String strName, String prefixName) {
        return StrUtil.removePrefix(strName, prefixName);
    }

    /**
     * 去除字符串后缀
     *
     * @param strName    字符串名
     * @param prefixName 后缀名
     * @return 去除后字符串名称
     */
    public static String removeSuffix(String strName, String prefixName) {
        return StrUtil.removeSuffix(strName, prefixName);
    }

    /**
     * 判断字符串是否为空
     *
     * @param strs 字符串(可批量传入，有一个不为空则返回true)
     * @return 有空的就返回true
     */
    public static boolean hasBlank(String... strs) {
        return StrUtil.hasBlank(strs);
    }

    /**
     * 截取字符串
     *
     * @param str   字符串
     * @param begin 开始位置
     * @param end   结束位置
     * @return 截取后的字符串
     */
    public static String subString(String str, int begin, int end) {
        return StrUtil.sub(str, begin, end);
    }

    /**
     * Base64编码
     * @param str 字符串
     * @return 编码后的字符串
     */
    public static String base64Encode(String str) {
        return Base64.encode(str);
    }
    /**
     * Base32编码
     * @param str 字符串
     * @return 编码后的字符串
     */
    public static String base32Encode(String str) {
        return Base32.encode(str);
    }
    /**
     * Base64解码
     * @param encode Base64编码字符串
     * @return 解码后的字符串
     */
    public static String base64Decode(String encode) {
        return Base64.decodeStr(encode);
    }
    /**
     * Base32解码
     * @param encode Base32编码字符串
     * @return 解码后的字符串
     */
    public static String base32Decode(String encode) {
        return Base32.decodeStr(encode);
    }

    /**
     * 字符串拼接
     * @param strs 需要拼接的字符串(可传多个)
     * @return 拼接后的字符串
     */
    public static String stringbuilder(String... strs){
        StrBuilder builder = StrBuilder.create();
        for(String str:strs){
            builder.append(str);
            builder.reset();
        }
        return builder.toString();
    }

}
