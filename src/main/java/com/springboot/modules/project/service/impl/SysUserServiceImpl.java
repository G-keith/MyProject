package com.springboot.modules.project.service.impl;

import com.springboot.modules.project.domain.SysUser;
import com.springboot.modules.project.service.ISysUserService;
import com.springboot.modules.project.testmapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * @author keith
 * @date 2018-09-04
 */
@Service("iSysUserService")
@Transactional(rollbackFor = Exception.class,readOnly = true)
public class SysUserServiceImpl implements ISysUserService {

    private final SysUserMapper sysUserMapper;

    @Autowired
    public SysUserServiceImpl(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

    @Override
    public SysUser getUserByLoginName(String loginName) {
        return sysUserMapper.getUserByLoginName(loginName);
    }

    @Override
    public Set<String> findPermissionsByUserId(Integer id) {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertUserInfo(SysUser sysUser) {
        int result;
        try {
            sysUserMapper.insertSelective(sysUser);
            result = sysUser.getId();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("插入用户信息失败");
        }
        return result;
    }

    @Override
    public List<SysUser> selectAll() {
        List<SysUser> sysUsers;
        try{
            sysUsers= sysUserMapper.selectAll();
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("查询所有用户信息失败");
        }
        sysUsers.add(new SysUser());
        return sysUsers;
    }
}
