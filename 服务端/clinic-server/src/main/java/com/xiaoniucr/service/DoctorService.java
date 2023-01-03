package com.xiaoniucr.service;

import com.xiaoniucr.common.vo.CountVo;
import com.xiaoniucr.common.vo.JSONReturn;
import com.xiaoniucr.common.vo.PageVo;
import com.xiaoniucr.entity.Doctor;

import java.util.Map;


/**
 * 医生服务类
 */
public interface DoctorService {


    /**
     * 医生分页
     * @param map
     * @return
     */
    PageVo page(Map map);

    /**
     * 添加医生医生
     * @param doctor
     * @return
     */
    JSONReturn save(Doctor doctor);


    /**
     * 修改
     * @param doctor
     * @return
     */
    JSONReturn update(Doctor doctor);



    /**
     * 删除医生
     * @param id
     * @return
     */
    Integer del(Integer id);



    /**
     * 根据ID查询医生信息
     * @param id
     * @return
     */
    Doctor selectById(Integer id);




}
