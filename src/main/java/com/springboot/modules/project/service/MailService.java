package com.springboot.modules.project.service;

public interface MailService {

    /**
     * 发送邮件
     * @param account 账号
     * @param subject 主题
     * @param content 内容
     */
    void sendSimpleMail(String account, String subject, String content);
}
