package com.feri.onedrive.dto;

import com.feri.onedrive.entity.car.CarConfig;
import com.feri.onedrive.entity.car.CarMedia;
import com.feri.onedrive.entity.car.CarPrice;
import lombok.Data;

import java.util.List;

/**
 * @program: OneDrive
 * @description:
 * @author: Feri
 * @create: 2019-09-23 17:05
 */
@Data
public class CarDetailDto {
    //媒体图片
    private List<CarMedia> medias;
    //基本信息
    private CarBaseDto carBase;
    //基础配置信息
    private CarConfig carConfig;
    //价格日历 最近15天
    private List<CarPrice> prices;


}
