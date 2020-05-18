package com.gyb.spring.mongodb.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 分页model
 * @author GengYB
 *
 * @param <T>
 */
@Getter
@Setter
public class Pagination<T> {
    /***/
    private Integer pageNum;
    /***/
    private Integer pageSize;
    /***/
    private Long totalRows;
    /***/
    private Integer totalPage;
    /***/
    private List<T> data;
    private boolean hasNext;
    private boolean hasPrevious;
    private boolean isFirstPage;
    private boolean isLastPage;
    public static <T> Pagination<T> of(int pageNum,int pageSize,
                                       long totalRows,List<T> data){
        pageNum = pageNum>0?pageNum:1;
        pageSize = pageSize>0?pageSize:1;
        Pagination<T> page  = new Pagination<>();
        page.setPageSize(pageSize);
        page.setPageNum(pageNum);
        page.setTotalRows(totalRows);
        page.setTotalPage((int)Math.ceil((double)totalRows/pageSize));
        page.setData(data);
        page.setFirstPage(pageNum == 1);
        page.setLastPage(pageNum == page.getTotalPage());
        page.setHasNext(!page.isLastPage);
        page.setHasPrevious(!page.isFirstPage);
        return page;
    }
}
