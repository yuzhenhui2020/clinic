package com.xiaoniucr.controller;

import com.xiaoniucr.common.dto.PageQueryDto;
import com.xiaoniucr.common.vo.JSONReturn;
import com.xiaoniucr.common.vo.PageVo;
import com.xiaoniucr.controller.base.BaseController;
import com.xiaoniucr.entity.History;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * 账单相关
 */
@RestController
@RequestMapping(value = "/history")
public class HistoryController extends BaseController {

    /**
     * 账单分页
     * @param map
     * @return
     */
    @GetMapping
    JSONReturn page(@RequestParam Map<String,Object> map){
        PageQueryDto queryDto = new PageQueryDto(map);
        PageVo pageVo = historyService.page(queryDto);
        return JSONReturn.success(pageVo);
    }





    /**
     * 新增账单
     * @param history
     * @return
     */
    @PostMapping
    public JSONReturn save(@RequestBody History history){
        Integer rows =  historyService.save(history);
        return rows > 0 ? JSONReturn.success("保存成功！") : JSONReturn.failed("操作失败！");
    }


    /**
     * 更新
     * @param history
     * @return
     */
    @PutMapping
    public JSONReturn update(@RequestBody History history){
        Integer rows = historyService.update(history);
        return rows > 0 ? JSONReturn.success("保存成功！") : JSONReturn.failed("操作失败！");
    }


    /**
     * 删除账单
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public JSONReturn delete(@PathVariable(value = "id")Integer id){
        Integer rows = historyService.del(id);
        return rows  > 0 ? JSONReturn.success("删除成功！") : JSONReturn.failed("操作失败！");
    }




}
