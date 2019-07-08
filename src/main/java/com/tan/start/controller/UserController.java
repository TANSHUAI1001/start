package com.tan.start.controller;

import com.tan.start.entity.SysUser;
import com.tan.start.service.SysUserService;
import com.tan.start.utils.ResponseResult;
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
    public ResponseResult resetPassword(String password,String newPassword){
        if(StringUtils.isBlank(password) || StringUtils.isBlank(newPassword)){
            return ResponseResult.error("参数错误！");
        }

        Subject subject = SecurityUtils.getSubject();
        SysUser user = (SysUser) subject.getPrincipal();

        String md5PasswordWithSalt = DigestUtils.md5DigestAsHex((password+user.getSalt()).getBytes());
        if(!md5PasswordWithSalt.equals(user.getPassword())){
            return ResponseResult.error("原始密码错误！");
        }
        String md5NewPasswordWithSalt = DigestUtils.md5DigestAsHex((newPassword+user.getSalt()).getBytes());
        int rows = sysUserService.updatePasswordById(user.getId(),md5NewPasswordWithSalt);
        if(rows == 1){
            SysUser userInfo = sysUserService.findById(user.getId());
            ShiroUtils.setUser(userInfo);
        }
        return ResponseResult.ok();
    }

    @RequestMapping(value = "/modify",method = RequestMethod.POST)
    public ResponseResult modifyUserInfo(String email){
        if(StringUtils.isBlank(email)){
            return ResponseResult.error("参数错误！");
        }

        Subject subject = SecurityUtils.getSubject();
        SysUser user = (SysUser) subject.getPrincipal();
        if(email.equals(user.getEmail())){
            return ResponseResult.error("未作修改！");
        }
        SysUser modify = new SysUser();
        modify.setId(user.getId());
        modify.setEmail(email);

        int rows = sysUserService.updateUserInfo(modify);
        if(rows == 1){
            SysUser userInfo = sysUserService.findById(user.getId());
            ShiroUtils.setUser(userInfo);
            return ResponseResult.ok("更新成功");
        }else if(rows == 0){
            return ResponseResult.error("更新失败");
        }else {
            logger.warn("modify user update rows : "+rows);
            return ResponseResult.warn("服务异常");
        }


    }
}
