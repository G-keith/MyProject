package com.springboot.common.utils;

import java.util.List;

import static java.util.Collections.swap;

/**
 * 集合排序工具类
 * @author keith
 * @date 2018-09-03
 */
public class SortUtils {

    /**
     * 快速排序
     * @param list 集合
     * @param low 0
     * @param high list.size()-1
     * @return 排序后的集合
     */
    public static List quickSort(List<Integer> list, int low, int high) {
        if (low < high) {
            int lt = low;
            int i = low + 1;
            int gt = high + 1;
            while (i < gt) {
                if (list.get(i) < list.get(lt)) {
                    swap(list, i++, lt++);
                } else if (list.get(i) > list.get(lt)) {
                    swap(list, i, --gt);
                } else {
                    i++;
                }
            }
            quickSort(list, low, lt);
            quickSort(list, gt, high);
        }
        return list;
    }
}
