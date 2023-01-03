package com.xiaoniucr.mapper;

import com.xiaoniucr.entity.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 账单持久化层
 */
public interface BillMapper {

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
    int insert(Bill record);

    /**
     * 部分字段保存记录
     * @param record
     * @return
     */
    int insertSelective(Bill record);

    /**
     * 根据Id查询记录
     * @param id
     * @return
     */
    Bill selectByPrimaryKey(Integer id);

    /**
     * 部分字段更新记录信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Bill record);

    /**
     * 全部字段更新记录信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(Bill record);


    /**
     * 查询记录
     * @param map
     * @return
     */
    List<Bill> findList(Map map);


    /**
     * 统计记录
     * @param map
     * @return
     */
    Integer findTotal(Map map);


    /**
     * 统计营业额
     * @param beginTime
     * @param endTime
     * @return
     */
    Double sumByDate(@Param(value = "beginTime")String beginTime, @Param(value = "endTime")String endTime);

}