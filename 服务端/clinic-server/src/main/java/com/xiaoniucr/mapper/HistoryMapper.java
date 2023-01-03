package com.xiaoniucr.mapper;

import com.xiaoniucr.entity.History;

import java.util.List;
import java.util.Map;

/**
 * 就诊（病历记录）持久化层
 */
public interface HistoryMapper {

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
    int insert(History record);

    /**
     * 部分字段保存记录
     * @param record
     * @return
     */
    int insertSelective(History record);

    /**
     * 根据Id查询记录
     * @param id
     * @return
     */
    History selectByPrimaryKey(Integer id);

    /**
     * 部分字段更新记录信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(History record);

    /**
     * 全部字段更新记录信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(History record);


    /**
     * 查询记录
     * @param map
     * @return
     */
    List<History> findList(Map map);


    /**
     * 统计记录
     * @param map
     * @return
     */
    Integer findTotal(Map map);

}