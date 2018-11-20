package com.springboot.modules.project.service.impl;

import com.springboot.modules.project.service.ISysRoleService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author keith
 * @date 2018-09-04
 */
@Service("iSysRoleService")
public class SysRoleServiceImpl implements ISysRoleService {
    @Override
    public Set<String> findRoleNameByUserId(Integer Id) {
        return null;
    }
}
