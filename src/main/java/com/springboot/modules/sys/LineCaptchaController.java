package com.springboot.modules.sys;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author keith
 * @date 2018-10-13
 */
@Api(value = "图形验证码", description = "返回给前端图形验证码操作")
@Controller
@RequestMapping(value = "/sys/faptcha")
public class LineCaptchaController {

    @ApiOperation(value = "图形验证码", notes = "返回给前端图形验证码")
    @ResponseBody
    @GetMapping(value = "lineCaptcha")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "width", value = "宽",defaultValue = "200",dataType = "int"),
            @ApiImplicitParam(paramType = "form", name = "height", value = "高",defaultValue = "100",dataType = "int")
    })
    public void lineCaptcha(HttpServletRequest request, HttpServletResponse response,int width,int height) {
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(width, height);
        HttpSession session = request.getSession();
        try {
            String randomString=lineCaptcha.getCode();
            session.setAttribute("randomCode", randomString);
            // 将内存中的图片通过流动形式输出到客户端
            lineCaptcha.write(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("生成图形验证码异常");
        }
    }
}
