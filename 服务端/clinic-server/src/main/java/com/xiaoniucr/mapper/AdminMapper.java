package com.xiaoniucr.mapper;

import com.xiaoniucr.entity.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * 管理员持久化层
 */
public interface AdminMapper {

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
    int insert(Admin record);

    /**
     * 部分字段保存记录
     * @param record
     * @return
     */
    int insertSelective(Admin record);

    /**
     * 根据Id查询记录
     * @param id
     * @return
     */
    Admin selectByPrimaryKey(Integer id);

    /**
     * 部分字段更新记录信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Admin record);

    /**
     * 全部字段更新记录信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(Admin record);


    /**
     * 根据账号查询管理员
     * @param username
     * @return
     */
    Admin selectByUsername(@Param(value = "username")String username);
}