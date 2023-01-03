package com.xiaoniucr.common.vo;

import com.xiaoniucr.entity.Notice;

import java.util.List;

/**
 * 系统统计
 */
public class CountVo {

    /**
     * 科室统计
     */
    private List<DeptVo> deptList;

    /**
     * 最新公告
     */
    private List<Notice> noticeList;

    /**
     * 过去12个月份
     */
    private String[] dateList;

    /**
     * 营业额
     */
    private List<Double> amountList;


    public List<DeptVo> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<DeptVo> deptList) {
        this.deptList = deptList;
    }

    public List<Notice> getNoticeList() {
        return noticeList;
    }

    public void setNoticeList(List<Notice> noticeList) {
        this.noticeList = noticeList;
    }

    public String[] getDateList() {
        return dateList;
    }

    public void setDateList(String[] dateList) {
        this.dateList = dateList;
    }

    public List<Double> getAmountList() {
        return amountList;
    }

    public void setAmountList(List<Double> amountList) {
        this.amountList = amountList;
    }
}
