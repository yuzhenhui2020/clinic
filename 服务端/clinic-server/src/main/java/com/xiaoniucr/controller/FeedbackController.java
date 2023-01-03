package com.xiaoniucr.controller;

import com.xiaoniucr.common.dto.PageQueryDto;
import com.xiaoniucr.common.vo.JSONReturn;
import com.xiaoniucr.common.vo.PageVo;
import com.xiaoniucr.controller.base.BaseController;
import com.xiaoniucr.entity.Feedback;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * 留言反馈相关
 */
@RestController
@RequestMapping(value = "/feedback")
public class FeedbackController extends BaseController {

    /**
     * 留言反馈分页
     * @param map
     * @return
     */
    @GetMapping
    JSONReturn page(@RequestParam Map<String,Object> map){
        PageQueryDto queryDto = new PageQueryDto(map);
        PageVo pageVo = feedbackService.page(queryDto);
        return JSONReturn.success(pageVo);
    }





    /**
     * 新增留言反馈
     * @param feedback
     * @return
     */
    @PostMapping
    public JSONReturn save(@RequestBody Feedback feedback){
        Integer rows = feedbackService.save(feedback);
        return rows > 0 ? JSONReturn.success("保存成功！") : JSONReturn.failed("操作失败！");
    }


    /**
     * 更新
     * @param feedback
     * @return
     */
    @PutMapping
    public JSONReturn update(@RequestBody Feedback feedback){
        Integer rows = feedbackService.update(feedback);
        return rows > 0 ? JSONReturn.success("更新成功！") : JSONReturn.failed("操作失败！");
    }


    /**
     * 删除留言反馈
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public JSONReturn delete(@PathVariable(value = "id")Integer id){
        Integer rows = feedbackService.del(id);
        return rows  > 0 ? JSONReturn.success("删除成功！") : JSONReturn.failed("操作失败！");
    }





}
