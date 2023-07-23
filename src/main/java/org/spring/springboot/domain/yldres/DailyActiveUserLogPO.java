package org.spring.springboot.domain.yldres;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-07-22 14:30
 */
public class DailyActiveUserLogPO {
    /**
     * 自增主鍵
     */
    private Long id;
    /**
     * 活動次數
     */
    private Long activeCount;
    /**
     * 統計日期
     */
    private String countTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getActiveCount() {
        return activeCount;
    }

    public void setActiveCount(Long activeCount) {
        this.activeCount = activeCount;
    }

    public String getCountTime() {
        return countTime;
    }

    public void setCountTime(String countTime) {
        this.countTime = countTime;
    }
}
