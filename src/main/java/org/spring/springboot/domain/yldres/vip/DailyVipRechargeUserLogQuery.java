package org.spring.springboot.domain.yldres.vip;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-12-16 14:39
 */
public class DailyVipRechargeUserLogQuery {
    /**
     * 統計日期
     */
    private String countTime;
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

    public String getCountTime() {
        return countTime;
    }

    public void setCountTime(String countTime) {
        this.countTime = countTime;
    }

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
