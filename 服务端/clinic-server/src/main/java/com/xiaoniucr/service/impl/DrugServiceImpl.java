package com.xiaoniucr.service.impl;

import com.xiaoniucr.common.vo.JSONReturn;
import com.xiaoniucr.common.vo.PageVo;
import com.xiaoniucr.entity.Drug;
import com.xiaoniucr.mapper.DrugMapper;
import com.xiaoniucr.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 药品服务实现类
 */
@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    private DrugMapper drugMapper;

    @Override
    public PageVo page(Map map) {
        List<Drug> list = drugMapper.findList(map);
        Integer total = drugMapper.findTotal(map);
        return new PageVo(total,list);
    }

    @Override
    public JSONReturn save(Drug drug) {

        Drug exist = drugMapper.selectByDrugNo(drug.getDrugNo());
        if(exist !=null){
            return JSONReturn.failed("药品编号已存在！");
        }
        Date date = new Date();
        drug.setCreateTime(date);
        drug.setUpdateTime(date);
        drugMapper.insert(drug);
        return JSONReturn.success("保存成功！");
    }

    @Override
    public JSONReturn update(Drug drug) {

        Drug d = drugMapper.selectByPrimaryKey(drug.getId());
        if(!d.getDrugNo().equals(drug.getDrugNo())){
            Drug exist = drugMapper.selectByDrugNo(drug.getDrugNo());
            if(exist !=null){
                return JSONReturn.failed("药品编号已存在！");
            }
        }
        drug.setUpdateTime(new Date());
        drugMapper.updateByPrimaryKeySelective(drug);
        return JSONReturn.success("保存成功！");
    }

    @Override
    public Integer del(Integer id) {
        return drugMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Drug selectById(Integer id) {
        return drugMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Drug> findAll() {
        return drugMapper.findAll();
    }
}
