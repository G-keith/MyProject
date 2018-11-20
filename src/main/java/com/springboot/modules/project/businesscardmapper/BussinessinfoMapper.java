package com.springboot.modules.project.businesscardmapper;

import com.springboot.modules.project.domain.Bussinessinfo;

import java.util.List;

/**
 * @author keith
 * @date 2018-10-14
 */
public interface BussinessinfoMapper {

    /**
     * 查询所有员工信息
     * @return 所有员工信息集合
     */
    List<Bussinessinfo> selectAll();
}
