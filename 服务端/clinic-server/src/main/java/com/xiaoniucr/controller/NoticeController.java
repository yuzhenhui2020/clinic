package com.xiaoniucr.controller;

import com.xiaoniucr.common.dto.PageQueryDto;
import com.xiaoniucr.common.vo.JSONReturn;
import com.xiaoniucr.common.vo.PageVo;
import com.xiaoniucr.controller.base.BaseController;
import com.xiaoniucr.entity.Notice;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 公告相关
 */
@RestController
@RequestMapping(value = "/notice")
public class NoticeController extends BaseController {

    /**
     * 公告分页
     * @param map
     * @return
     */
    @GetMapping
    JSONReturn page(@RequestParam Map<String,Object> map){
        PageQueryDto queryDto = new PageQueryDto(map);
        PageVo pageVo = noticeService.page(queryDto);
        return JSONReturn.success(pageVo);
    }





    /**
     * 新增公告
     * @param notice
     * @return
     */
    @PostMapping
    public JSONReturn save(@RequestBody Notice notice){
        Integer rows = noticeService.save(notice);
        return rows > 0 ? JSONReturn.success("保存成功！") : JSONReturn.failed("操作失败！");
    }


    /**
     * 更新
     * @param notice
     * @return
     */
    @PutMapping
    public JSONReturn update(@RequestBody Notice notice){
        Integer rows = noticeService.update(notice);
        return rows > 0 ? JSONReturn.success("更新成功！") : JSONReturn.failed("操作失败！");
    }


    /**
     * 删除公告
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public JSONReturn delete(@PathVariable(value = "id")Integer id){
        Integer rows = noticeService.del(id);
        return rows  > 0 ? JSONReturn.success("删除成功！") : JSONReturn.failed("操作失败！");
    }



    /**
     * 查询前几条公告
     * @param limit
     * @return
     */
    @GetMapping(value = "/top/{limit}")
    JSONReturn all(@PathVariable(value = "limit")Integer limit){
        List<Notice> all = noticeService.findTopList(limit);
        return JSONReturn.success(all);
    }





}
