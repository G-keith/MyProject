package com.springboot.modules.common;

import com.springboot.common.utils.PropertiesUtil;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author keith
 * @date 2018-09-04
 */
@Data
public class ConfigurationFileHelper {

    @Autowired
    private PropertiesUtil propertiesUtil;

    /**
     * 短信发送模板消息相关
     */
    public static final String APPKEY = "appKey";
    public static final String TEMPLATEA = "templateA";
    public static final String TEMPLATEB = "templateB";
    public static final String TEMPLATEC = "templateC";
    public static final String TEMPLATED = "templateD";
    public static final String TEMPLATEE = "templateE";
    public static String appKey ;
    public static String templateA ;
    public static String templateB ;
    public static String templateC ;
    public static String templateD ;
    public static String templateE ;

    /**
     * 获取图片路径
     */
    public static final String SAVEFILEPATH="saveFilePath";
    public static String saveFilePath;

    /**
     * 获取系统域名
     */
    public static final String SYSPATH="sysPath";
    public static String sysPath;
    /**
     * 初始化
     */
    static {
        initSource();
    }
    private static final void initSource(){
        //短信相关
        appKey = PropertiesUtil.getValue(APPKEY);
        templateA = PropertiesUtil.getValue(TEMPLATEA);
        templateB = PropertiesUtil.getValue(TEMPLATEB);
        templateC = PropertiesUtil.getValue(TEMPLATEC);
        templateD = PropertiesUtil.getValue(TEMPLATED);
        templateD = PropertiesUtil.getValue(TEMPLATEE);
        //图片路径
        saveFilePath=PropertiesUtil.getValue(SAVEFILEPATH);
        //系统域名
        sysPath=PropertiesUtil.getValue(SYSPATH);
    }
    public static synchronized String getAppkey() {
        return appKey;
    }
    public static synchronized String getTemplateA() {
        return templateA;
    }
    public static synchronized String getTemplateB() {
        return templateB;
    }
    public static synchronized String getTemplateC() {
        return templateC;
    }
    public static synchronized String getTemplateD() {
        return templateD;
    }
    public static synchronized String getTemplateE() {
        return templateE;
    }
    public static String getSaveFilePath() {
        return saveFilePath;
    }
    public static String getSysPath() {
        return sysPath;
    }
}
