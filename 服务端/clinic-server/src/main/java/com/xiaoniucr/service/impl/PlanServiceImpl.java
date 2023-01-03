package com.xiaoniucr.service.impl;

import cn.hutool.core.date.DateUtil;
import com.xiaoniucr.common.vo.JSONReturn;
import com.xiaoniucr.common.vo.PageVo;
import com.xiaoniucr.entity.Plan;
import com.xiaoniucr.mapper.PlanMapper;
import com.xiaoniucr.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 排班计划服务实现类
 */
@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanMapper planMapper;


    @Override
    public PageVo page(Map map) {
        List<Plan> list = planMapper.findList(map);
        Integer total = planMapper.findTotal(map);
        return new PageVo(total,list);
    }

    @Override
    public JSONReturn save(Plan plan) {

        Plan exist = planMapper.selectExist(plan.getDoctorId(),plan.getPlanDate());
        if(exist != null){
            return JSONReturn.failed("此医生该日计划已存在！");
        }
        Date date = new Date();
        plan.setRestNum(plan.getTotalNum());
        plan.setStatus(0);
        plan.setTotalNum(0);
        plan.setRestNum(0);
        plan.setCreateTime(date);
        plan.setUpdateTime(date);
        planMapper.insert(plan);
        return JSONReturn.success("保存成功！");
    }

    @Override
    public JSONReturn update(Plan plan) {

        Plan p = planMapper.selectByPrimaryKey(plan.getId());
        if(!DateUtil.isSameDay(plan.getPlanDate(),p.getPlanDate()) || plan.getDoctorId() != p.getDoctorId()){
            Plan exist = planMapper.selectExist(plan.getDoctorId(),plan.getPlanDate());
            if(exist != null){
                return JSONReturn.failed("此医生该日计划已存在！");
            }
        }
        plan.setUpdateTime(new Date());
        planMapper.updateByPrimaryKeySelective(plan);
        return JSONReturn.success("保存成功！");
    }

    @Override
    public Integer del(Integer id) {
        return planMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Plan selectById(Integer id) {
        return planMapper.selectByPrimaryKey(id);
    }

    @Override
    public JSONReturn post(Plan plan) {

        Plan p = planMapper.selectByPrimaryKey(plan.getId());
        if(p.getStatus() != 0){
            return JSONReturn.failed("该排班已发布！");
        }
        p.setStatus(1);
        planMapper.updateByPrimaryKeySelective(p);
        return JSONReturn.success("发布成功！");
    }
}
