package com.springboot.modules.project.businesscardmapper;

import com.springboot.modules.project.domain.Bussinessinfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author keith
 * @date 2018-10-14
 */
@Repository
public interface BussinessinfoMapper {

    /**
     * 查询所有员工信息
     * @return 所有员工信息集合
     */
    List<Bussinessinfo> selectAll();
}
