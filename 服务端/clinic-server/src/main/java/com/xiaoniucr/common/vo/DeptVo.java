package com.xiaoniucr.common.vo;

/**
 * 科室人员统计
 */
public class DeptVo {

    /**
     * 科室名称
     */
    private String deptName;

    /**
     * 科室人员
     */
    private Integer totalNum;



    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }
}
