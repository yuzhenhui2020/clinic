package com.xiaoniucr.mapper;

import com.xiaoniucr.entity.Recipe;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 处方持久化层
 */
public interface RecipeMapper {

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
    int insert(Recipe record);

    /**
     * 部分字段保存记录
     * @param record
     * @return
     */
    int insertSelective(Recipe record);

    /**
     * 根据Id查询记录
     * @param id
     * @return
     */
    Recipe selectByPrimaryKey(Integer id);

    /**
     * 部分字段更新记录信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Recipe record);

    /**
     * 全部字段更新记录信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(Recipe record);


    /**
     * 查询记录
     * @param map
     * @return
     */
    List<Recipe> findList(Map map);


    /**
     * 统计记录
     * @param map
     * @return
     */
    Integer findTotal(Map map);


    /**
     * 根据账单查询处方
     * @param map
     * @return
     */
    List<Recipe> findByBill(Map map);


    /**
     * 统计处方下的所有药品总费用
     * @param billId
     * @return
     */
    Double sumByBill(@Param(value = "billId")Integer billId);


    /**
     * 去重
     * @param billId
     * @param drugId
     * @return
     */
    Recipe selectExist(@Param(value = "billId")Integer billId,@Param(value = "drugId")Integer drugId);
}