package com.xiaoniucr.service;


import com.xiaoniucr.entity.Admin;


/**
 * 管理员服务类
 */
public interface AdminService {



    /**
     * 修改
     * @param admin
     * @return
     */
    Integer update(Admin admin);





    /**
     * 根据ID查询管理员信息
     * @param id
     * @return
     */
    Admin selectById(Integer id);




}
