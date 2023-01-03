package com.xiaoniucr.service;

import com.xiaoniucr.common.vo.JSONReturn;
import com.xiaoniucr.common.vo.PageVo;
import com.xiaoniucr.entity.Recipe;

import java.util.List;
import java.util.Map;


/**
 * 处方服务层
 */
public interface RecipeService {

    /**
     * 处方分页
     * @param map
     * @return
     */
    PageVo page(Map map);

    /**
     * 添加处方
     * @param recipe
     * @return
     */
    JSONReturn save(Recipe recipe);

    /**
     * 更新处方
     * @param recipe
     * @return
     */
    JSONReturn update(Recipe recipe);


    /**
     * 删除处方
     * @param id
     * @return
     */
    JSONReturn del(Integer id);



    /**
     * 根据ID查询处方
     * @param id
     * @return
     */
    Recipe selectById(Integer id);


    /**
     * 根据账单查处方
     * @param map
     * @return
     */
    List<Recipe> findByBill(Map map);

    
}
