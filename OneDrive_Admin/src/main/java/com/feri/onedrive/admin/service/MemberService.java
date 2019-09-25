package com.feri.onedrive.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.feri.onedrive.admin.core.vo.R;
import com.feri.onedrive.admin.dto.MenuDto;
import com.feri.onedrive.admin.dto.UserDto;
import com.feri.onedrive.admin.entity.Sys_member;

import java.util.List;

public interface MemberService extends IService<Sys_member> {
    R login(UserDto userDto);
    R loginOut();
    R<List<MenuDto>> queryMenus();
}
