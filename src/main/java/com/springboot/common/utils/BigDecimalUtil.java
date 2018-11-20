package com.springboot.common.utils;

import java.math.BigDecimal;

/**
 * @author GEMI
 * @date 2018/3/15/0015 17:17
 */
public class BigDecimalUtil {


    public static BigDecimal add(double v1,double v2){
        return new BigDecimal(Double.toString(v1)).add(new BigDecimal(Double.toString(v2)));
    }

    public static BigDecimal subtract(double v1,double v2){
        return new BigDecimal(Double.toString(v1)).subtract(new BigDecimal(Double.toString(v2)));
    }

    public static BigDecimal multiply(double v1,double v2){
        return new BigDecimal(Double.toString(v1)).multiply(new BigDecimal(Double.toString(v2)));
    }

    public static BigDecimal divide(double v1,double v2){
        //四舍五入。保留两位有效小数
        return new BigDecimal(Double.toString(v1)).divide(new BigDecimal(Double.toString(v2)),2,BigDecimal.ROUND_HALF_UP);
    }
}
