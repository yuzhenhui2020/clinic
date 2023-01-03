package com.xiaoniucr.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 预约记录表
 * 对应表t_appoint
 * create by Lenovo
 */
public class Appoint implements Serializable {
    /**
     * 预约ID
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 号源ID
     */
    private Integer sourceId;

    /**
     * 状态：0已预约，1已就诊，2已取消
     */
    private Integer status;

    /**
     * 预约时间
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
     * 冗余字段 -- 开始时间
     */
    private String beginTime;


    /**
     * 冗余字段 -- 结束时间
     */
    private String endTime;

    /**
     * 冗余字段 -- 预约日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date planDate;


    /**
     * 冗余字段 -- 医生姓名
     */
    private String doctorNickname;


    /**
     * 冗余字段 -- 科室名称
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

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
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