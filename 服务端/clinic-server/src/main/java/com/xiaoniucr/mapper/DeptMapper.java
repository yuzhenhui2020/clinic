package com.xiaoniucr.mapper;

import com.xiaoniucr.entity.Dept;
import java.util.List;
import java.util.Map;

/**
 * 部门科室持久化层
 */
public interface DeptMapper {

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
    int insert(Dept record);

    /**
     * 部分字段保存记录
     * @param record
     * @return
     */
    int insertSelective(Dept record);

    /**
     * 根据Id查询记录
     * @param id
     * @return
     */
    Dept selectByPrimaryKey(Integer id);

    /**
     * 部分字段更新记录信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Dept record);

    /**
     * 全部字段更新记录信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(Dept record);

    /**
     * 查询记录
     * @param map
     * @return
     */
    List<Dept> findList(Map map);

    /**
     * 统计记录
     * @param map
     * @return
     */
    Integer findTotal(Map map);


    /**
     * 查询所有部门
     * @return
     */
    List<Dept> findAll();
}