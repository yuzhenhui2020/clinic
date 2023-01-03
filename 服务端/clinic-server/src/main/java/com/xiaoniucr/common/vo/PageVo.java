package com.xiaoniucr.common.vo;

import java.util.List;

/**
 * 分页
 * @param <T>
 */
public class PageVo<T> {

    private Integer total;

    private List<T> records;


    public PageVo() {
    }

    public PageVo(Integer total, List<T> records) {
        this.total = total;
        this.records = records;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
