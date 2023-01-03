package com.xiaoniucr.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 处方信息表
 * 对应表t_recipe
 * create by Lenovo
 */
public class Recipe implements Serializable {
    /**
     * 处方ID
     */
    private Integer id;

    /**
     * 账单ID
     */
    private Integer billId;

    /**
     * 药品ID
     */
    private Integer drugId;

    /**
     * 药品数量
     */
    private Integer drugNum;

    /**
     * 小计
     */
    private Double subtotal;

    /**
     * 添加时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


    /**
     * 冗余字段 -- 药品名称
     */
    private String drugName;


    /**
     * 冗余字段 -- 药品单价
     */
    private Double price;

    /**
     * 冗余字段 -- 药品单位
     */
    private String unit;


    /**
     * 冗余字段 -- 使用方式
     */
    private Integer useway;



    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }

    public Integer getDrugNum() {
        return drugNum;
    }

    public void setDrugNum(Integer drugNum) {
        this.drugNum = drugNum;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getUseway() {
        return useway;
    }

    public void setUseway(Integer useway) {
        this.useway = useway;
    }
}