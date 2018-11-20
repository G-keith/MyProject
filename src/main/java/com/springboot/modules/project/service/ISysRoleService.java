package com.springboot.modules.project.service;

import java.util.Set;

/**
 * @author keith
 * @date 2018-09-04
 */
public interface ISysRoleService {

    Set<String> findRoleNameByUserId(Integer Id);
}
