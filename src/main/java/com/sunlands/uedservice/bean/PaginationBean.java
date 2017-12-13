package com.sunlands.uedservice.bean;

import com.sunlands.uedservice.po.Root;

import java.util.List;

/**
 * @Author : lvpenghui
 * @Description : 分页返回的bean
 * @Date : Created in 18:07 2017/12/12
 * @ModifiedBy :
 */
public class PaginationBean {

    private int pageCount;
    private int pageSize;
    private int maxRecord;
    List list;



    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getMaxRecord() {
        return maxRecord;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public void setMaxRecord(int maxRecord) {
        this.maxRecord = maxRecord;
    }
}
