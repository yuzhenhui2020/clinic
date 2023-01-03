package com.xiaoniucr.controller;

import com.xiaoniucr.common.dto.LoginDto;
import com.xiaoniucr.common.vo.CountVo;
import com.xiaoniucr.common.vo.JSONReturn;
import com.xiaoniucr.controller.base.BaseController;
import org.springframework.web.bind.annotation.*;

/**
 * 首页
 */
@RestController
public class HomeController extends BaseController {

    @PostMapping(value = "/login")
    public JSONReturn<?> login(@RequestBody  LoginDto loginDto){
        return userService.login(loginDto);
    }




    /**
     * 统计
     * @return
     */
    @GetMapping(value = "/count")
    JSONReturn count(){
        CountVo countVo = userService.count();
        return JSONReturn.success(countVo);
    }
}
