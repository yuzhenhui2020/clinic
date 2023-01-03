package com.xiaoniucr.service;

import com.xiaoniucr.common.vo.JSONReturn;
import com.xiaoniucr.common.vo.PageVo;
import com.xiaoniucr.entity.History;

import java.util.Map;


/**
 * 账单服务层
 */
public interface HistoryService {

    /**
     * 账单分页
     * @param map
     * @return
     */
    PageVo page(Map map);

    /**
     * 添加账单
     * @param history
     * @return
     */
    Integer save(History history);

    /**
     * 更新账单
     * @param history
     * @return
     */
    Integer update(History history);


    /**
     * 删除账单
     * @param id
     * @return
     */
    Integer del(Integer id);



    /**
     * 根据ID查询账单
     * @param id
     * @return
     */
    History selectById(Integer id);

    
}
