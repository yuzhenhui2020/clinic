package com.xiaoniucr.service.impl;

import com.xiaoniucr.common.vo.JSONReturn;
import com.xiaoniucr.common.vo.PageVo;
import com.xiaoniucr.entity.Bill;
import com.xiaoniucr.entity.User;
import com.xiaoniucr.mapper.BillMapper;
import com.xiaoniucr.mapper.UserMapper;
import com.xiaoniucr.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 账单记录
 */
@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillMapper billMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageVo page(Map map) {
        List<Bill> list = billMapper.findList(map);
        Integer total = billMapper.findTotal(map);
        return new PageVo(total,list);
    }

    @Override
    public Integer save(Bill bill) {
        //新增记录
        bill.setStatus(0);
        bill.setTotalBill(0.0);
        Date date = new Date();
        bill.setCreateTime(date);
        bill.setUpdateTime(date);
        return billMapper.insert(bill);
    }

    @Override
    public Integer update(Bill bill) {
        bill.setUpdateTime(new Date());
        return billMapper.updateByPrimaryKeySelective(bill);
    }

    @Override
    public Integer del(Integer id) {
        return billMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Bill selectById(Integer id) {
        return billMapper.selectByPrimaryKey(id);
    }

    @Override
    public JSONReturn pay(Integer id) {

        Bill bill = billMapper.selectByPrimaryKey(id);
        User user = userMapper.selectByPrimaryKey(bill.getUserId());
        if(bill.getTotalBill() > user.getAmount()){
            return JSONReturn.failed("余额不足，请联系管理员充值！");
        }
        user.setAmount(user.getAmount() - bill.getTotalBill());
        userMapper.updateByPrimaryKeySelective(user);
        //更新缴费状态
        bill.setStatus(1);
        billMapper.updateByPrimaryKeySelective(bill);
        return JSONReturn.success("缴费成功！");
    }
}
