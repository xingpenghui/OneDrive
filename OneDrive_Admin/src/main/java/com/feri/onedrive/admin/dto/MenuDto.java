package com.feri.onedrive.admin.dto;

import lombok.Data;

import java.util.List;

/**
 * @program: OneDrive
 * @description:
 * @author: Feri
 * @create: 2019-09-17 16:45
 */
@Data
public class MenuDto {
    private int id;
    private String name;
    private String icon;
    private List<MenuItem> childs;//所有的下级菜单数据
}
