package com.feri.onedrive.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feri.onedrive.admin.core.util.RUtil;
import com.feri.onedrive.admin.core.vo.R;
import com.feri.onedrive.admin.dao.PermissionDao;
import com.feri.onedrive.admin.dao.RoleDao;
import com.feri.onedrive.admin.entity.Sys_permission;
import com.feri.onedrive.admin.entity.Sys_role;
import com.feri.onedrive.admin.service.PermissionService;
import com.feri.onedrive.admin.service.RoleService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionDao, Sys_permission> implements PermissionService {
    @Override
    public R checkPerms(String perms) {
        try{
            SecurityUtils.getSubject().checkPermission(perms);
            return RUtil.setOK("拥有此权限");
        }catch (Exception e){
            return RUtil.setERROR("暂无权限");
        }
    }
}
