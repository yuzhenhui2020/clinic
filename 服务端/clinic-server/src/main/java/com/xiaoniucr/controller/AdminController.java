package com.xiaoniucr.controller;

import com.xiaoniucr.common.vo.JSONReturn;
import com.xiaoniucr.controller.base.BaseController;
import com.xiaoniucr.entity.Admin;
import org.springframework.web.bind.annotation.*;


/**
 * 管理员相关
 */
@RestController
@RequestMapping(value = "/admin")
public class AdminController extends BaseController {


    /**
     * 根据ID查询记录
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public JSONReturn selectById(@PathVariable(value = "id")Integer id){
        Admin admin = adminService.selectById(id);
        return JSONReturn.success(admin);
    }


    /**
     * 更新管理员信息
     * @param admin
     * @return
     */
    @PutMapping
    public JSONReturn update(@RequestBody Admin admin){
        Integer rows = adminService.update(admin);
        return rows  > 0 ? JSONReturn.success("更新成功！") : JSONReturn.failed("操作失败！");
    }



}
