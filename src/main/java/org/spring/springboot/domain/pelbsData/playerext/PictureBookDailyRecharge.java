package org.spring.springboot.domain.pelbsData.playerext;

import java.util.Date;

public class PictureBookDailyRecharge {
    private Date timedate;
    private int num;
    private int fund;

    private String fTime;

    public String getfTime() {
        return fTime;
    }

    public void setfTime(String fTime) {
        this.fTime = fTime;
    }

    public Date getTimedate() {
        return timedate;
    }

    public void setTimedate(Date timedate) {
        this.timedate = timedate;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getFund() {
        return fund;
    }

    public void setFund(int fund) {
        this.fund = fund;
    }
}
