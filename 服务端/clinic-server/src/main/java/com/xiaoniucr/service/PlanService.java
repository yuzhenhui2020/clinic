package com.xiaoniucr.service;

import com.xiaoniucr.common.vo.JSONReturn;
import com.xiaoniucr.common.vo.PageVo;
import com.xiaoniucr.entity.Plan;

import java.util.Map;


/**
 * 排班计划服务层
 */
public interface PlanService {

    /**
     * 排班计划分页
     * @param map
     * @return
     */
    PageVo page(Map map);

    /**
     * 添加排班计划
     * @param plan
     * @return
     */
    JSONReturn save(Plan plan);

    /**
     * 更新排班计划
     * @param plan
     * @return
     */
    JSONReturn update(Plan plan);


    /**
     * 删除排班计划
     * @param id
     * @return
     */
    Integer del(Integer id);



    /**
     * 根据ID查询排班计划
     * @param id
     * @return
     */
    Plan selectById(Integer id);



    /**
     * 发布排班计划
     * @param plan
     * @return
     */
    JSONReturn post(Plan plan);

}
