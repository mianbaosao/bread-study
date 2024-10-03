package com.mianbao.subject.common.entity;

import lombok.Data;

/**
 * @Description: 分页请求
 * @Author:bread
 * @Date: 2024-09-02 19:55
 */
@Data
public class PageInfo {

    private Integer pageNo=1;

    private Integer pageSize=20;

    public Integer getPageNo(){
        if(pageNo==null||pageNo<1){
            return 1;
        }
        return pageNo;
    }

    public Integer getPageSize(){
        if(pageSize==null||pageSize<1||pageSize>Integer.MAX_VALUE){
            return 20;
        }
        return pageSize;
    }
}
