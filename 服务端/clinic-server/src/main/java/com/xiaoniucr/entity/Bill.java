package com.xiaoniucr.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 账单信息表
 * 对应表t_bill
 * create by Lenovo
 */
public class Bill implements Serializable {
    /**
     * 处方账单ID
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 医生ID
     */
    private Integer doctorId;

    /**
     * 开具日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date invoiceDate;

    /**
     * 总费用
     */
    private Double totalBill;

    /**
     * 状态：0待缴，1已缴
     */
    private Integer status;


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


    /**
     * 冗余字段 -- 病人姓名
     */
    private String patientNickname;

    /**
     * 冗余字段 -- 医生姓名
     */
    private String doctorNickname;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(Double totalBill) {
        this.totalBill = totalBill;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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


    public String getPatientNickname() {
        return patientNickname;
    }

    public void setPatientNickname(String patientNickname) {
        this.patientNickname = patientNickname;
    }

    public String getDoctorNickname() {
        return doctorNickname;
    }

    public void setDoctorNickname(String doctorNickname) {
        this.doctorNickname = doctorNickname;
    }
}