package com.feri.onedrive.admin.out.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feri.onedrive.admin.core.util.RUtil;
import com.feri.onedrive.admin.core.vo.R;
import com.feri.onedrive.admin.out.dao.CarBrandDao;
import com.feri.onedrive.admin.out.service.CarBrandService;
import com.feri.onedrive.entity.car.CarBrand;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: OneDrive
 * @description:
 * @author: Feri
 * @create: 2019-09-18 10:05
 */
@Service
public class CarBrandServiceImpl extends ServiceImpl<CarBrandDao, CarBrand> implements CarBrandService {
    @Override
    public R delBatchIds(List<Integer> ids) {
        return RUtil.setR(getBaseMapper().delBatchIds(ids)>0,"批量删除");
    }
}
