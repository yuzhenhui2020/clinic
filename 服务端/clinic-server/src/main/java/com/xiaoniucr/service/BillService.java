package com.xiaoniucr.service;

import com.xiaoniucr.common.vo.JSONReturn;
import com.xiaoniucr.common.vo.PageVo;
import com.xiaoniucr.entity.Bill;

import java.util.Map;


/**
 * 账单服务层
 */
public interface BillService {

    /**
     * 账单分页
     * @param map
     * @return
     */
    PageVo page(Map map);

    /**
     * 添加账单
     * @param bill
     * @return
     */
    Integer save(Bill bill);

    /**
     * 更新账单
     * @param bill
     * @return
     */
    Integer update(Bill bill);


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
    Bill selectById(Integer id);


    /**
     * 缴费
     * @param id
     * @return
     */
    JSONReturn pay(Integer id);
    
}
