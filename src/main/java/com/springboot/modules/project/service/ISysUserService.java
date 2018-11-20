package com.springboot.modules.project.service;

import com.springboot.modules.project.domain.SysUser;

import java.util.List;
import java.util.Set;

/**
 * @author keith
 * @date 2018-09-04
 */
public interface ISysUserService {

    /**
     * 通过用户名密码查询账户信息
     * @param loginName 用户名
     * @return 用户信息
     */
    SysUser getUserByLoginName(String loginName);

    Set<String> findPermissionsByUserId(Integer Id);

    /**
     * 选择性插入用户信息
     * @param sysUser 用户信息
     * @return 0失败；1成功
     */
    int insertUserInfo(SysUser sysUser);

    /**
     * 查询所有员工信息
     * @return 所有员工信息集合
     */
    List<SysUser> selectAll();

}
