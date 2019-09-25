package com.feri.onedrive.dto;

import lombok.Data;

/**
 * @program: OneDrive
 * @description:
 * @author: Feri
 * @create: 2019-09-23 16:55
 */
@Data
public class CarBaseDto {
    private String name;
    private String brand;
    private String ctype;//车型  微型车 轿车 SUV
    private String cartype;//车系 朗逸 甲壳虫
    private int years;
    private String config;

}
