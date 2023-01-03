package com.xiaoniucr.controller;

import com.xiaoniucr.common.dto.PageQueryDto;
import com.xiaoniucr.common.vo.JSONReturn;
import com.xiaoniucr.common.vo.PageVo;
import com.xiaoniucr.controller.base.BaseController;
import com.xiaoniucr.entity.Drug;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 部门科室相关
 */
@RestController
@RequestMapping(value = "/drug")
public class DrugController extends BaseController {

    /**
     * 部门科室分页
     * @param map
     * @return
     */
    @GetMapping
    JSONReturn page(@RequestParam Map<String,Object> map){
        PageQueryDto queryDto = new PageQueryDto(map);
        PageVo pageVo = drugService.page(queryDto);
        return JSONReturn.success(pageVo);
    }

    /**
     * 新增部门科室
     * @param drug
     * @return
     */
    @PostMapping
    public JSONReturn save(@RequestBody Drug drug){
        return  drugService.save(drug);
    }


    /**
     * 更新
     * @param drug
     * @return
     */
    @PutMapping
    public JSONReturn update(@RequestBody Drug drug){
        return drugService.update(drug);
    }




    /**
     * 删除部门科室
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public JSONReturn delete(@PathVariable(value = "id")Integer id){
        Integer rows = drugService.del(id);
        return rows  > 0 ? JSONReturn.success("删除成功！") : JSONReturn.failed("操作失败！");
    }


    /**
     * 查询所有
     * @return
     */
    @GetMapping(value = "/all")
    JSONReturn all(){
        List<Drug> all = drugService.findAll();
        return JSONReturn.success(all);
    }


}
