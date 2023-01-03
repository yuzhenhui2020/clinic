package com.xiaoniucr.controller;

import com.xiaoniucr.common.dto.PageQueryDto;
import com.xiaoniucr.common.vo.JSONReturn;
import com.xiaoniucr.common.vo.PageVo;
import com.xiaoniucr.controller.base.BaseController;
import com.xiaoniucr.entity.Plan;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * 排班计划相关
 */
@RestController
@RequestMapping(value = "/plan")
public class PlanController extends BaseController {

    /**
     * 排班计划分页
     * @param map
     * @return
     */
    @GetMapping
    JSONReturn page(@RequestParam Map<String,Object> map){
        PageQueryDto queryDto = new PageQueryDto(map);
        PageVo pageVo = planService.page(queryDto);
        return JSONReturn.success(pageVo);
    }

    /**
     * 新增排班计划
     * @param plan
     * @return
     */
    @PostMapping
    public JSONReturn save(@RequestBody Plan plan){
        return  planService.save(plan);
    }


    /**
     * 更新
     * @param plan
     * @return
     */
    @PutMapping
    public JSONReturn update(@RequestBody Plan plan){
        return planService.update(plan);
    }




    /**
     * 删除排班计划
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public JSONReturn delete(@PathVariable(value = "id")Integer id){
        Integer rows = planService.del(id);
        return rows  > 0 ? JSONReturn.success("删除成功！") : JSONReturn.failed("操作失败！");
    }



    /**
     * 更新
     * @param plan
     * @return
     */
    @PutMapping(value = "/post")
    public JSONReturn post(@RequestBody Plan plan){
        return planService.post(plan);
    }


}
