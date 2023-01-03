package com.xiaoniucr.service.impl;

import com.xiaoniucr.common.vo.PageVo;
import com.xiaoniucr.entity.Notice;
import com.xiaoniucr.mapper.NoticeMapper;
import com.xiaoniucr.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 公告服务实现类
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;


    @Override
    public PageVo page(Map map) {
        List<Notice> list = noticeMapper.findList(map);
        Integer total = noticeMapper.findTotal(map);
        return new PageVo(total,list);
    }

    @Override
    public Integer save(Notice notice) {
        Date date = new Date();
        notice.setCreateTime(date);
        notice.setUpdateTime(date);
        return noticeMapper.insert(notice);
    }

    @Override
    public Integer update(Notice notice) {
        notice.setUpdateTime(new Date());
        return noticeMapper.updateByPrimaryKeySelective(notice);
    }

    @Override
    public Integer del(Integer id) {
        return noticeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Notice selectById(Integer id) {
        return noticeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Notice> findTopList(Integer limit) {
        return noticeMapper.findTopList(limit);
    }
}
