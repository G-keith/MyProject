package com.springboot.modules.utils;

import static com.springboot.modules.common.ConfigurationFileHelper.sysPath;

/**
 * 图片重组
 * @author keith
 * @date 2018-10-13
 */
public class RebuildPic {
    /**
     * 图片重组（拼接系统域名）
     * @param picPath 图片路径
     * @return 拼接后的图片路径
     */
    public static String rebuildPic(String picPath) {
        if (picPath != null && !"".equals(picPath)) {
            String[] imgList = picPath.split("\\|");
            // 判断是否为多张图片
            if (imgList.length > 1) {
                // 多张
                StringBuilder newPicture = new StringBuilder();
                for (String anImgList : imgList) {
                    if (anImgList != null && !"".equals(anImgList)) {
                        newPicture.append("|");
                        // 判断是否已经拼接了域名
                        if (!anImgList.startsWith(sysPath)) {
                            newPicture.append(sysPath).append(anImgList);
                        } else {
                            newPicture.append(anImgList);
                        }
                    }
                }
                picPath = newPicture.toString();
            } else {
                    // 单张
                    // 判断是否已经拼接了域名
                    if (!picPath.startsWith(sysPath)) {
                        picPath = sysPath + picPath;
                    }
            }
        }
        return picPath;
    }
}
