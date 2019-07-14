package com.tan.start.config.shiro;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.tan.start.entity.SysResource;
import com.tan.start.service.SysResourceService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.tan.start.entity.SysRole;
import com.tan.start.entity.SysUser;
import com.tan.start.service.SysRoleService;
import com.tan.start.service.SysUserService;
import org.springframework.util.DigestUtils;

//@Component("shiroRealm")
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysResourceService sysResourceService;

    /**
     * 授权模块，获取用户角色和权限
     *
     * @param principal principal
     * @return AuthorizationInfo 权限信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
//        SimpleUser  user = (SimpleUser) SecurityUtils.getSubject().getPrincipal();
//        String userName = user.getUsername();

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        // 获取用户角色集
        int singleRoleId = user.getSingleRole();
        SysRole role = sysRoleService.findBySingleRole(singleRoleId);
        Set<String> roleSet = new HashSet<String>();
        roleSet.add(role.getName());
        simpleAuthorizationInfo.setRoles(roleSet);

        // 获取用户权限集
        List<String> permissionList = sysResourceService.getPermissionsByRoleId(singleRoleId);
        Set<String> permissionSet = new HashSet<>(permissionList);
        simpleAuthorizationInfo.setStringPermissions(permissionSet);
        return simpleAuthorizationInfo;
    }

    /**
     * 用户认证
     *
     * @param token AuthenticationToken 身份认证 token
     * @return AuthenticationInfo 身份认证信息
     * @throws AuthenticationException 认证相关异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        // 获取用户输入的用户名和密码
        String userName = (String) token.getPrincipal();
        String originPassword = new String((char[]) token.getCredentials());
        // simple implement
//        Map<String,SimpleUser> localUsers = new HashMap<>();
//        SimpleUser user1 = new SimpleUser("joe.coder","password");
//        SimpleUser user2 = new SimpleUser("jill.coder","password");
//        localUsers.put("joe.coder", user1);
//        localUsers.put("jill.coder", user2);
//        SimpleUser user = localUsers.get(userName);
//        
//        if(user == null) 
//        	throw new UnknownAccountException("用户名或密码错误！");
//        
//        if (!password.equals(user.getPassword()))
//        	throw new IncorrectCredentialsException("用户名或密码错误！");
//        
//        return new SimpleAuthenticationInfo(user, password, getName());
        
        // 通过用户名到数据库查询用户信息
        SysUser user = sysUserService.findByName(userName);
        if(user == null){
            throw new UnknownAccountException("账号信息错误！");
        }

        String md5PasswordWithSalt = DigestUtils.md5DigestAsHex((originPassword+user.getSalt()).getBytes());
//        SimpleUser user = new SimpleUser(sysUser);
//        if (user == null)
//            throw new UnknownAccountException("用户名或密码错误！");
        if (!md5PasswordWithSalt.equals(user.getPassword()))
            throw new IncorrectCredentialsException("用户名或密码错误！");
        if (new Integer(-1).equals(user.getState()))
            throw new LockedAccountException("账号已被锁定,请联系管理员！");
        return new SimpleAuthenticationInfo(user, originPassword, getName()); // 此处要放login传进来的密码
        
    }

    /**
     * 清除权限缓存
     * 使用方法：在需要清除用户权限的地方注入 ShiroRealm,
     * 然后调用其clearCache方法。
     */
    public void clearCache() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }

}
