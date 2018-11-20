package com.springboot.modules.utils;

import java.util.*;

/**
 * 替换敏感词
 * @author keith
 * @date 2018-10-13
 */
public class ReplaceWorld {
    /**
     *初始化字符串
     */
    private static StringBuilder replaceAll;
    private static String replceStr = "*";
    private static int replceSize = 500;
    /**
     * 包含的敏感词列表，过滤掉重复项
     */
    public static Set<String> sensitiveWordSet;
    /**
     * 包含的敏感词列表，包括重复项，统计次数
     */
    private static List<String> sensitiveWordList;

    /**
     * 替换字符串中的敏感词
     *  @param str  替换之前词汇
     *  @param world  敏感词集合
     *  @return     替换之后词汇
     */
    public static String replaceWorld(String str,List<String> world) {
        str= str.replace(" ", "");
        replaceAll = new StringBuilder(replceSize);
        for(int x=0;x < replceSize;x++){
            replaceAll.append(replceStr);
        }
        /**
         * 包含的敏感词列表，过滤掉重复项
         */
        Set<String> sensitiveWordSet = new HashSet<String>();
        sensitiveWordList= new ArrayList<>();
        StringBuilder buffer = new StringBuilder(str);
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>(world.size());
        String temp;
        for(int x = 0; x < world.size();x++)
        {
            temp = world.get(x);
            int findIndexSize = 0;
            for(int start = -1;(start=buffer.indexOf(temp,findIndexSize)) > -1;){
                //从已找到的后面开始找
                findIndexSize = start+temp.length();
                //起始位置
                Integer mapStart = hash.get(start);
                //满足1个，即可更新map
                if(mapStart == null || (mapStart != null && findIndexSize > mapStart))
                {
                    hash.put(start, findIndexSize);
                }
            }
        }
        Collection<Integer> values = hash.keySet();
        for(Integer startIndex : values)
        {
            Integer endIndex = hash.get(startIndex);
            //获取敏感词，并加入列表，用来统计数量
            String sensitive = buffer.substring(startIndex, endIndex);
            //添加敏感词到集合
            if (!sensitive.contains("*")) {
                sensitiveWordSet.add(sensitive);
                sensitiveWordList.add(sensitive);
            }
            buffer.replace(startIndex, endIndex, replaceAll.substring(0,endIndex-startIndex));
        }
        hash.clear();
        return buffer.toString();
    }
}
