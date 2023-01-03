package com.xiaoniucr.mapper;

import com.xiaoniucr.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 用户信息持久化层
 */
public interface UserMapper {

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
    int insert(User record);

    /**
     * 部分字段保存记录
     * @param record
     * @return
     */
    int insertSelective(User record);

    /**
     * 根据Id查询记录
     * @param id
     * @return
     */
    User selectByPrimaryKey(Integer id);

    /**
     * 部分字段更新记录信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 全部字段更新记录信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(User record);


    /**
     * 查询记录
     * @param map
     * @return
     */
    List<User> findList(Map map);


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
    User selectByUsername(@Param(value = "username")String username);




}