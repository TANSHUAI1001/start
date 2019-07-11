package com.tan.start.entity;

import java.io.Serializable;
import java.util.Date;

public class SysUser implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.id
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.username
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.password
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.email
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.telephone
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    private String telephone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.avatar
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    private String avatar;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.salt
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    private String salt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.single_role
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    private Integer singleRole;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.message
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    private Integer message;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user. notification
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    private Integer notification;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.task
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    private Integer task;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.create_time
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.state
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    private Integer state;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_user
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.id
     *
     * @return the value of sys_user.id
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.id
     *
     * @param id the value for sys_user.id
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.username
     *
     * @return the value of sys_user.username
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.username
     *
     * @param username the value for sys_user.username
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.password
     *
     * @return the value of sys_user.password
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.password
     *
     * @param password the value for sys_user.password
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.email
     *
     * @return the value of sys_user.email
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.email
     *
     * @param email the value for sys_user.email
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.telephone
     *
     * @return the value of sys_user.telephone
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.telephone
     *
     * @param telephone the value for sys_user.telephone
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.avatar
     *
     * @return the value of sys_user.avatar
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.avatar
     *
     * @param avatar the value for sys_user.avatar
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.salt
     *
     * @return the value of sys_user.salt
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    public String getSalt() {
        return salt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.salt
     *
     * @param salt the value for sys_user.salt
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.single_role
     *
     * @return the value of sys_user.single_role
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    public Integer getSingleRole() {
        return singleRole;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.single_role
     *
     * @param singleRole the value for sys_user.single_role
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    public void setSingleRole(Integer singleRole) {
        this.singleRole = singleRole;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.message
     *
     * @return the value of sys_user.message
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    public Integer getMessage() {
        return message;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.message
     *
     * @param message the value for sys_user.message
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    public void setMessage(Integer message) {
        this.message = message;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user. notification
     *
     * @return the value of sys_user. notification
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    public Integer getNotification() {
        return notification;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user. notification
     *
     * @param notification the value for sys_user. notification
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    public void setNotification(Integer notification) {
        this.notification = notification;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.task
     *
     * @return the value of sys_user.task
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    public Integer getTask() {
        return task;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.task
     *
     * @param task the value for sys_user.task
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    public void setTask(Integer task) {
        this.task = task;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.create_time
     *
     * @return the value of sys_user.create_time
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.create_time
     *
     * @param createTime the value for sys_user.create_time
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.state
     *
     * @return the value of sys_user.state
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.state
     *
     * @param state the value for sys_user.state
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", email=").append(email);
        sb.append(", telephone=").append(telephone);
        sb.append(", avatar=").append(avatar);
        sb.append(", salt=").append(salt);
        sb.append(", singleRole=").append(singleRole);
        sb.append(", message=").append(message);
        sb.append(", notification=").append(notification);
        sb.append(", task=").append(task);
        sb.append(", createTime=").append(createTime);
        sb.append(", state=").append(state);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
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
        SysUser other = (SysUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getTelephone() == null ? other.getTelephone() == null : this.getTelephone().equals(other.getTelephone()))
            && (this.getAvatar() == null ? other.getAvatar() == null : this.getAvatar().equals(other.getAvatar()))
            && (this.getSalt() == null ? other.getSalt() == null : this.getSalt().equals(other.getSalt()))
            && (this.getSingleRole() == null ? other.getSingleRole() == null : this.getSingleRole().equals(other.getSingleRole()))
            && (this.getMessage() == null ? other.getMessage() == null : this.getMessage().equals(other.getMessage()))
            && (this.getNotification() == null ? other.getNotification() == null : this.getNotification().equals(other.getNotification()))
            && (this.getTask() == null ? other.getTask() == null : this.getTask().equals(other.getTask()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbg.generated Thu Jul 11 16:22:36 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getTelephone() == null) ? 0 : getTelephone().hashCode());
        result = prime * result + ((getAvatar() == null) ? 0 : getAvatar().hashCode());
        result = prime * result + ((getSalt() == null) ? 0 : getSalt().hashCode());
        result = prime * result + ((getSingleRole() == null) ? 0 : getSingleRole().hashCode());
        result = prime * result + ((getMessage() == null) ? 0 : getMessage().hashCode());
        result = prime * result + ((getNotification() == null) ? 0 : getNotification().hashCode());
        result = prime * result + ((getTask() == null) ? 0 : getTask().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        return result;
    }
}