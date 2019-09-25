package com.feri.onedrive.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.feri.onedrive.admin.entity.Sys_member;
import com.feri.onedrive.admin.entity.Sys_permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Feri
 * @since 2019-09-17
 */
public interface MemberDao extends BaseMapper<Sys_member> {

    //查询用户的所有权限名称
    @Select("select p.prms from sys_permission p inner join sys_rolepermission rp on p.id=rp.pid inner join sys_userrole ur on ur.rid=rp.rid where p.type=2  and ur.uid=#{id}")
    Set<String> selectPerms(int id);
    //查询用户的所有的菜单信息 包含一级、二级、三级
    @Select("select p.* from sys_permission p inner join sys_rolepermission rp on p.id=rp.pid inner join sys_userrole ur on ur.rid=rp.rid where p.type=1 and ur.uid=#{id} order by p.level,p.id")
    List<Sys_permission> selectMenus(int id);
}
