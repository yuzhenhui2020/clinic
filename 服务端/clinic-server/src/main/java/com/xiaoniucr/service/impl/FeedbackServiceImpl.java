package com.xiaoniucr.service.impl;

import com.xiaoniucr.common.vo.PageVo;
import com.xiaoniucr.entity.Feedback;
import com.xiaoniucr.mapper.FeedbackMapper;
import com.xiaoniucr.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 留言反馈服务实现类
 */
@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Override
    public PageVo page(Map map) {
        List<Feedback> list = feedbackMapper.findList(map);
        Integer total = feedbackMapper.findTotal(map);
        return new PageVo(total,list);
    }

    @Override
    public Integer save(Feedback feedback) {
        Date date = new Date();
        feedback.setStatus(0);
        feedback.setCreateTime(date);
        feedback.setUpdateTime(date);
        return feedbackMapper.insert(feedback);
    }

    @Override
    public Integer update(Feedback feedback) {
        feedback.setUpdateTime(new Date());
        return feedbackMapper.updateByPrimaryKeySelective(feedback);
    }

    @Override
    public Integer del(Integer id) {
        return feedbackMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Feedback selectById(Integer id) {
        return feedbackMapper.selectByPrimaryKey(id);
    }
}
