package org.spring.springboot.domain.pelbsData;

/**
 * 每日对应玩家充值数量
 *
 * @Author : zhoubin
 * @Date : 2022-12-27 11:24
 */
public class DayPlayerRecharge {

    private String timedate;
    private Integer num;
    private Integer rechargeNum;

    public DayPlayerRecharge() {
    }

    public DayPlayerRecharge(String timedate, Integer num, Integer rechargeNum) {
        this.timedate = timedate;
        this.num = num;
        this.rechargeNum = rechargeNum;
    }

    public String getTimedate() {
        return timedate;
    }

    public void setTimedate(String timedate) {
        this.timedate = timedate;
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
