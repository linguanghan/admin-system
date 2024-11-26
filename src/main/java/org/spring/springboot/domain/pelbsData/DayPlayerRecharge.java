package org.spring.springboot.domain.pelbsData;

/**
 * 每日对应玩家充值数量
 *
 * @Author : zhoubin
 * @Date : 2022-12-27 11:24
 */
public class DayPlayerRecharge {

    private String timeDate;
    private Integer num;
    private Integer rechargeNum;

    public DayPlayerRecharge() {
    }

    public DayPlayerRecharge(String timeDate, Integer num, Integer rechargeNum) {
        this.timeDate = timeDate;
        this.num = num;
        this.rechargeNum = rechargeNum;
    }

    public String getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(String timeDate) {
        this.timeDate = timeDate;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getRechargeNum() {
        return rechargeNum;
    }

    public void setRechargeNum(Integer rechargeNum) {
        this.rechargeNum = rechargeNum;
    }
}
