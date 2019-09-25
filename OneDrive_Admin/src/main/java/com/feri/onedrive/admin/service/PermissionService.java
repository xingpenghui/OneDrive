package com.feri.onedrive.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.feri.onedrive.admin.core.vo.R;
import com.feri.onedrive.admin.entity.Sys_member;
import com.feri.onedrive.admin.entity.Sys_permission;

public interface PermissionService extends IService<Sys_permission> {

    R checkPerms(String perms);
}
