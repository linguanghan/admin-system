package org.spring.springboot.domain.pelbsData;

/**
 * 每日对应新增玩家数
 *
 * @Author : zhoubin
 * @Date : 2022-12-27 11:24
 */
public class DayPlayer {
    private String timedate;
    private Integer num;

    public DayPlayer() {
    }

    public DayPlayer(String timedate, Integer num) {
        this.timedate = timedate;
        this.num = num;
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
}
