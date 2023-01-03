package com.xiaoniucr.mapper;

import com.xiaoniucr.entity.Appoint;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 预约持久化层
 */
public interface AppointMapper {

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
    int insert(Appoint record);

    /**
     * 部分字段保存记录
     * @param record
     * @return
     */
    int insertSelective(Appoint record);

    /**
     * 根据Id查询记录
     * @param id
     * @return
     */
    Appoint selectByPrimaryKey(Integer id);

    /**
     * 部分字段更新记录信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Appoint record);

    /**
     * 全部字段更新记录信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(Appoint record);


    /**
     * 查询记录
     * @param map
     * @return
     */
    List<Appoint> findList(Map map);


    /**
     * 统计记录
     * @param map
     * @return
     */
    Integer findTotal(Map map);


    /**
     * 查询是否预约
     * @param userId
     * @param sourceId
     * @return
     */
    Appoint selectExist(@Param(value = "userId")Integer userId,@Param(value = "sourceId")Integer sourceId);
}