package com.xiaoniucr.controller;

import com.xiaoniucr.common.dto.PageQueryDto;
import com.xiaoniucr.common.vo.JSONReturn;
import com.xiaoniucr.common.vo.PageVo;
import com.xiaoniucr.controller.base.BaseController;
import com.xiaoniucr.entity.Dept;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 部门科室相关
 */
@RestController
@RequestMapping(value = "/dept")
public class DeptController extends BaseController {

    /**
     * 部门科室分页
     * @param map
     * @return
     */
    @GetMapping
    JSONReturn page(@RequestParam Map<String,Object> map){
        PageQueryDto queryDto = new PageQueryDto(map);
        PageVo pageVo = deptService.page(queryDto);
        return JSONReturn.success(pageVo);
    }

    /**
     * 新增部门科室
     * @param dept
     * @return
     */
    @PostMapping
    public JSONReturn save(@RequestBody Dept dept){
        Integer rows =  deptService.save(dept);
        return rows > 0 ? JSONReturn.success("保存成功！") : JSONReturn.failed("操作失败！");
    }


    /**
     * 更新
     * @param dept
     * @return
     */
    @PutMapping
    public JSONReturn update(@RequestBody Dept dept){
        Integer rows = deptService.update(dept);
        return rows > 0 ? JSONReturn.success("保存成功！") : JSONReturn.failed("操作失败！");
    }




    /**
     * 删除部门科室
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public JSONReturn delete(@PathVariable(value = "id")Integer id){
        Integer rows = deptService.del(id);
        return rows  > 0 ? JSONReturn.success("删除成功！") : JSONReturn.failed("操作失败！");
    }



    /**
     * 查询所有部门科室
     * @return
     */
    @GetMapping(value = "/all")
    JSONReturn all(){
        List<Dept> deptList = deptService.findAll();
        return JSONReturn.success(deptList);
    }

}
