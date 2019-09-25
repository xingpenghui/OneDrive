package com.feri.onedrive.server.service;

import com.feri.onedrive.common.vo.R;
import com.feri.onedrive.dto.CarDetailDto;
import com.feri.onedrive.entity.car.Car;

/**
 * @program: OneDrive
 * @description:
 * @author: Feri
 * @create: 2019-09-23 15:54
 */
public interface CarService {
    /**
     * 新增
     */
    public R<String> insert(Car tCar);

    /**
     * 删除
     */
    public R<String> delete(int id);

    /**
     * 更新
     */
    public R<String> update(Car tCar);

    /**
     * 根據主鍵 id 查詢
     */
    public R<Car> load(int id);

    /**
     * 分页查询
     */
    public R pageList(int offset, int pagesize);

    //查询详情
    R<CarDetailDto> queryDetail(int id);

}