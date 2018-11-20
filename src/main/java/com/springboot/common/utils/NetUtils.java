package com.springboot.common.utils;

import org.omg.CORBA.UNKNOWN;

import javax.servlet.http.HttpServletRequest;

/**
 * 网络工具类
 * @author keith
 * @date 2018-09-17
 */
public class NetUtils {

    //ip地址判断
    private static final String UNKNOWN = "unknown";

    /**
     * 通过HttpServletRequest返回IP地址
     * @param request 请求
     * @return 当前请求的ip地址
     */
    public static String getIpAddr(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 ||UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
