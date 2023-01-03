package com.xiaoniucr.service.impl;

import com.xiaoniucr.common.vo.JSONReturn;
import com.xiaoniucr.common.vo.PageVo;
import com.xiaoniucr.entity.Appoint;
import com.xiaoniucr.entity.Plan;
import com.xiaoniucr.entity.Source;
import com.xiaoniucr.mapper.AppointMapper;
import com.xiaoniucr.mapper.PlanMapper;
import com.xiaoniucr.mapper.SourceMapper;
import com.xiaoniucr.service.AppointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 预约服务实现类
 */
@Service
public class AppointServiceImpl implements AppointService {

    @Autowired
    private AppointMapper appointMapper;

    @Autowired
    private SourceMapper sourceMapper;

    @Autowired
    private PlanMapper planMapper;


    @Override
    public PageVo page(Map map) {
        List<Appoint> list = appointMapper.findList(map);
        Integer total = appointMapper.findTotal(map);
        return new PageVo(total,list);
    }

    @Override
    public JSONReturn save(Appoint appoint) {

        Appoint exist = appointMapper.selectExist(appoint.getUserId(),appoint.getSourceId());
        if(exist != null){
            return JSONReturn.failed("你已预约该号源！");
        }
        //号源扣除
        Source source = sourceMapper.selectByPrimaryKey(appoint.getSourceId());
        source.setRest(source.getRest() - 1);
        sourceMapper.updateByPrimaryKeySelective(source);
        //号源总量扣除
        Plan plan = planMapper.selectByPrimaryKey(source.getPlanId());
        plan.setRestNum(plan.getRestNum() - 1);
        planMapper.updateByPrimaryKeySelective(plan);
        //新增记录
        Date date = new Date();
        appoint.setStatus(0);
        appoint.setCreateTime(date);
        appoint.setUpdateTime(date);
        appointMapper.insert(appoint);
        return JSONReturn.success("预约成功！");
    }

    @Override
    public Integer update(Appoint appoint) {
        appoint.setUpdateTime(new Date());
        return appointMapper.updateByPrimaryKeySelective(appoint);
    }

    @Override
    public Integer del(Integer id) {
        return appointMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Appoint selectById(Integer id) {
        return appointMapper.selectByPrimaryKey(id);
    }

    @Override
    public JSONReturn cancel(Integer id) {

        Appoint appoint = appointMapper.selectByPrimaryKey(id);
        Source source = sourceMapper.selectByPrimaryKey(appoint.getSourceId());
        source.setRest(source.getRest() + 1);
        sourceMapper.updateByPrimaryKeySelective(source);
        Plan plan = planMapper.selectByPrimaryKey(source.getPlanId());
        plan.setRestNum(plan.getRestNum() +1);
        planMapper.updateByPrimaryKeySelective(plan);
        appoint.setStatus(2);
        appointMapper.updateByPrimaryKeySelective(appoint);
        return JSONReturn.success("取消预约成功！");
    }
}
