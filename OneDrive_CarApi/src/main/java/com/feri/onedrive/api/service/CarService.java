package com.feri.onedrive.api.service;

import com.feri.onedrive.common.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("CarProvider-xph")
public interface CarService {
    @GetMapping("/provider/car/page.do")
    R queryPage(@RequestParam("page") int page, @RequestParam("size") int size);
    @GetMapping("/provider/car/cardetail.do")
    R queryDetail(@RequestParam("id") int id);
}
