package org.spring.springboot.domain.yldres.vip;

import java.io.Serializable;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-12-16 14:34
 */
public class DailyVipRechargeUserLogPO implements Serializable {
    
    private static final long serialVersionUID = 4421911530960036590L;
    /**
     * 自增主鍵
     */
    private Long id;
    /**
     * 活動次數
     */
    private Long vipRechargeCount;
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

    public Long getVipRechargeCount() {
        return vipRechargeCount;
    }

    public void setVipRechargeCount(Long vipRechargeCount) {
        this.vipRechargeCount = vipRechargeCount;
    }

    public String getCountTime() {
        return countTime;
    }

    public void setCountTime(String countTime) {
        this.countTime = countTime;
    }
}
