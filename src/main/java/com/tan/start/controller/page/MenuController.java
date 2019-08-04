package com.tan.start.controller.page;

import com.tan.start.constants.MenuConstant;
import com.tan.start.constants.PermissionConstant;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/")
public class MenuController {

    @RequestMapping(value="/")
    public ModelAndView defaults(ModelAndView modelAndView) {
        modelAndView.setViewName("redirect:index");
        return modelAndView;
    }

    @RequestMapping(value= MenuConstant.SYSTEM_MENU_DASHBOARD)
    @RequiresPermissions(PermissionConstant.SYSTEM_MENU_DASHBOARD)
    public ModelAndView dashboard(ModelAndView modelAndView) {
        modelAndView.setViewName(MenuConstant.SYSTEM_MENU_DASHBOARD);
        modelAndView.addObject(MenuConstant.MENU_ACTIVE,MenuConstant.SYSTEM_MENU_DASHBOARD);
        return modelAndView;
    }

    @RequestMapping(value= MenuConstant.SYSTEM_MENU_FUND)
    @RequiresPermissions(PermissionConstant.SYSTEM_MENU_FUND)
    public ModelAndView fund(ModelAndView modelAndView) {
        modelAndView.setViewName(MenuConstant.SYSTEM_MENU_FUND);
        modelAndView.addObject(MenuConstant.MENU_ACTIVE,MenuConstant.SYSTEM_MENU_FUND);
        return modelAndView;
    }

    @RequestMapping(value= MenuConstant.SYSTEM_MENU_PROFILE)
    @RequiresPermissions(PermissionConstant.SYSTEM_MENU_PROFILE)
    public ModelAndView profile(ModelAndView modelAndView) {
        modelAndView.setViewName(MenuConstant.SYSTEM_MENU_PROFILE);
        modelAndView.addObject(MenuConstant.MENU_ACTIVE,MenuConstant.SYSTEM_MENU_PROFILE);
        return modelAndView;
    }

    @RequestMapping(value= MenuConstant.SYSTEM_MENU_MANAGEMENT)
    @RequiresPermissions(PermissionConstant.SYSTEM_MENU_MANAGEMENT)
    public ModelAndView management(ModelAndView modelAndView) {
        modelAndView.setViewName(MenuConstant.SYSTEM_PAGE_BASIC_BLANK);
        modelAndView.addObject(MenuConstant.MENU_ACTIVE,MenuConstant.SYSTEM_MENU_MANAGEMENT);
        return modelAndView;
    }

    @RequestMapping(value= MenuConstant.SYSTEM_MENU_MANAGEMENT_USER)
    @RequiresPermissions(PermissionConstant.SYSTEM_MENU_MANAGEMENT_USER)
    public ModelAndView user(ModelAndView modelAndView) {
        modelAndView.setViewName(MenuConstant.SYSTEM_MENU_MANAGEMENT_USER);
        modelAndView.addObject(MenuConstant.MENU_ACTIVE,MenuConstant.SYSTEM_MENU_MANAGEMENT_USER);
        return modelAndView;
    }

    @RequestMapping(value= MenuConstant.SYSTEM_MENU_MANAGEMENT_RESOURCE)
    @RequiresPermissions(PermissionConstant.SYSTEM_MENU_MANAGEMENT_RESOURCE)
    public ModelAndView resource(ModelAndView modelAndView) {
        modelAndView.setViewName(MenuConstant.SYSTEM_MENU_MANAGEMENT_RESOURCE);
        modelAndView.addObject(MenuConstant.MENU_ACTIVE,MenuConstant.SYSTEM_MENU_MANAGEMENT_RESOURCE);
        return modelAndView;
    }

    @RequestMapping(value= MenuConstant.SYSTEM_MENU_MANAGEMENT_ROLE)
    @RequiresPermissions(PermissionConstant.SYSTEM_MENU_MANAGEMENT_ROLE)
    public ModelAndView role(ModelAndView modelAndView) {
        modelAndView.setViewName(MenuConstant.SYSTEM_MENU_MANAGEMENT_ROLE);
        modelAndView.addObject(MenuConstant.MENU_ACTIVE,MenuConstant.SYSTEM_MENU_MANAGEMENT_ROLE);
        return modelAndView;
    }
}
