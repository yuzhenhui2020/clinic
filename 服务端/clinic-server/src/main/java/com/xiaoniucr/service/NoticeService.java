package com.xiaoniucr.service;

import com.xiaoniucr.common.vo.PageVo;
import com.xiaoniucr.entity.Notice;

import java.util.List;
import java.util.Map;


/**
 * 公告服务类
 */
public interface NoticeService {


    /**
     * 公告分页
     * @param map
     * @return
     */
    PageVo page(Map map);

    /**
     * 添加公告
     * @param notice
     * @return
     */
    Integer save(Notice notice);

    /**
     * 更新公告
     * @param notice
     * @return
     */
    Integer update(Notice notice);


    /**
     * 删除公告
     * @param id
     * @return
     */
    Integer del(Integer id);



    /**
     * 根据ID查询公告
     * @param id
     * @return
     */
    Notice selectById(Integer id);


    /**
     * 查询所有公告
     * @param limit 前几条
     * @return
     */
    List<Notice> findTopList(Integer limit);

}
