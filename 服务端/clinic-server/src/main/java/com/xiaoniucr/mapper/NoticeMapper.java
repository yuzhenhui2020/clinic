package com.xiaoniucr.mapper;

import com.xiaoniucr.entity.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 公告持久化层
 */
public interface NoticeMapper {

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
    int insert(Notice record);

    /**
     * 部分字段保存记录
     * @param record
     * @return
     */
    int insertSelective(Notice record);

    /**
     * 根据Id查询记录
     * @param id
     * @return
     */
    Notice selectByPrimaryKey(Integer id);

    /**
     * 部分字段更新记录信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Notice record);

    /**
     * 全部字段更新记录信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(Notice record);


    /**
     * 查询记录
     * @param map
     * @return
     */
    List<Notice> findList(Map map);


    /**
     * 统计记录
     * @param map
     * @return
     */
    Integer findTotal(Map map);


    /**
     * 查询所有公告
     * @return
     */
    List<Notice> findTopList(@Param(value = "limit")Integer limit);
}