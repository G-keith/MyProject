package com.springboot.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计字符串中每个字符出现次数
 * @author keith
 * @date 2018-09-08
 */
public class CountLetterTimesUtil {

    /**
     * 统计字符串中字母出现次数
     * @param string 字符串
     * @return 每个字母出现次数
     */
    public Map<Character,Integer> count(String string){
        HashMap<Character ,Integer> map=new HashMap(16);
        char[] keys = string.toCharArray();
        for(char key:keys){
            if(!map.containsKey(key)) {
                map.put(key, 1);
            }else {
                map.put(key, map.get(key)+1);
            }
        }
        return map;
    }
}
