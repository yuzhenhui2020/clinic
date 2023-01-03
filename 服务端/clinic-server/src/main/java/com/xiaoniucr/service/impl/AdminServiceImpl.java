package com.xiaoniucr.service.impl;

import com.xiaoniucr.entity.Admin;
import com.xiaoniucr.mapper.AdminMapper;
import com.xiaoniucr.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;


    @Override
    public Integer update(Admin admin) {
        admin.setUpdateTime(new Date());
        return adminMapper.updateByPrimaryKeySelective(admin);
    }

    @Override
    public Admin selectById(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }
}
