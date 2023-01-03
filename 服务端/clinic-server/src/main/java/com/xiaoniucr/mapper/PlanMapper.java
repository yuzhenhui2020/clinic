package com.xiaoniucr.mapper;

import com.xiaoniucr.entity.Plan;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 排班计划持久化层
 */
public interface PlanMapper {

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
    int insert(Plan record);

    /**
     * 部分字段保存记录
     * @param record
     * @return
     */
    int insertSelective(Plan record);

    /**
     * 根据Id查询记录
     * @param id
     * @return
     */
    Plan selectByPrimaryKey(Integer id);

    /**
     * 部分字段更新记录信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Plan record);

    /**
     * 全部字段更新记录信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(Plan record);


    /**
     * 查询记录
     * @param map
     * @return
     */
    List<Plan> findList(Map map);


    /**
     * 统计记录
     * @param map
     * @return
     */
    Integer findTotal(Map map);


    /**
     * 查询是否存在（去重）
     * @param doctorId
     * @param planDate
     * @return
     */
    Plan selectExist(@Param(value = "doctorId")Integer doctorId,@Param(value = "planDate") Date planDate);
}