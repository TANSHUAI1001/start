package com.tan.start.dao;

import com.tan.start.entity.SysPermissionResources;
import com.tan.start.entity.SysPermissionResourcesExample;
import com.tan.start.entity.SysPermissionResourcesKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysPermissionResourcesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission_resources
     *
     * @mbg.generated Wed Apr 10 15:27:59 CST 2019
     */
    long countByExample(SysPermissionResourcesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission_resources
     *
     * @mbg.generated Wed Apr 10 15:27:59 CST 2019
     */
    int deleteByExample(SysPermissionResourcesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission_resources
     *
     * @mbg.generated Wed Apr 10 15:27:59 CST 2019
     */
    int deleteByPrimaryKey(SysPermissionResourcesKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission_resources
     *
     * @mbg.generated Wed Apr 10 15:27:59 CST 2019
     */
    int insert(SysPermissionResources record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission_resources
     *
     * @mbg.generated Wed Apr 10 15:27:59 CST 2019
     */
    int insertSelective(SysPermissionResources record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission_resources
     *
     * @mbg.generated Wed Apr 10 15:27:59 CST 2019
     */
    List<SysPermissionResources> selectByExample(SysPermissionResourcesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission_resources
     *
     * @mbg.generated Wed Apr 10 15:27:59 CST 2019
     */
    SysPermissionResources selectByPrimaryKey(SysPermissionResourcesKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission_resources
     *
     * @mbg.generated Wed Apr 10 15:27:59 CST 2019
     */
    int updateByExampleSelective(@Param("record") SysPermissionResources record, @Param("example") SysPermissionResourcesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission_resources
     *
     * @mbg.generated Wed Apr 10 15:27:59 CST 2019
     */
    int updateByExample(@Param("record") SysPermissionResources record, @Param("example") SysPermissionResourcesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission_resources
     *
     * @mbg.generated Wed Apr 10 15:27:59 CST 2019
     */
    int updateByPrimaryKeySelective(SysPermissionResources record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission_resources
     *
     * @mbg.generated Wed Apr 10 15:27:59 CST 2019
     */
    int updateByPrimaryKey(SysPermissionResources record);
}