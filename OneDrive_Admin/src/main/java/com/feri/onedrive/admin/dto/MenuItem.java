package com.feri.onedrive.admin.dto;

import lombok.Data;

/**
 * @program: OneDrive
 * @description:
 * @author: Feri
 * @create: 2019-09-17 16:45
 */
@Data
public class MenuItem {
    private int id;
    private String name;
    private String murl;
    private String icon;
    private int level;

}
