package com.xiaoniucr.common.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * 分页参数
 */
public class PageQueryDto extends HashMap {

    /**
     * 每页几条
     */
    private Integer limit = 10;
    /**
     * 开始条数
     */
    private Integer start = 0;

    public PageQueryDto() {
    }

    public PageQueryDto(Map<String,Object> map){

        if(map.containsKey("pageSize")){
            limit = Integer.valueOf(map.get("pageSize").toString());
        }
        if(map.containsKey("pageNum")){
            Integer pageNum = Integer.parseInt(map.get("pageNum").toString());
            start = limit * (pageNum - 1);
        }
        this.putAll(map);
        this.remove("pageSize");
        this.remove("pageNum");
        this.put("start",start);
        this.put("limit",limit);
    }
}
