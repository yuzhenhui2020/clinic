package com.xiaoniucr.mapper;

import com.xiaoniucr.entity.Source;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 号源信息持久化层
 */
public interface SourceMapper {

    /**
     * 根据ID删除记录
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 全量字段保存记录
     * @param record
     * @return
     */
    int insert(Source record);

    /**
     * 部分字段保存记录
     * @param record
     * @return
     */
    int insertSelective(Source record);

    /**
     * 根据Id查询记录
     * @param id
     * @return
     */
    Source selectByPrimaryKey(Integer id);

    /**
     * 部分字段更新记录信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Source record);

    /**
     * 全部字段更新记录信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(Source record);


    /**
     * 查询记录
     * @param map
     * @return
     */
    List<Source> findList(Map map);


    /**
     * 统计记录
     * @param map
     * @return
     */
    Integer findTotal(Map map);


    /**
     * 根据排班查询号源
     * @param planId
     * @return
     */
    List<Source> findByPlan(@Param(value = "planId")Integer planId);


    /**
     * 统计号源
     * @param planId
     * @return
     */
    Integer sumByPlan(@Param(value = "planId")Integer planId);
}