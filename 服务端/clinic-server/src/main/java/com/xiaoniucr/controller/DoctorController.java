package com.xiaoniucr.controller;

import com.xiaoniucr.common.dto.PageQueryDto;
import com.xiaoniucr.common.vo.JSONReturn;
import com.xiaoniucr.common.vo.PageVo;
import com.xiaoniucr.controller.base.BaseController;
import com.xiaoniucr.entity.Doctor;
import com.xiaoniucr.entity.User;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;
import java.util.Map;


/**
 * 医生相关
 */
@RestController
@RequestMapping(value = "/doctor")
public class DoctorController extends BaseController {

    /**
     * 医生分页
     * @param map
     * @return
     */
    @GetMapping
    JSONReturn page(@RequestParam Map<String,Object> map){
        PageQueryDto queryDto = new PageQueryDto(map);
        PageVo pageVo = doctorService.page(queryDto);
        return JSONReturn.success(pageVo);
    }


    /**
     * 根据ID查询记录
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public JSONReturn selectById(@PathVariable(value = "id")Integer id){
        Doctor doctor = doctorService.selectById(id);
        return JSONReturn.success(doctor);
    }




    /**
     * 添加医生
     * @param doctor
     * @return
     */
    @PostMapping
    public JSONReturn save(@RequestBody Doctor doctor){
        return doctorService.save(doctor);
    }


    /**
     * 更新医生
     * @param doctor
     * @return
     */
    @PutMapping
    public JSONReturn update(@RequestBody Doctor doctor){
        return doctorService.update(doctor);
    }


    /**
     * 删除医生
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public JSONReturn delete(@PathVariable(value = "id")Integer id){
        Integer rows = doctorService.del(id);
        return rows  > 0 ? JSONReturn.success("删除成功！") : JSONReturn.failed("操作失败！");
    }



}
