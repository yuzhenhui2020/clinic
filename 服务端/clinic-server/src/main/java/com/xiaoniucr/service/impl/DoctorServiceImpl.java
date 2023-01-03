package com.xiaoniucr.service.impl;

import com.xiaoniucr.common.vo.JSONReturn;
import com.xiaoniucr.common.vo.PageVo;
import com.xiaoniucr.entity.Doctor;
import com.xiaoniucr.mapper.*;
import com.xiaoniucr.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 医生服务实现类
 */
@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorMapper doctorMapper;

    @Autowired
    private NoticeMapper noticeMapper;


    
    @Override
    public PageVo page(Map map) {
        List<Doctor> list = doctorMapper.findList(map);
        Integer total = doctorMapper.findTotal(map);
        return new PageVo(total,list);
    }

    @Override
    public JSONReturn save(Doctor doctor) {
        //用户名查询
        Doctor exist = doctorMapper.selectByUsername(doctor.getUsername());
        if(exist != null){
            return JSONReturn.failed("用户名已存在，请重新输入！");
        }
        Date date = new Date();
        doctor.setCreateTime(date);
        doctor.setUpdateTime(date);
        doctor.setStatus(0);
        //初始化性别
        doctor.setSex(0);
        doctorMapper.insert(doctor);
        return JSONReturn.success("注册成功！");
    }

    @Override
    public JSONReturn update(Doctor doctor) {

        Doctor u = doctorMapper.selectByPrimaryKey(doctor.getId());
        if(doctor.getUsername() != null && !u.getUsername().equals(doctor.getUsername())){
            Doctor exist = doctorMapper.selectByUsername(doctor.getUsername());
            if(exist != null){
                return JSONReturn.failed("用户名已存在，请重新输入！");
            }
        }
        doctor.setUpdateTime(new Date());
        doctorMapper.updateByPrimaryKeySelective(doctor);
        return JSONReturn.success("更新成功！");
    }

    @Override
    public Integer del(Integer id) {
        return doctorMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Doctor selectById(Integer id) {
        return doctorMapper.selectByPrimaryKey(id);
    }


}
