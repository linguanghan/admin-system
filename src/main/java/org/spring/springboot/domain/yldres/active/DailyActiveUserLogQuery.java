package org.spring.springboot.domain.yldres.active;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-07-22 14:39
 */
public class DailyActiveUserLogQuery {
    /**
     * 統計日期
     */
//    private String countTime;
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }


//    public String getCountTime() {
//        return countTime;
//    }

//    public void setCountTime(String countTime) {
//        this.countTime = countTime;
//    }

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
