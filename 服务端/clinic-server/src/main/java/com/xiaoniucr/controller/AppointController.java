package com.xiaoniucr.controller;

import com.xiaoniucr.common.dto.PageQueryDto;
import com.xiaoniucr.common.vo.JSONReturn;
import com.xiaoniucr.common.vo.PageVo;
import com.xiaoniucr.controller.base.BaseController;
import com.xiaoniucr.entity.Appoint;
import org.springframework.web.bind.annotation.*;
import java.util.Map;


/**
 * 预约相关
 */
@RestController
@RequestMapping(value = "/appoint")
public class AppointController extends BaseController {

    /**
     * 预约分页
     * @param map
     * @return
     */
    @GetMapping
    JSONReturn page(@RequestParam Map<String,Object> map){
        PageQueryDto queryDto = new PageQueryDto(map);
        PageVo pageVo = appointService.page(queryDto);
        return JSONReturn.success(pageVo);
    }





    /**
     * 新增预约
     * @param appoint
     * @return
     */
    @PostMapping
    public JSONReturn save(@RequestBody Appoint appoint){
        return appointService.save(appoint);
    }


    /**
     * 更新
     * @param appoint
     * @return
     */
    @PutMapping
    public JSONReturn update(@RequestBody Appoint appoint){
        Integer rows = appointService.update(appoint);
        return rows > 0 ? JSONReturn.success("更新成功！") : JSONReturn.failed("操作失败！");
    }


    /**
     * 删除预约
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public JSONReturn delete(@PathVariable(value = "id")Integer id){
        Integer rows = appointService.del(id);
        return rows  > 0 ? JSONReturn.success("删除成功！") : JSONReturn.failed("操作失败！");
    }




    /**
     * 取消预约
     * @param id
     * @return
     */
    @DeleteMapping(value = "/cancel/{id}")
    public JSONReturn cancel(@PathVariable(value = "id") Integer id){
        return appointService.cancel(id);
    }


}
