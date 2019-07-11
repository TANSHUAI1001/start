package com.tan.start.dao;

import com.tan.start.entity.SysRolePermission;
import com.tan.start.entity.SysRolePermissionExample;
import com.tan.start.entity.SysRolePermissionKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRolePermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    long countByExample(SysRolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    int deleteByExample(SysRolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    int deleteByPrimaryKey(SysRolePermissionKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    int insert(SysRolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    int insertSelective(SysRolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    List<SysRolePermission> selectByExample(SysRolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    SysRolePermission selectByPrimaryKey(SysRolePermissionKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    int updateByExampleSelective(@Param("record") SysRolePermission record, @Param("example") SysRolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    int updateByExample(@Param("record") SysRolePermission record, @Param("example") SysRolePermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    int updateByPrimaryKeySelective(SysRolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    int updateByPrimaryKey(SysRolePermission record);
}