package com.xiaoniucr.service.impl;

import com.xiaoniucr.common.vo.PageVo;
import com.xiaoniucr.entity.Dept;
import com.xiaoniucr.mapper.DeptMapper;
import com.xiaoniucr.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 科室服务实现类
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;


    @Override
    public PageVo page(Map map) {
        List<Dept> list = deptMapper.findList(map);
        Integer total = deptMapper.findTotal(map);
        return new PageVo(total,list);
    }

    @Override
    public Integer save(Dept dept) {

        Date date = new Date();
        dept.setCreateTime(date);
        dept.setUpdateTime(date);
        return deptMapper.insert(dept);
    }

    @Override
    public Integer update(Dept dept) {
        dept.setUpdateTime(new Date());
        return deptMapper.updateByPrimaryKeySelective(dept);
    }

    @Override
    public Integer del(Integer id) {
        return deptMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Dept selectById(Integer id) {
        return deptMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }
}
