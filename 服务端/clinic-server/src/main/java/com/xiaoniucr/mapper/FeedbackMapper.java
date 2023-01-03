package com.xiaoniucr.mapper;

import com.xiaoniucr.entity.Feedback;

import java.util.List;
import java.util.Map;

/**
 * 留言反馈持久化层
 */
public interface FeedbackMapper {

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
    int insert(Feedback record);

    /**
     * 部分字段保存记录
     * @param record
     * @return
     */
    int insertSelective(Feedback record);

    /**
     * 根据Id查询记录
     * @param id
     * @return
     */
    Feedback selectByPrimaryKey(Integer id);

    /**
     * 部分字段更新记录信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Feedback record);

    /**
     * 全部字段更新记录信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(Feedback record);


    /**
     * 查询记录
     * @param map
     * @return
     */
    List<Feedback> findList(Map map);


    /**
     * 统计记录
     * @param map
     * @return
     */
    Integer findTotal(Map map);

}