package com.xiaoniucr.service;

import com.xiaoniucr.common.vo.PageVo;
import com.xiaoniucr.entity.Source;

import java.util.List;
import java.util.Map;


/**
 * 号源信息服务类
 */
public interface SourceService {


    /**
     *号源信息分页
     * @param map
     * @return
     */
    PageVo page(Map map);

    /**
     * 添加号源信息
     * @param source
     * @return
     */
    Integer save(Source source);

    /**
     * 更新号源信息
     * @param source
     * @return
     */
    Integer update(Source source);


    /**
     * 删除号源信息
     * @param id
     * @return
     */
    Integer del(Integer id);



    /**
     * 根据ID查询号源信息
     * @param id
     * @return
     */
    Source selectById(Integer id);


    /**
     * 查询所有号源信息
     * @return
     */
    List<Source> findByPlan(Integer planId);
}
