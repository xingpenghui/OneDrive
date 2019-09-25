package com.feri.onedrive.api.controller;

import com.feri.onedrive.api.service.CarService;
import com.feri.onedrive.common.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: OneDrive
 * @description:
 * @author: Feri
 * @create: 2019-09-23 16:05
 */
@RestController
@Api(value = "操作车辆信息",tags = "操作车辆信息")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/api/car/querypage.do")
    @ApiOperation(value = "查询车辆分页",notes = "查询车辆分页")
    public R query(@RequestParam("page") int page, @RequestParam("size") int size){
        return carService.queryPage(page, size);
    }

    @GetMapping("/api/car/cardetail.do")
    @ApiOperation(value = "查询车辆详情",notes = "查询车辆详情")
    public R queryDetail(@RequestParam("id") int id){
        return carService.queryDetail(id);
    }
}
