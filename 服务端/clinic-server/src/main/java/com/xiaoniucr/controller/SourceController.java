package com.xiaoniucr.controller;

import com.xiaoniucr.common.dto.PageQueryDto;
import com.xiaoniucr.common.vo.JSONReturn;
import com.xiaoniucr.common.vo.PageVo;
import com.xiaoniucr.controller.base.BaseController;
import com.xiaoniucr.entity.Source;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 号源信息相关
 */
@RestController
@RequestMapping(value = "/source")
public class SourceController extends BaseController {

    /**
     * 号源信息分页
     * @param map
     * @return
     */
    @GetMapping
    JSONReturn page(@RequestParam Map<String,Object> map){
        PageQueryDto queryDto = new PageQueryDto(map);
        PageVo pageVo = sourceService.page(queryDto);
        return JSONReturn.success(pageVo);
    }

    /**
     * 新增号源信息
     * @param source
     * @return
     */
    @PostMapping
    public JSONReturn save(@RequestBody Source source){
        Integer rows = sourceService.save(source);
        return rows > 0 ? JSONReturn.success("保存成功！") : JSONReturn.failed("操作失败！");
    }


    /**
     * 更新
     * @param source
     * @return
     */
    @PutMapping
    public JSONReturn update(@RequestBody Source source){
        Integer rows = sourceService.update(source);
        return rows > 0 ? JSONReturn.success("更新成功！") : JSONReturn.failed("操作失败！");
    }




    /**
     * 删除号源信息
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public JSONReturn delete(@PathVariable(value = "id")Integer id){
        Integer rows = sourceService.del(id);
        return rows  > 0 ? JSONReturn.success("删除成功！") : JSONReturn.failed("操作失败！");
    }


    /**
     * 查询所有
     * @return
     */
    @GetMapping(value = "/all/{planId}")
    JSONReturn all(@PathVariable(value = "planId")Integer planId){
        List<Source> all = sourceService.findByPlan(planId);
        return JSONReturn.success(all);
    }

}
