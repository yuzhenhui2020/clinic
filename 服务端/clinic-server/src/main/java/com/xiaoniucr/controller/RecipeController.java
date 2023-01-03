package com.xiaoniucr.controller;

import com.xiaoniucr.common.dto.PageQueryDto;
import com.xiaoniucr.common.vo.JSONReturn;
import com.xiaoniucr.common.vo.PageVo;
import com.xiaoniucr.controller.base.BaseController;
import com.xiaoniucr.entity.Recipe;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * 处方相关
 */
@RestController
@RequestMapping(value = "/recipe")
public class RecipeController extends BaseController {

    /**
     * 处方分页
     * @param map
     * @return
     */
    @GetMapping
    JSONReturn page(@RequestParam Map<String,Object> map){
        PageQueryDto queryDto = new PageQueryDto(map);
        PageVo pageVo = recipeService.page(queryDto);
        return JSONReturn.success(pageVo);
    }





    /**
     * 新增处方
     * @param recipe
     * @return
     */
    @PostMapping
    public JSONReturn save(@RequestBody Recipe recipe){
        return recipeService.save(recipe);
    }


    /**
     * 更新
     * @param recipe
     * @return
     */
    @PutMapping
    public JSONReturn update(@RequestBody Recipe recipe){
        return recipeService.update(recipe);
    }


    /**
     * 删除处方
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public JSONReturn delete(@PathVariable(value = "id")Integer id){
        return recipeService.del(id);
    }




}
