package com.xiaoniucr.service;

import com.xiaoniucr.common.vo.JSONReturn;
import com.xiaoniucr.common.vo.PageVo;
import com.xiaoniucr.entity.Appoint;

import java.util.Map;


/**
 * 预约服务层
 */
public interface AppointService {

    /**
     * 预约分页
     * @param map
     * @return
     */
    PageVo page(Map map);

    /**
     * 添加预约
     * @param appoint
     * @return
     */
    JSONReturn save(Appoint appoint);

    /**
     * 更新预约
     * @param appoint
     * @return
     */
    Integer update(Appoint appoint);


    /**
     * 删除预约
     * @param id
     * @return
     */
    Integer del(Integer id);



    /**
     * 根据ID查询预约
     * @param id
     * @return
     */
    Appoint selectById(Integer id);


    /**
     * 取消预约
     * @param id
     * @return
     */
    JSONReturn cancel(Integer id);


    
}
