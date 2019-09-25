package com.feri.onedrive.admin.shiro;

import com.feri.onedrive.admin.dao.MemberDao;
import com.feri.onedrive.admin.entity.Sys_member;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @program: OneDrive
 * @description:
 * @author: Feri
 * @create: 2019-09-17 10:21
 */
@Service
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private MemberDao memberDao;
    /**
     * 授权 查询当前登录用户的所有权限和角色
     * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("Shiro的授权");
        //1、获取登录的用户
        Sys_member member= (Sys_member) SecurityUtils.getSubject().getSession().getAttribute("member");
        //2、根据登录用户查询权限
        Set<String> perms=memberDao.selectPerms(member.getId());
        //3、设置权限
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        authorizationInfo.setStringPermissions(perms);

        return authorizationInfo;
    }

    /**
     * 认证 登录*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("Shiro的认证");
        //1、转换Token 获取登录的信息
        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;
        if(token!=null){
            //创建票据对象
            return new SimpleAuthenticationInfo(token.getUsername(),token.getPassword(),getName());
        }else {
            return null;
        }

    }
}
