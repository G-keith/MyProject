package com.springboot.common.utils;


import cn.hutool.core.date.DateUtil;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 * @author keith
 * @version 2014-4-15
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
	
	private static String[] parsePatterns = {
		"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM", 
		"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
		"yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 */
	public static String getDate() {
		return DateUtil.today();
	}
	
	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}
	
	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String formatDate(Date date, Object... pattern) {
		String formatDate = null;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString());
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}
	
	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String formatDateTime(Date date) {
		return DateUtil.formatDateTime(date);
	}

	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 */
	public static String getTime() {
		return DateUtil.formatTime(new Date());
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTime() {
		return DateUtil.formatDateTime(new Date());
	}

	/**
	 * 得到当前年份 格式（yyyy）
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}

	/**
	 * 得到当天字符串 格式（dd）
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}

	/**
	 * 得到当前星期字符串 格式（E）星期几
	 */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}
	
	/**
	 * 日期型字符串转化为日期 格式
	 * { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", 
	 *   "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm",
	 *   "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
	 */
	public static Date parseDate(Object str) {
		if (str == null){
			return null;
		}
		try {
			return parseDate(str.toString(), parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 获取过去的天数
	 * @param date
	 * @return
	 */
	@SuppressWarnings("AlibabaAvoidNewDateGetTime")
	public static long pastDays(Date date) {
		long t = System.currentTimeMillis()-date.getTime();
		return t/(24*60*60*1000);
	}

	/**
	 * 获取过去的小时
	 * @param date
	 * @return
	 */
	public static long pastHour(Date date) {
		long t =System.currentTimeMillis()-date.getTime();
		return t/(60*60*1000);
	}
	
	/**
	 * 获取过去的分钟
	 * @param date
	 * @return
	 */
	public static long pastMinutes(Date date) {
		long t = System.currentTimeMillis()-date.getTime();
		return t/(60*1000);
	}
	
	/**
	 * 转换为时间（天,时:分:秒.毫秒）
	 * @param timeMillis
	 * @return
	 */
    public static String formatDateTime(long timeMillis){
		long day = timeMillis/(24*60*60*1000);
		long hour = (timeMillis/(60*60*1000)-day*24);
		long min = ((timeMillis/(60*1000))-day*24*60-hour*60);
		long s = (timeMillis/1000-day*24*60*60-hour*60*60-min*60);
		long sss = (timeMillis-day*24*60*60*1000-hour*60*60*1000-min*60*1000-s*1000);
		return (day>0?day+",":"")+hour+":"+min+":"+s+"."+sss;
    }
	
	/**
	 * 获取两个日期之间的天数
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
	public static double getDistanceOfTwoDate(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
	}
	
	/**
	 * 获取指定日期之间的日期集合
	 * @param beginDate 开始日期  格式  yyyy-MM-dd
	 * @param endDate 结束日期 格式yyyy-MM-dd
	 * @param format 返回的日期格式
	 * @return List<String> 返回日期集合
	 */
	public static List<String> getDateList(String beginDate,String endDate,String format) {
		List<String> dateList = new ArrayList<>();
		Date begin = parseDate(beginDate);
		Date end = parseDate(endDate);
		//加入开始时间
		dateList.add(formatDate(begin,format));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(begin);    
		while(end.after(begin))
		{
			//获取后一天
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			begin = calendar.getTime();
			dateList.add(formatDate(begin,format)); 
		}
		String temp = formatDate(end,format);
		//加次判断是为了防止开始时间等于结束时间时重复添加
		if(!dateList.contains(temp))
        {
            dateList.add(temp);
        }
	    return dateList;
	}
	
	/**
	 * 指定日期 加days 天/月/年
	 * @param dateStr 日期格式的字符串  yyyy-MM-dd 或者 yyyy-MM-dd HH:mm:ss
	 * @param days 添加的天数、月数、年数，如果为负数，则表示获取指定日期之前的日期
	 * @param addType 1：天   2：月   3：年
	 * @param format 返回的日期格式
	 * @return String 日期格式的字符创
	 */
	public static String getDateAdd(String dateStr,int days,int addType,String format) {
		Date date = parseDate(dateStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);   
        if(addType == 3) {
			//年份添加days
			calendar.add(Calendar.YEAR, days);
		} else if(addType == 2) {
			//月份添加days
			calendar.add(Calendar.MONTH, days);
		} else if(addType == 1) {
			//日 添加days
			calendar.add(Calendar.DAY_OF_MONTH, days);
		}
		return formatDate(calendar.getTime(),format);
	}
	
	/**     
	 * 当前时间加上指定日期
	 *  @param date 时间
	 *  @param day 天数
	 *  @return   Date    
	 */ 
	public static Date getDateAdd(Date date,int day) {
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    // add方法中的第二个参数n中，正数表示该日期后n天，负数表示该日期的前n天
	    calendar.add(Calendar.DATE, day);
	    Date dateNew = calendar.getTime();
	    return dateNew;
	}
}
