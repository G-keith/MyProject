package com.springboot.common.utils;

import cn.hutool.core.util.IdcardUtil;

/**
 * 身份证操作工具类
 * @author keith
 * @date 2018-09-17
 */
public class IdcardUtils {

    /**
     * 验证省份中号码是否正确
     *
     * @param card 身份证号码
     * @return
     */
    public static boolean isValidCard(String card) {
        return IdcardUtil.isValidCard(card);
    }

    /**
     * @param card
     * @return
     */
    public static String convert15To18(String card) {
        //身份证长度
        int cardLength = 18;
        if (card.length() == cardLength) {
            return card;
        } else {
            return IdcardUtil.convert15To18(card);
        }
    }

    /**
     * 根据身份证号码获取年龄
     * @param card 身份证号码
     * @return 年龄
     */
    public static int getAgeByIdCard(String card) {
        return IdcardUtil.getAgeByIdCard(card);
    }

    /**
     *根据身份证号码获取生日年
     * @param card 身份证号码
     * @return 年份
     */
    public static int getYearByIdCard(String card){
        return IdcardUtil.getYearByIdCard(card);
    }
    /**
     *根据身份证号码获取生日月
     * @param card 身份证号码
     * @return 月份
     */
    public static int getMonthByIdCard(String card){
        return IdcardUtil.getMonthByIdCard(card);
    }
    /**
     *根据身份证号码获取生日天
     * @param card 身份证号码
     * @return 天
     */
    public static int getDayByIdCard(String card){
        return IdcardUtil.getDayByIdCard(card);
    }

    /**
     * 根据身份证号码获取性别
     * @param card 身份证号码
     * @return 性别(M-男，F-女)
     */
    public static String getGenderByIdCard(String card){
        String gender;
        if(IdcardUtil.getGenderByIdCard(card)==1){
            gender="M";
        }else{
            gender="F";
        }
        return gender;
    }

    /**
     * 根据身份证号码获取省份
     * @param card 身份证号码
     * @return 省份
     */
    public static String getProvinceByIdCard(String card){
        return IdcardUtil.getProvinceByIdCard(card);
    }

}
