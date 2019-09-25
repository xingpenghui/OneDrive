package com.feri.onedrive.admin.out.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.feri.onedrive.entity.car.CarBrand;

import java.util.ArrayList;
import java.util.List;

public interface CarBrandDao extends BaseMapper<CarBrand> {
    int delBatchIds(List<Integer> ids);
}
