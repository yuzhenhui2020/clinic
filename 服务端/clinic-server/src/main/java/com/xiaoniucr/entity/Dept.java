package com.xiaoniucr.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 科室信息表
 * 对应表t_dept
 * create by Lenovo
 */
public class Dept implements Serializable {
    /**
     * 科室ID
     */
    private Integer id;

    /**
     * 科室名称
     */
    private String deptName;

    /**
     * 科室备注
     */
    private String remark;

    /**
     * 录入时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
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