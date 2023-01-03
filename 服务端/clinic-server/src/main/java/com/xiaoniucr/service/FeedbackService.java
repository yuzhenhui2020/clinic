package com.xiaoniucr.service;

import com.xiaoniucr.common.vo.PageVo;
import com.xiaoniucr.entity.Feedback;

import java.util.Map;


/**
 *留言反馈服务层
 */
public interface FeedbackService {


    /**
     *留言反馈分页
     * @param map
     * @return
     */
    PageVo page(Map map);

    /**
     * 添加留言反馈
     * @param feedback
     * @return
     */
    Integer save(Feedback feedback);

    /**
     * 更新留言反馈
     * @param feedback
     * @return
     */
    Integer update(Feedback feedback);


    /**
     * 删除留言反馈
     * @param id
     * @return
     */
    Integer del(Integer id);



    /**
     * 根据ID查询留言反馈
     * @param id
     * @return
     */
    Feedback selectById(Integer id);
    
}
