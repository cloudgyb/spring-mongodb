package com.gyb.ssm.domain;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * 分页model
 * @author GengYB
 *
 * @param <T>
 */
@Component
public class Pagination<T> {
    /***/
    private Integer pageSize;
    /***/
    private Integer totalRows;
    /***/
    private Integer totalPage;
    /***/
    private Integer currentPage;
    /***/
    private Integer startPage;
    /***/
    private List<T> datas;
    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    public Integer getTotalRows() {
        return totalRows;
    }
    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }
    public Integer getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
    public Integer getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
    public Integer getStartPage() {
        return startPage;
    }
    public void setStartPage(Integer startPage) {
        this.startPage = startPage;
    }
    public List<T> getDatas() {
        return datas;
    }
    public void setDatas(List<T> datas) {
        this.datas = datas;
    }
    
}
