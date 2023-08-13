package org.spring.springboot.domain.yldres.page;

import java.io.Serializable;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-07-29 13:37
 */
public class PageEventTrackLogQuery implements Serializable {

    private static final long serialVersionUID = -8641013681049477229L;

    /**
     * 頁數
     */
    private Integer pageNo = 1;
    /**
     *
     * 起始數據
     */
    private Integer startRow;
    /**
     * 頁大小
     */
    private Integer pageSize = 10;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getStartRow() {
        this.startRow = (pageNo - 1) * pageSize;
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}


