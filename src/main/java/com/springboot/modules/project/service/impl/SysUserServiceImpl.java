package com.springboot.modules.project.service.impl;

import com.springboot.common.datasource.DS;
import com.springboot.common.datasource.DataSourceContextHolder;
import com.springboot.common.utils.DateUtils;
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

    @Autowired
    private SysUserMapper sysUserMapper;

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
    @DS()
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
    @DS()
    public List<SysUser> selectAll() {
        System.out.println(DataSourceContextHolder.getDB());
        List<SysUser> sysUsers;
        try{
            sysUsers= sysUserMapper.selectAll();
            if(sysUsers.size()!=0){
                for(SysUser sysUser:sysUsers){
                    sysUser.setCtrateTime(DateUtils.formatDateTime(sysUser.getCreateDate()));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("查询所有用户信息失败");
        }
        return sysUsers;
    }
}
