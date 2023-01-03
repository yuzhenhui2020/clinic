package com.xiaoniucr.service.impl;

import com.xiaoniucr.common.vo.PageVo;
import com.xiaoniucr.entity.Source;
import com.xiaoniucr.entity.Plan;
import com.xiaoniucr.mapper.PlanMapper;
import com.xiaoniucr.mapper.SourceMapper;
import com.xiaoniucr.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 号源信息服务实现类
 */
@Service
public class SourceServiceImpl implements SourceService {

    @Autowired
    private SourceMapper sourceMapper;

    @Autowired
    private PlanMapper planMapper;


    @Override
    public PageVo page(Map map) {
        List<Source> list = sourceMapper.findList(map);
        Integer total = sourceMapper.findTotal(map);
        return new PageVo(total,list);
    }

    @Override
    public Integer save(Source source) {
        Date date = new Date();
        source.setRest(source.getTotal());
        source.setCreateTime(date);
        source.setUpdateTime(date);
        sourceMapper.insert(source);
        //统计号源总量
        Integer totalNum = sourceMapper.sumByPlan(source.getPlanId());
        Plan plan = new Plan();
        plan.setId(source.getPlanId());
        plan.setTotalNum(totalNum);
        plan.setRestNum(totalNum);
        return planMapper.updateByPrimaryKeySelective(plan);
    }

    @Override
    public Integer update(Source source) {
        source.setUpdateTime(new Date());
        sourceMapper.updateByPrimaryKeySelective(source);
        //统计号源总量
        Integer totalNum = sourceMapper.sumByPlan(source.getPlanId());
        Plan plan = new Plan();
        plan.setId(source.getPlanId());
        plan.setTotalNum(totalNum);
        plan.setRestNum(totalNum);
        return planMapper.updateByPrimaryKeySelective(plan);
    }

    @Override
    public Integer del(Integer id) {
        Source source = sourceMapper.selectByPrimaryKey(id);
        sourceMapper.deleteByPrimaryKey(id);
        //统计号源总量
        Integer totalNum = sourceMapper.sumByPlan(source.getPlanId());
        Plan plan = new Plan();
        plan.setId(source.getPlanId());
        plan.setTotalNum(totalNum);
        plan.setRestNum(totalNum);
        return planMapper.updateByPrimaryKeySelective(plan);
    }

    @Override
    public Source selectById(Integer id) {
        return sourceMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Source> findByPlan(Integer planId) {
        return sourceMapper.findByPlan(planId);
    }

}
