package com.feri.onedrive.server.controller;

import com.feri.onedrive.common.util.RUtil;
import com.feri.onedrive.common.vo.R;
import com.feri.onedrive.entity.core.OneDir;
import com.feri.onedrive.server.service.OneDirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: OneDrive
 * @description:
 * @author: Feri
 * @create: 2019-09-16 14:48
 */
@RestController
public class OneDirController {
    @Autowired
    private OneDirService dirService;

    //新增
    @PostMapping("/server/dir/savedir.do")
    public R save(@RequestBody OneDir dir){
        return RUtil.setR(dirService.save(dir),"新增字典");
    }
    //查询
    @GetMapping("/server/dir/querydir.do")
    public R detail(@RequestParam("id") int id){
        return RUtil.setOK("查询字典",dirService.getById(id));
    }
    //删除
    @DeleteMapping("/server/dir/deldir.do")
    public R del(@RequestParam int id){
        return RUtil.setR(dirService.removeById(id),"删除字典");
    }


}
