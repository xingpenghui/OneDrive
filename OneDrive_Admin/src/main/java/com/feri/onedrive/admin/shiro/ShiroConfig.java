package com.feri.onedrive.admin.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: OneDrive
 * @description:
 * @author: Feri
 * @create: 2019-09-17 10:45
 */
@Configuration
public class ShiroConfig {
    //1、创建权限管理器对象 并且传递自定义Realm
    @Bean
    public DefaultWebSecurityManager createSM(ShiroRealm realm){
        DefaultWebSecurityManager wsm=new DefaultWebSecurityManager(realm);
        return wsm;
    }
    //2、创建Shiro工厂
    @Bean
    public ShiroFilterFactoryBean createFilter(WebSecurityManager securityManager){
        ShiroFilterFactoryBean factoryBean=new ShiroFilterFactoryBean();
        //1、设置管理器对象
        factoryBean.setSecurityManager(securityManager);
        //2、设置3个路径 登录、成功、失败
        factoryBean.setLoginUrl("/login.html");//登录页面
        factoryBean.setSuccessUrl("/index.html");//主页 登录之后要跳转的页面
        factoryBean.setUnauthorizedUrl("/error.html");//未授权页面 没有权限
        //3、设置拦截规则  登录页面和接口、静态资源 放行 不登录就可以使用 剩下必须登录才可以使用
        Map<String,String> map=new HashMap<>();
        //anon 匿名访问 不登录就可以使用
        map.put("login.html","anon");
        map.put("swagger-ui.html","anon");
        map.put("/web/member/login.do","anon");
        map.put("/media/**","anon");
        //authc 认证访问 必须登录才可以访问
        map.put("/*","authc");
        map.put("*.do","authc");
        factoryBean.setFilterChainDefinitionMap(map);
        return factoryBean;
    }

}
