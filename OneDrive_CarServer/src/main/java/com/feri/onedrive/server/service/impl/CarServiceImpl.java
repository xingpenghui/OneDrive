package com.feri.onedrive.server.service.impl;

import com.feri.onedrive.common.util.RUtil;
import com.feri.onedrive.common.vo.R;
import com.feri.onedrive.dto.CarDetailDto;
import com.feri.onedrive.entity.car.Car;
import com.feri.onedrive.server.dao.CarDao;
import com.feri.onedrive.server.service.CarService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: OneDrive
 * @description:
 * @author: Feri
 * @create: 2019-09-23 15:55
 */
@Service
public class CarServiceImpl implements CarService {
    @Resource
    private CarDao carDao;


    @Override
    public R<String> insert(Car tCar) {

        // valid
        if (tCar == null) {
            return RUtil.setERROR("参数丢失");
        }

        carDao.insert(tCar);
        return RUtil.setOK("OK");
    }


    @Override
    public R<String> delete(int id) {
        int ret = carDao.delete(id);
        return ret>0?RUtil.setOK("OK"):RUtil.setERROR("删除失败");
    }


    @Override
    public R<String> update(Car tCar) {
        int ret = carDao.update(tCar);
        return ret>0?RUtil.setOK("OK"):RUtil.setERROR("修改失败");
    }


    @Override
    public R<Car> load(int id) {
        return RUtil.setOK("OK",carDao.load(id));
    }


    @Override
    public R pageList(int offset, int pagesize) {

        List<Car> pageList = carDao.pageList(offset, pagesize);
        int totalCount = carDao.pageListCount(offset, pagesize);
        // result
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("pageList", pageList);
        result.put("totalCount", totalCount);

        return RUtil.setOK("OK",result);
    }

    @Override
    public R<CarDetailDto> queryDetail(int id) {
        CarDetailDto detailDto=new CarDetailDto();
        detailDto.setCarBase(carDao.selectBase(id));
        detailDto.setCarConfig(carDao.selectConfig(id));
        detailDto.setMedias(carDao.selectMedia(id));
        detailDto.setPrices(carDao.selectPrice(id));
        return RUtil.setOK("OK",detailDto);
    }
}
