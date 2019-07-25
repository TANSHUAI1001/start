<#macro LeftSidebar>
    <#setting classic_compatible=true>
<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

        <!-- Sidebar user panel (optional) -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${user.avatar}" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>${user.username}</p>
                <!-- Status -->
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>

        <!-- Sidebar Menu -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">HEADER</li>
            <#-- 前端只支持二级级菜单动态生成 -->
    <#list menus as menu>
            <#if menu.sub?size gt 0 >
                <li class="treeview <#if active?split('/')[1] == menu.value?split('/')[1]>active</#if>" >
                    <a href="#">
                        <i class="fa ${menu.classes}"></i> <span>${menu.name}</span>
                        <span class="pull-right-container">
                      <i class="fa fa-angle-left pull-right"></i>
                    </span>
                    </a>
                    <ul class="treeview-menu">
                        <#list menu.sub as item>
                        <li class="<#if active == item.value >active</#if>" ><a href="${item.value?substring(1)}"><i class="fa ${item.classes}"></i>${item.name}</a></li>
                        </#list>
                    </ul>
                </li>
            <#else>
                <li class="<#if active == menu.value>active</#if>" ><a href="${menu.value?substring(1)}"><i class="fa ${menu.classes}"></i> <span>${menu.name}</span></a></li>
            </#if>
    </#list>
<#--            <li class="<#if active == '/dashboard'>active</#if>" ><a href="/dashboard"><i class="fa fa-dashboard"></i> <span>Dashboard</span></a></li>-->
<#--            <li class="<#if active == '/profile'>active</#if>" ><a href="/profile"><i class="fa fa-user"></i> <span>个人信息</span></a></li>-->
<#--            <li class="treeview <#if active == '/management/user' || active == '/management/resource'>active</#if>" >-->
<#--                <a href="#">-->
<#--                    <i class="fa fa-desktop"></i> <span>系统管理</span>-->
<#--                    <span class="pull-right-container">-->
<#--                      <i class="fa fa-angle-left pull-right"></i>-->
<#--                    </span>-->
<#--                </a>-->
<#--                <ul class="treeview-menu">-->
<#--                    <li class="<#if active == '/management/user'>active</#if>" ><a href="/management/user"><i class="fa fa-circle-o"></i>用户管理</a></li>-->
<#--                    <li class="<#if active == '/management/resource'>active</#if>" ><a href="/management/resource"><i class="fa fa-circle-o"></i>资源权限管理</a></li>-->
<#--                </ul>-->
<#--            </li>-->
        </ul>
        <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
</aside>
</#macro>