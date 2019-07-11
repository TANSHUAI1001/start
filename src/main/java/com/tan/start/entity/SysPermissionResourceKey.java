package com.tan.start.entity;

import java.io.Serializable;

public class SysPermissionResourceKey implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_permission_resource.permission_id
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    private Integer permissionId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_permission_resource.resource_id
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    private Long resourceId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_permission_resource
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_permission_resource.permission_id
     *
     * @return the value of sys_permission_resource.permission_id
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    public Integer getPermissionId() {
        return permissionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_permission_resource.permission_id
     *
     * @param permissionId the value for sys_permission_resource.permission_id
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_permission_resource.resource_id
     *
     * @return the value of sys_permission_resource.resource_id
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    public Long getResourceId() {
        return resourceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_permission_resource.resource_id
     *
     * @param resourceId the value for sys_permission_resource.resource_id
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission_resource
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", permissionId=").append(permissionId);
        sb.append(", resourceId=").append(resourceId);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission_resource
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysPermissionResourceKey other = (SysPermissionResourceKey) that;
        return (this.getPermissionId() == null ? other.getPermissionId() == null : this.getPermissionId().equals(other.getPermissionId()))
            && (this.getResourceId() == null ? other.getResourceId() == null : this.getResourceId().equals(other.getResourceId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission_resource
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPermissionId() == null) ? 0 : getPermissionId().hashCode());
        result = prime * result + ((getResourceId() == null) ? 0 : getResourceId().hashCode());
        return result;
    }
}