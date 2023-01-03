package com.xiaoniucr.controller;

import com.xiaoniucr.common.dto.PageQueryDto;
import com.xiaoniucr.common.vo.JSONReturn;
import com.xiaoniucr.common.vo.PageVo;
import com.xiaoniucr.controller.base.BaseController;
import com.xiaoniucr.entity.Bill;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * 账单相关
 */
@RestController
@RequestMapping(value = "/bill")
public class BillController extends BaseController {

    /**
     * 账单分页
     * @param map
     * @return
     */
    @GetMapping
    JSONReturn page(@RequestParam Map<String,Object> map){
        PageQueryDto queryDto = new PageQueryDto(map);
        PageVo pageVo = billService.page(queryDto);
        return JSONReturn.success(pageVo);
    }





    /**
     * 新增账单
     * @param bill
     * @return
     */
    @PostMapping
    public JSONReturn save(@RequestBody Bill bill){
        Integer rows =  billService.save(bill);
        return rows > 0 ? JSONReturn.success("保存成功！") : JSONReturn.failed("操作失败！");
    }


    /**
     * 更新
     * @param bill
     * @return
     */
    @PutMapping
    public JSONReturn update(@RequestBody Bill bill){
        Integer rows = billService.update(bill);
        return rows > 0 ? JSONReturn.success("保存成功！") : JSONReturn.failed("操作失败！");
    }


    /**
     * 删除账单
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public JSONReturn delete(@PathVariable(value = "id")Integer id){
        Integer rows = billService.del(id);
        return rows  > 0 ? JSONReturn.success("删除成功！") : JSONReturn.failed("操作失败！");
    }


    /**
     * 缴费
     * @param id
     * @return
     */
    @PutMapping(value = "/pay/{id}")
    public JSONReturn pay(@PathVariable(value = "id") Integer id){
        return billService.pay(id);
    }

}
