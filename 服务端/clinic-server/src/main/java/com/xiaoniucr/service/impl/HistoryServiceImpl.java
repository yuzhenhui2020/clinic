package com.xiaoniucr.service.impl;

import com.xiaoniucr.common.vo.PageVo;
import com.xiaoniucr.entity.Appoint;
import com.xiaoniucr.entity.History;
import com.xiaoniucr.mapper.AppointMapper;
import com.xiaoniucr.mapper.HistoryMapper;
import com.xiaoniucr.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 账单服务实现类
 */
@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryMapper historyMapper;

    @Autowired
    private AppointMapper appointMapper;

    @Override
    public PageVo page(Map map) {
        List<History> list = historyMapper.findList(map);
        Integer total = historyMapper.findTotal(map);
        return new PageVo(total,list);
    }

    @Override
    public Integer save(History history) {
        //新增就诊（病历）记录
        Date date = new Date();
        history.setCreateTime(date);
        history.setUpdateTime(date);
        return historyMapper.insert(history);
    }

    @Override
    public Integer update(History history) {
        history.setUpdateTime(new Date());
        return historyMapper.updateByPrimaryKeySelective(history);
    }

    @Override
    public Integer del(Integer id) {
        return historyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public History selectById(Integer id) {
        return historyMapper.selectByPrimaryKey(id);
    }
}
