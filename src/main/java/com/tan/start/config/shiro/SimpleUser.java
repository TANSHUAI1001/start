package com.tan.start.config.shiro;

import com.tan.start.entity.SysUser;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

public class SimpleUser extends SysUser implements Serializable{

    private static final long serialVersionUID = 7755782634183804089L;
    private Logger log = LoggerFactory.getLogger(SimpleUser.class);

    private Long id;
    private transient String password;

    // 只有父类对象本身就是用子类new出来的时候, 才可以在将来被强制转换为子类对象.
    public SimpleUser() {

    }

    public SimpleUser(SysUser user) {
        try {
            BeanUtils.copyProperties(this,user);
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
}
