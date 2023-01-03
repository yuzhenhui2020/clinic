package com.xiaoniucr.service;

import com.xiaoniucr.common.vo.JSONReturn;
import com.xiaoniucr.common.vo.PageVo;
import com.xiaoniucr.entity.Dept;

import java.util.List;
import java.util.Map;


/**
 * 科室服务类
 */
public interface DeptService {


    /**
     * 科室分页
     * @param map
     * @return
     */
    PageVo page(Map map);

    /**
     * 添加科室
     * @param dept
     * @return
     */
    Integer save(Dept dept);

    /**
     * 更新科室
     * @param dept
     * @return
     */
    Integer update(Dept dept);


    /**
     * 删除科室
     * @param id
     * @return
     */
    Integer del(Integer id);



    /**
     * 根据ID查询科室
     * @param id
     * @return
     */
    Dept selectById(Integer id);


    /**
     * 查询所有部门科室
     * @return
     */
    List<Dept> findAll();


}
