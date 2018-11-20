package com.springboot.modules.project.controller;

import com.springboot.modules.project.service.MailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author keith
 * @date 2018-08-16
 */
@Api(value = "邮件服务",description = "发送邮件操作")
@Controller
@RequestMapping(value = "/mail")
public class MailController {

    @Autowired
    private MailService mailService;

    @ApiOperation(value = "发送邮件",notes = "发送邮件操作")
    @RequestMapping(value = "sendMail",method = RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form",name = "account",value = "对方邮箱账号",required = true),
            @ApiImplicitParam(paramType = "form",name = "subject",value = "邮件主题",required = true),
            @ApiImplicitParam(paramType = "form",name = "content",value = "邮件内容",required = true)
    })
    public void sendMail(@RequestParam("account") String account,@RequestParam("subject") String subject,@RequestParam("content") String content){
        mailService.sendSimpleMail(account,subject,content);
    }
}
