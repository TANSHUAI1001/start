package com.tan.start.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tan.start.utils.RSAUtils;

import java.util.Date;

public class SysUserVO{
    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    private String email;
    private String telephone;
    private String salt;
    @JsonIgnore
    private Integer singleRole;
    private Date createTime;
    private Integer state;

    public SysUserVO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getSingleRole() {
        return singleRole;
    }

    public void setSingleRole(Integer singleRole) {
        this.singleRole = singleRole;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
