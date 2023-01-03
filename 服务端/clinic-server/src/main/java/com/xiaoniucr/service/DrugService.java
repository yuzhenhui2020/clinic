package com.xiaoniucr.service;

import com.xiaoniucr.common.vo.JSONReturn;
import com.xiaoniucr.common.vo.PageVo;
import com.xiaoniucr.entity.Drug;

import java.util.List;
import java.util.Map;


/**
 * 药品服务类
 */
public interface DrugService {


    /**
     * 药品分页
     * @param map
     * @return
     */
    PageVo page(Map map);

    /**
     * 添加药品
     * @param drug
     * @return
     */
    JSONReturn save(Drug drug);

    /**
     * 更新药品
     * @param drug
     * @return
     */
    JSONReturn update(Drug drug);


    /**
     * 删除药品
     * @param id
     * @return
     */
    Integer del(Integer id);



    /**
     * 根据ID查询药品
     * @param id
     * @return
     */
    Drug selectById(Integer id);


    /**
     * 查询所有药品
     * @return
     */
    List<Drug> findAll();


}
