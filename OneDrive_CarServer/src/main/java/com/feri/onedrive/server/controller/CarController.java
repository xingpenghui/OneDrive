package com.feri.onedrive.server.controller;

import com.feri.onedrive.common.vo.R;
import com.feri.onedrive.server.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: OneDrive
 * @description:
 * @author: Feri
 * @create: 2019-09-23 16:01
 */
@RestController
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/provider/car/page.do")
    public R queryPage(@RequestParam("page") int page, @RequestParam("size") int size){
        return carService.pageList(size, page);
    }
    @GetMapping("/provider/car/cardetail.do")
    public R queryDetail(@RequestParam("id") int id){
        return carService.queryDetail(id);
    }
}
