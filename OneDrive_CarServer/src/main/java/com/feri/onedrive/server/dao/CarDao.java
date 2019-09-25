package com.feri.onedrive.server.dao;

import com.feri.onedrive.dto.CarBaseDto;
import com.feri.onedrive.common.vo.R;
import com.feri.onedrive.entity.car.Car;
import com.feri.onedrive.entity.car.CarConfig;
import com.feri.onedrive.entity.car.CarMedia;
import com.feri.onedrive.entity.car.CarPrice;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CarDao {
    /**
     * [新增]
     * @author Feri
     * @date 2019/09/23
     **/
    int insert(@Param("tCar") Car car);

    /**
     * [刪除]
     * @author Feri
     * @date 2019/09/23
     **/
    int delete(@Param("id") int id);

    /**
     * [更新]
     * @author Feri
     * @date 2019/09/23
     **/
    int update(@Param("tCar") Car car);

    /**
     * [查詢] 根據主鍵 id 查詢
     * @author Feri
     * @date 2019/09/23
     **/
    Car load(@Param("id") int id);

    /**
     * [查詢] 分頁查詢
     * @author Feri
     * @date 2019/09/23
     **/
    @Select("select * from t_car order by id limit offset,pagesize")
    List<Car> pageList(@Param("offset") int offset,
                       @Param("pagesize") int pagesize);

    /**
     * [查詢] 分頁查詢 count
     * @author Feri
     * @date 2019/09/23
     **/
    @Select("select count(*) from t_car")
    int pageListCount(@Param("offset") int offset,
                      @Param("pagesize") int pagesize);

    @Select("select * from t_carmedia where cid=#{id} order by msort")
    List<CarMedia> selectMedia(int id);
    @Select("select c.years,c.cartype config,ct.name cartype,cb.name brand from t_car c inner join t_cartype ct on c.ctid=ct.id inner join t_carbrand cb on ct.bid=cb.id where c.id=#{id}")
    CarBaseDto selectBase(int id);
    @Select("select * from t_carconfig where cid=#{id}")
    CarConfig selectConfig(int id);
    @Select("select * from t_carprice where cid=#{id} and cdate>=date_format(now(),'%Y-%m-%d') order by cdate limit 16")
    List<CarPrice> selectPrice(int id);

}
