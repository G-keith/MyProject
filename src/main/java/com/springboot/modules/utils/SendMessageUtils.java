package com.springboot.modules.utils;

import com.springboot.modules.common.SendMessageApi;

import java.util.Random;

/**
 * 短信发送工具
 *
 * @author keith
 * @date 2018-09-04
 */
public class SendMessageUtils {

    /**
     * 发送短信接口
     *
     * @param phone    手机号
     * @param template 模板
     * @return 是否成功（参照对应的枚举类）
     */
    public int sendMessage(String phone, String template) {
        return SendMessageApi.getSendMessage(phone, template, codeNumber());
    }

    /**
     * 随机生成4位纯数字验证码
     *
     * @return String 验证码
     */
    public static String codeNumber() {
        String code = "";
        int[] num = new int[4];
        for (int i = 0; i < num.length; i++) {
            int index = new Random().nextInt(9) + 1;
            num[i] = index;
        }
        for (int n = 0; n < num.length; n++) {
            code = code + (num[n]);
        }
        return code;
    }
}
