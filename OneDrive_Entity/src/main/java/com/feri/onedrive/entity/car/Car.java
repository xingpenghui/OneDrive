package com.feri.onedrive.entity.car;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @program: OneDrive
 * @description:
 * @author: Feri
 * @create: 2019-09-23 15:51
 */
@Data
public class Car {
    private static final long serialVersionUID = 1L;


    private int id;
    /**
     * name
     */
    private String name;

    /**
     * ctid
     */
    private Integer ctid;

    /**
     * years
     */
    private Integer years;

    /**
     * cartype
     */
    private String cartype;

    /**
     * flag
     */
    private Integer flag;

    /**
     * 库存量
     */
    private Integer count;
}
