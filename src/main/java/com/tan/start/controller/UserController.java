package com.tan.start.controller;

import com.tan.start.constants.CommonConstant;
import com.tan.start.entity.SysUser;
import com.tan.start.service.SysUserService;
import com.tan.start.utils.ResponseContent;
import com.tan.start.utils.ShiroUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private SysUserService sysUserService;

    @RequestMapping(value = "/resetPassword",method = RequestMethod.POST)
    public ResponseContent resetPassword(String password,String newPassword){
        if(StringUtils.isBlank(password) || StringUtils.isBlank(newPassword)){
            return ResponseContent.fail(CommonConstant.PARAM_ERROR);
        }

        Subject subject = SecurityUtils.getSubject();
        SysUser user = (SysUser) subject.getPrincipal();

        String md5PasswordWithSalt = DigestUtils.md5DigestAsHex((password+user.getSalt()).getBytes());
        if(!md5PasswordWithSalt.equals(user.getPassword())){
            return ResponseContent.fail(CommonConstant.ORIGINAL_PASSWORD_ERROR);
        }
        String md5NewPasswordWithSalt = DigestUtils.md5DigestAsHex((newPassword+user.getSalt()).getBytes());
        int rows = sysUserService.updatePasswordById(user.getId(),md5NewPasswordWithSalt);
        if(rows == 1){
            SysUser userInfo = sysUserService.findById(user.getId());
            ShiroUtils.setUser(userInfo);
        }
        return ResponseContent.ok();
    }

    @RequestMapping(value = "/modify",method = RequestMethod.POST)
    public ResponseContent modifyUserInfo(String email){
        if(StringUtils.isBlank(email)){
            return ResponseContent.fail(CommonConstant.PARAM_ERROR);
        }

        Subject subject = SecurityUtils.getSubject();
        SysUser user = (SysUser) subject.getPrincipal();
        if(email.equals(user.getEmail())){
            return ResponseContent.fail(CommonConstant.NOT_MODIFY_ERROR);
        }
        SysUser modify = new SysUser();
        modify.setId(user.getId());
        modify.setEmail(email);

        int rows = sysUserService.updateUserInfo(modify);
        if(rows == 1){
            SysUser userInfo = sysUserService.findById(user.getId());
            ShiroUtils.setUser(userInfo);
            return ResponseContent.ok().putMsg(CommonConstant.UPDATE_SUCCESS);
        }else if(rows == 0){
            return ResponseContent.fail(CommonConstant.UPDATE_FAIL);
        }else {
            logger.error("modify user update rows : "+rows);
            return ResponseContent.fail(CommonConstant.SERVER_ERROR);
        }


    }
}
