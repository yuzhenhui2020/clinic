package com.xiaoniucr.service.impl;

import com.xiaoniucr.common.vo.JSONReturn;
import com.xiaoniucr.common.vo.PageVo;
import com.xiaoniucr.entity.Bill;
import com.xiaoniucr.entity.Drug;
import com.xiaoniucr.entity.Recipe;
import com.xiaoniucr.mapper.BillMapper;
import com.xiaoniucr.mapper.DrugMapper;
import com.xiaoniucr.mapper.RecipeMapper;
import com.xiaoniucr.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 处方服务实现类
 */
@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeMapper recipeMapper;

    @Autowired
    private DrugMapper drugMapper;

    @Autowired
    private BillMapper billMapper;


    @Override
    public PageVo page(Map map) {
        List<Recipe> list = recipeMapper.findList(map);
        Integer total = recipeMapper.findTotal(map);
        return new PageVo(total,list);
    }

    @Override
    public JSONReturn save(Recipe recipe) {


        Recipe exist = recipeMapper.selectExist(recipe.getBillId(),recipe.getDrugId());
        if(exist != null){
            return JSONReturn.failed("该药品已在处方清单中！");
        }
        Drug drug = drugMapper.selectByPrimaryKey(recipe.getDrugId());
        if(drug.getStock() < recipe.getDrugNum()){
            return JSONReturn.failed("该药品库存不足！");
        }

        //药品数量扣除
        drug.setStock(drug.getStock() - recipe.getDrugNum());
        drugMapper.updateByPrimaryKeySelective(drug);

        //新增记录
        Date date = new Date();
        recipe.setSubtotal(recipe.getDrugNum() * drug.getPrice());
        recipe.setCreateTime(date);
        recipe.setUpdateTime(date);
        recipeMapper.insert(recipe);

        //统计总费用
        Double totalBill = recipeMapper.sumByBill(recipe.getBillId());
        Bill bill = new Bill();
        bill.setId(recipe.getBillId());
        bill.setTotalBill(totalBill);
        billMapper.updateByPrimaryKeySelective(bill);
        return JSONReturn.success("保存成功！");
    }

    @Override
    public JSONReturn update(Recipe recipe) {

        Recipe r = recipeMapper.selectByPrimaryKey(recipe.getId());
        if(r.getDrugId() != recipe.getDrugId()){
            Recipe exist = recipeMapper.selectExist(recipe.getBillId(),recipe.getDrugId());
            if(exist != null){
                return JSONReturn.failed("该药品已在处方清单中！");
            }
        }
        Drug drug = drugMapper.selectByPrimaryKey(r.getDrugId());
        //说明药品数量增加了
        if(r.getDrugNum() < recipe.getDrugNum()){
            //计算差额
            if(drug.getStock() < (recipe.getDrugNum() - r.getDrugNum())){
                return JSONReturn.failed("该药品库存不足！");
            }
        }
        //药品数量扣除
        drug.setStock(drug.getStock() - (recipe.getDrugNum() - r.getDrugNum()));
        drugMapper.updateByPrimaryKeySelective(drug);

        //重新小计费用
        recipe.setSubtotal(recipe.getDrugNum() * drug.getPrice());
        recipe.setUpdateTime(new Date());
        recipeMapper.updateByPrimaryKeySelective(recipe);

        //统计总费用
        Double totalBill = recipeMapper.sumByBill(recipe.getBillId());
        Bill bill = new Bill();
        bill.setId(recipe.getBillId());
        bill.setTotalBill(totalBill);
        billMapper.updateByPrimaryKeySelective(bill);
        return JSONReturn.success("保存成功！");
    }

    @Override
    public JSONReturn del(Integer id) {

        Recipe recipe = recipeMapper.selectByPrimaryKey(id);
        Drug drug = drugMapper.selectByPrimaryKey(recipe.getDrugId());
        recipeMapper.deleteByPrimaryKey(id);

        //药品数量恢复
        drug.setStock(drug.getStock() + recipe.getDrugNum());
        drugMapper.updateByPrimaryKeySelective(drug);

        //统计总费用
        Double totalBill = recipeMapper.sumByBill(recipe.getBillId());
        Bill bill = new Bill();
        bill.setId(recipe.getBillId());
        bill.setTotalBill(totalBill);
        billMapper.updateByPrimaryKeySelective(bill);

        return JSONReturn.success("删除成功！");
    }

    @Override
    public Recipe selectById(Integer id) {
        return recipeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Recipe> findByBill(Map map) {
        return recipeMapper.findByBill(map);
    }
}
