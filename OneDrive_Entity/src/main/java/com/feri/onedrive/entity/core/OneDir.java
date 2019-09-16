package com.feri.onedrive.entity.core;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sun.javafx.beans.IDProperty;
import lombok.Data;

/**
 * @program: OneDrive
 * @description:
 * @author: Feri
 * @create: 2019-09-16 14:36
 */
@Data
@TableName("t_dir")
public class OneDir {
    private int id;
    private String name;
}
