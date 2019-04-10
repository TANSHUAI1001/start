package com.tan.start.dao;

import com.tan.start.entity.SysResources;
import com.tan.start.entity.SysResourcesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysResourcesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbg.generated Wed Apr 10 15:27:59 CST 2019
     */
    long countByExample(SysResourcesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbg.generated Wed Apr 10 15:27:59 CST 2019
     */
    int deleteByExample(SysResourcesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbg.generated Wed Apr 10 15:27:59 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbg.generated Wed Apr 10 15:27:59 CST 2019
     */
    int insert(SysResources record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbg.generated Wed Apr 10 15:27:59 CST 2019
     */
    int insertSelective(SysResources record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbg.generated Wed Apr 10 15:27:59 CST 2019
     */
    List<SysResources> selectByExample(SysResourcesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbg.generated Wed Apr 10 15:27:59 CST 2019
     */
    SysResources selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbg.generated Wed Apr 10 15:27:59 CST 2019
     */
    int updateByExampleSelective(@Param("record") SysResources record, @Param("example") SysResourcesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbg.generated Wed Apr 10 15:27:59 CST 2019
     */
    int updateByExample(@Param("record") SysResources record, @Param("example") SysResourcesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbg.generated Wed Apr 10 15:27:59 CST 2019
     */
    int updateByPrimaryKeySelective(SysResources record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resources
     *
     * @mbg.generated Wed Apr 10 15:27:59 CST 2019
     */
    int updateByPrimaryKey(SysResources record);
}