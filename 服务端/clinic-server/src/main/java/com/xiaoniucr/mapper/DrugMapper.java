package com.xiaoniucr.mapper;

import com.xiaoniucr.entity.Drug;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 药品信息持久化层
 */
public interface DrugMapper {

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
    int insert(Drug record);

    /**
     * 部分字段保存记录
     * @param record
     * @return
     */
    int insertSelective(Drug record);

    /**
     * 根据Id查询记录
     * @param id
     * @return
     */
    Drug selectByPrimaryKey(Integer id);

    /**
     * 部分字段更新记录信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Drug record);

    /**
     * 全部字段更新记录信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(Drug record);



    /**
     * 查询记录
     * @param map
     * @return
     */
    List<Drug> findList(Map map);


    /**
     * 统计记录
     * @param map
     * @return
     */
    Integer findTotal(Map map);


    /**
     * 根据编号查询药品
     * @param drugNo
     * @return
     */
    Drug selectByDrugNo(@Param(value = "drugNo")String drugNo);


    /**
     * 查询所有药品
     * @return
     */
    List<Drug> findAll();

}