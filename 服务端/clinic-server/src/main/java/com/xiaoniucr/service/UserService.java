package com.xiaoniucr.service;

import com.xiaoniucr.common.dto.LoginDto;
import com.xiaoniucr.common.vo.CountVo;
import com.xiaoniucr.common.vo.JSONReturn;
import com.xiaoniucr.common.vo.PageVo;
import com.xiaoniucr.entity.User;

import java.util.List;
import java.util.Map;


/**
 * 用户服务类
 */
public interface UserService {


    /**
     * 管理员登录
     * @param loginDto
     * @return
     */
    JSONReturn login(LoginDto loginDto);


    /**
     * 用户分页
     * @param map
     * @return
     */
    PageVo page(Map map);

    /**
     * 添加用户用户
     * @param user
     * @return
     */
    JSONReturn save(User user);


    /**
     * 修改
     * @param user
     * @return
     */
    JSONReturn update(User user);



    /**
     * 删除用户
     * @param id
     * @return
     */
    Integer del(Integer id);



    /**
     * 根据ID查询用户信息
     * @param id
     * @return
     */
    User selectById(Integer id);




    /**
     * 用户统计
     * @return
     */
    CountVo count();


}
