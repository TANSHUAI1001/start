package com.tan.start.controller;

import com.tan.start.aspect.AspectConfig;
import com.tan.start.dto.RoleResourceDTO;
import com.tan.start.dto.SysUserDTO;
import com.tan.start.entity.SysUser;
import com.tan.start.service.SysResourceService;
import com.tan.start.utils.GenerateTreeFromList;
import com.tan.start.utils.Menu;
import com.tan.start.utils.ResponseContent;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/common")
public class RestLoginController {
    private Logger logger = LoggerFactory.getLogger(AspectConfig.class);

    @Resource
    private SysResourceService sysResourcesService;
    @Resource(name = "redisTemplate")
    private RedisTemplate<String, List<Menu>> template;

    @RequestMapping(value="/login",method= RequestMethod.POST)
    public ResponseContent login(String username, String password, boolean remembered , Model model, HttpServletRequest request) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password,remembered);
        Subject subject = SecurityUtils.getSubject();
        if (subject == null) {
            return ResponseContent.fail("server error subject is null !");
        }
        try{
            subject.logout();
            subject.login(token);
        }catch (Exception e){
            logger.error(e.getMessage());
            return ResponseContent.fail(e.getMessage());
        }

        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        //支持多级菜单生成
        List<Menu> menus = template.opsForValue().get("menu:"+user.getSingleRole());
        if(menus == null) {
            List<RoleResourceDTO> resources = sysResourcesService.getMenuByRole(user.getSingleRole());
            menus = GenerateTreeFromList.generateTree(resources);
            template.opsForValue().set("menu:"+user.getSingleRole(), menus);
        }
        HashMap<String,Object> map = new HashMap<>();
        map.put("user",new SysUserDTO(user));
        map.put("menus",menus);
        return ResponseContent.ok(map);
    }
}
