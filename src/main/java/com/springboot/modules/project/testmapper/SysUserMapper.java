package com.springboot.modules.project.testmapper;

import com.springboot.modules.project.domain.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author keith
 * @date 2018-10-08
 */
@Repository
public interface SysUserMapper {

    /**
     * 根据主键删除员工信息
     * @param id 主键Id
     * @return  0失败；1成功
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 选择性插入用户信息
     * @param record 用户信息
     * @return 0失败；1成功
     */
    int insertSelective(SysUser record);

    /**
     * 根据主键查询用户信息
     * @param id 主键Id
     * @return 用户信息
     */
    SysUser selectByPrimaryKey(Integer id);

    /**
     * 更新员工信息
     * @param record 员工信息
     * @return 0失败；1成功
     */
    int updateByPrimaryKeySelective(SysUser record);

    /**
     * 通过用户名密码查询账户信息
     * @param loginName 用户名
     * @return 用户信息
     */
    SysUser getUserByLoginName(@Param("loginName") String loginName);

    /**
     * 查询所有员工信息
     * @return 所有员工信息集合
     */
    List<SysUser> selectAll();
}