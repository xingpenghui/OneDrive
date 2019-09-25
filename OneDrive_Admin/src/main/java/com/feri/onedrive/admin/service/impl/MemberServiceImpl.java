package com.feri.onedrive.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feri.onedrive.admin.core.config.SystemConfig;
import com.feri.onedrive.admin.core.util.EncryptionUtil;
import com.feri.onedrive.admin.core.util.RUtil;
import com.feri.onedrive.admin.core.vo.R;
import com.feri.onedrive.admin.dao.MemberDao;
import com.feri.onedrive.admin.dto.MenuDto;
import com.feri.onedrive.admin.dto.MenuItem;
import com.feri.onedrive.admin.dto.UserDto;
import com.feri.onedrive.admin.entity.Sys_member;
import com.feri.onedrive.admin.entity.Sys_permission;
import com.feri.onedrive.admin.service.MemberService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImpl extends ServiceImpl<MemberDao,Sys_member> implements MemberService {
    @Override
    public R login(UserDto userDto) {
        //1、查询账号对应的用户信息
        Sys_member member=getBaseMapper().selectOne(new QueryWrapper<Sys_member>().eq("mname",userDto.getUname()));
        //2、验证账号是否正确
        if(member!=null){
            //3、验证密码是否正确  密文比对
            if(member.getPassword().equals(EncryptionUtil.AESEnc(SystemConfig.PASSKEY,userDto.getPsw()))){
                //登录成功
                //4、创建Shiro的令牌
                UsernamePasswordToken token=new UsernamePasswordToken(member.getMname(),member.getPassword());
                //5、调用Shiro登录 告诉Shiro登录成功
                Subject subject= SecurityUtils.getSubject();
                subject.login(token); //调用Realm的认证方法
                //6、将登录用户信息存储到Session中
                subject.getSession().setAttribute("member",member);
                return RUtil.setOK("登录成功");
             }
        }
        return RUtil.setERROR("账号或密码不正确");
    }

    @Override
    public R loginOut() {
        Subject subject= SecurityUtils.getSubject();
        subject.logout();
        return RUtil.setOK("OK");
    }

    @Override
    public R<List<MenuDto>> queryMenus() {
        //1、获取登录用户
        Sys_member member=(Sys_member)SecurityUtils.getSubject().getSession().getAttribute("member");
        //2、查询当前用户所有菜单
        List<Sys_permission> list=getBaseMapper().selectMenus(member.getId());
        //3、组装一级和二级菜单
        List<MenuDto> menus=new ArrayList<>();
        for(Sys_permission p:list){
            if(p.getLevel()==1){
                //一级菜单
                MenuDto menuDto=new MenuDto();
                menuDto.setIcon(p.getIcon());
                menuDto.setName(p.getName());
                menuDto.setChilds(new ArrayList<>());
                menuDto.setId(p.getId());
                menus.add(menuDto);
            }else {
                //二级菜单
                //1、先寻找对应的一级菜单
                int index=searchParent(menus,p);
                if(index>-1){
                    MenuItem item=new MenuItem();
                    item.setId(p.getId());
                    item.setIcon(p.getIcon());
                    item.setLevel(p.getLevel());
                    item.setMurl(p.getPrms());
                    item.setName(p.getName());
                    menus.get(index).getChilds().add(item);
                }
            }
        }
        return RUtil.setOK("OK",menus);
    }

    private int searchParent(List<MenuDto> list,Sys_permission p){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId()==p.getParentid()){
                return i;
            }
        }
        return -1;
    }
}
