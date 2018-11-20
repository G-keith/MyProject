package com.springboot.common.utils;

import cn.hutool.core.util.NumberUtil;

/**
 * 数字工具类
 * @author keith
 * @date 2018-09-17
 */
public class NumberUtils {

    /**
     * 生成不重复随机数 根据给定的最小数字和最大数字，以及随机数的个数，产生指定的不重复的数组
     *
     * @param begin 开始数
     * @param end   结束数
     * @param size  长度
     * @return 指定长度的数组
     */
    public static int[] getRandomString(int begin, int end, int size) {
        return NumberUtil.generateRandomNumber(begin, end, size);
    }

    /**
     * 判断字符串是否为数字
     *
     * @param str 字符串
     * @return
     */
    public boolean isNumber(String str) {
        return NumberUtil.isNumber(str);
    }
}
