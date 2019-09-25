package com.feri.onedrive.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feri.onedrive.admin.dao.MemberDao;
import com.feri.onedrive.admin.dao.RoleDao;
import com.feri.onedrive.admin.entity.Sys_member;
import com.feri.onedrive.admin.entity.Sys_role;
import com.feri.onedrive.admin.service.MemberService;
import com.feri.onedrive.admin.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleDao, Sys_role> implements RoleService {
}
