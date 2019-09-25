package com.feri.onedrive.admin.out.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.feri.onedrive.admin.core.vo.R;
import com.feri.onedrive.entity.car.CarBrand;

import java.util.List;

public interface CarBrandService extends IService<CarBrand> {
    R delBatchIds(List<Integer> ids);
}
