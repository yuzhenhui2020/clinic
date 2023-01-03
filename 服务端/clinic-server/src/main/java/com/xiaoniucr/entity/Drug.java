package com.xiaoniucr.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 药品信息表
 * 对应表t_drug
 * create by Lenovo
 */
public class Drug implements Serializable {
    /**
     * 药品ID
     */
    private Integer id;

    /**
     * 药品编号
     */
    private String drugNo;

    /**
     * 药品名称
     */
    private String drugName;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 单价
     */
    private Double price;

    /**
     * 包装单位
     */
    private String unit;

    /**
     * 用法：0口服，1注射
     */
    private Integer useway;

    /**
     * 备注
     */
    private String remark;

    /**
     * 录入时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDrugNo() {
        return drugNo;
    }

    public void setDrugNo(String drugNo) {
        this.drugNo = drugNo == null ? null : drugNo.trim();
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName == null ? null : drugName.trim();
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
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
        this.unit = unit == null ? null : unit.trim();
    }

    public Integer getUseway() {
        return useway;
    }

    public void setUseway(Integer useway) {
        this.useway = useway;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
}