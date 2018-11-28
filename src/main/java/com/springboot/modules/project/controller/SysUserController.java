package com.springboot.modules.project.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.springboot.common.page.PageVO;
import com.springboot.common.utils.MD5Util;
import com.springboot.modules.common.ServerResponse;
import com.springboot.modules.project.domain.SysUser;
import com.springboot.modules.project.service.ISysUserService;
import com.springboot.modules.project.service.impl.SysUserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author keith
 * @date 2018-10-08
 */
@Api(value = "用户账户服务", description = "用户账户操作")
@Controller
@RequestMapping(value = "/sysUser")
public class SysUserController {


    private final ISysUserService iSysUserService;

    @Autowired
    public SysUserController(ISysUserService iSysUserService) {
        this.iSysUserService = iSysUserService;
    }

    @ApiOperation(value = "插入用户信息", notes = "插入用户信息")
    @PostMapping(value = "insertUserInfo")
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "loginName", value = "登录名", required = true),
            @ApiImplicitParam(paramType = "form", name = "password", value = "密码", required = true),
            @ApiImplicitParam(paramType = "form", name = "name", value = "姓名", required = true)
    })
    public ServerResponse<Integer> insertUserInfo(String loginName,  String password, String name) {
        SysUser sysUser = new SysUser();
        sysUser.setLoginName(loginName);
        sysUser.setPassword(MD5Util.md5EncodeUtf8(password));
        sysUser.setName(name);
        sysUser.setCreateDate(new Date());
        int result=  iSysUserService.insertUserInfo(sysUser);
        if(result>0){
            return ServerResponse.createBySuccess(result);
        }else{
            return ServerResponse.createByError();
        }
    }

    @ApiOperation(value = "查询所有员工信息", notes = "查询所有员工信息，分页展示")
    @PostMapping(value = "selectAll")
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "pageNum", value = "第几页",defaultValue = "1",dataType = "int"),
            @ApiImplicitParam(paramType = "form", name = "pageSize", value = "每页几条",defaultValue = "5",dataType = "int")
    })
    public ServerResponse<PageVO<SysUser>> selectAll(int pageNum, int pageSize){
        Page<SysUser> page = PageHelper.startPage(pageNum, pageSize);
        iSysUserService.selectAll();
        return ServerResponse.createBySuccess(PageVO.build(page));
    }
}
