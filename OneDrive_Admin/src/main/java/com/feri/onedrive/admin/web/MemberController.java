package com.feri.onedrive.admin.web;

import com.feri.onedrive.admin.core.vo.R;
import com.feri.onedrive.admin.dto.UserDto;
import com.feri.onedrive.admin.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: OneDrive
 * @description:
 * @author: Feri
 * @create: 2019-09-17 11:23
 */
@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    //实现登录
    @PostMapping("/web/member/login.do")
    public R login(UserDto userDto){
        return memberService.login(userDto);
    }

    //注销
    @GetMapping("/web/member/loginout.do")
    public R exit(){
        return memberService.loginOut();
    }

    //查询当前登录用户的菜单
    @GetMapping("/web/member/menus.do")
    public R menus(){
        return memberService.queryMenus();
    }

}
