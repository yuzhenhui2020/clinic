package com.xiaoniucr.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 就诊记录（病历）
 * 对应表t_history
 * create by Lenovo
 */
public class History implements Serializable {
    /**
     * 就诊记录（病历）ID
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
     * 就诊日期（一般是预约的日期）
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date visitDate;

    /**
     * 病情记录
     */
    private String content;

    /**
     * 添加时间
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


    /**
     * 冗余字段 -- 部门
     */
    private String deptName;

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

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}