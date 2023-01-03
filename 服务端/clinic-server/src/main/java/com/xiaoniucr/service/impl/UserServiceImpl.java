package com.xiaoniucr.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.xiaoniucr.common.dto.LoginDto;
import com.xiaoniucr.common.vo.*;
import com.xiaoniucr.entity.*;
import com.xiaoniucr.mapper.*;
import com.xiaoniucr.service.UserService;
import com.xiaoniucr.utils.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 用户服务实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private NoticeMapper noticeMapper;

    @Autowired
    private AppointMapper appointMapper;

    @Autowired
    private DoctorMapper doctorMapper;

    @Autowired
    private BillMapper billMapper;


    @Override
    public JSONReturn login(LoginDto loginDto) {

        LoginVo loginVo = new LoginVo();
        Integer role = loginDto.getRole();
        if(role == 0){
            Admin admin = this.adminMapper.selectByUsername(loginDto.getUsername());
            if (admin == null) {
                return JSONReturn.failed("账户不存在！");
            }
            if (!admin.getPassword().equals(loginDto.getPassword())) {
                return JSONReturn.failed("密码错误！");
            }
            BeanUtils.copyProperties(admin, loginVo);
        }else if(role == 1){
            Doctor doctor = doctorMapper.selectByUsername(loginDto.getUsername());
            if (doctor == null) {
                return JSONReturn.failed("账户不存在！");
            }
            if (!doctor.getPassword().equals(loginDto.getPassword())) {
                return JSONReturn.failed("密码错误！");
            }
            BeanUtils.copyProperties(doctor, loginVo);
        } else{
            User user = userMapper.selectByUsername(loginDto.getUsername());
            if (user == null) {
                return JSONReturn.failed("账户不存在！");
            }
            if (!user.getPassword().equals(loginDto.getPassword())) {
                return JSONReturn.failed("密码错误！");
            }
            BeanUtils.copyProperties(user, loginVo);
        }
        loginVo.setRole(role);
        return JSONReturn.success("登录成功！",loginVo);
    }

    @Override
    public PageVo page(Map map) {
        List<User> list = userMapper.findList(map);
        Integer total = userMapper.findTotal(map);
        return new PageVo(total,list);
    }

    @Override
    public JSONReturn save(User user) {
        //用户名查询
        User exist = userMapper.selectByUsername(user.getUsername());
        if(exist != null){
            return JSONReturn.failed("用户名已存在，请重新输入！");
        }
        Date date = new Date();
        user.setCreateTime(date);
        user.setUpdateTime(date);
        user.setStatus(0);
        //初始化性别
        user.setSex(0);
        user.setAmount(0.0);
        userMapper.insert(user);
        return JSONReturn.success("注册成功！");
    }

    @Override
    public JSONReturn update(User user) {

        User u = userMapper.selectByPrimaryKey(user.getId());
        if(user.getUsername() != null && !u.getUsername().equals(user.getUsername())){
            User exist = userMapper.selectByUsername(user.getUsername());
            if(exist != null){
                return JSONReturn.failed("用户名已存在，请重新输入！");
            }
        }
        user.setUpdateTime(new Date());
        userMapper.updateByPrimaryKeySelective(user);
        return JSONReturn.success("更新成功！");
    }

    @Override
    public Integer del(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User selectById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public CountVo count() {

        CountVo countVo = new CountVo();
        List<DeptVo> deptList = new ArrayList<>();
        List<Notice> noticeList = noticeMapper.findTopList(2);
        List<Double> amountList = new ArrayList<>();
        List<Dept> list = deptMapper.findAll();
        if(!CollectionUtil.isEmpty(list)){
            for(Dept dept : list){
                Integer totalNum = doctorMapper.countByDept(dept.getId());
                DeptVo deptVo = new DeptVo();
                deptVo.setDeptName(dept.getDeptName());
                deptVo.setTotalNum(totalNum);
                deptList.add(deptVo);
            }
        }
        String[] months = DateUtils.getLast12Months();
        for(String m : months){
            Date month = DateUtils.dateParse(m,"yyyy-MM");
            String firstDayOfMonth = DateUtils.getFisrtDayOfMonth(month);
            String lastDayOfMonth = DateUtils.getLastDayOfMonth(month);
            Double totalAmount = billMapper.sumByDate(firstDayOfMonth,lastDayOfMonth);
            amountList.add(totalAmount == null ? 0.0  : totalAmount);
        }
        countVo.setDeptList(deptList);
        countVo.setNoticeList(noticeList);
        countVo.setDateList(months);
        countVo.setAmountList(amountList);
        return countVo;
    }


}
