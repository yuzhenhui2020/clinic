package com.xiaoniucr.mapper;

import com.xiaoniucr.entity.Doctor;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 医生信息持久化层
 */
public interface DoctorMapper {

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
    int insert(Doctor record);

    /**
     * 部分字段保存记录
     * @param record
     * @return
     */
    int insertSelective(Doctor record);

    /**
     * 根据Id查询记录
     * @param id
     * @return
     */
    Doctor selectByPrimaryKey(Integer id);

    /**
     * 部分字段更新记录信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Doctor record);

    /**
     * 全部字段更新记录信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(Doctor record);


    /**
     * 查询记录
     * @param map
     * @return
     */
    List<Doctor> findList(Map map);


    /**
     * 统计记录
     * @param map
     * @return
     */
    Integer findTotal(Map map);



    /**
     * 根据账号查询账号
     * @param username
     * @return
     */
    Doctor selectByUsername(@Param(value = "username")String username);



    /**
     * 统计科室人数
     * @param deptId
     * @return
     */
    Integer countByDept(@Param(value = "deptId")Integer deptId);
}