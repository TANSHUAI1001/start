package com.tan.start.dao;

import com.tan.start.entity.SysResource;
import com.tan.start.entity.SysResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysResourceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbg.generated Thu Jul 04 17:33:53 CST 2019
     */
    long countByExample(SysResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbg.generated Thu Jul 04 17:33:53 CST 2019
     */
    int deleteByExample(SysResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbg.generated Thu Jul 04 17:33:53 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbg.generated Thu Jul 04 17:33:53 CST 2019
     */
    int insert(SysResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbg.generated Thu Jul 04 17:33:53 CST 2019
     */
    int insertSelective(SysResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbg.generated Thu Jul 04 17:33:53 CST 2019
     */
    List<SysResource> selectByExample(SysResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbg.generated Thu Jul 04 17:33:53 CST 2019
     */
    SysResource selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbg.generated Thu Jul 04 17:33:53 CST 2019
     */
    int updateByExampleSelective(@Param("record") SysResource record, @Param("example") SysResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbg.generated Thu Jul 04 17:33:53 CST 2019
     */
    int updateByExample(@Param("record") SysResource record, @Param("example") SysResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbg.generated Thu Jul 04 17:33:53 CST 2019
     */
    int updateByPrimaryKeySelective(SysResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbg.generated Thu Jul 04 17:33:53 CST 2019
     */
    int updateByPrimaryKey(SysResource record);

    List<SysResource> selectSysResourceByRoleId(@Param("example")SysResourceExample example, @Param("roleId")Integer roleId);
}