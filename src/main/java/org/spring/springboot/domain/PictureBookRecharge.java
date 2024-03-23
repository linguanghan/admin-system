package org.spring.springboot.domain;

public class PictureBookRecharge {
    private String timedate;
    private Integer num;
    private Integer fund;


    public PictureBookRecharge() {
    }

    public PictureBookRecharge(String timedate, Integer num, Integer fund) {
        this.timedate = timedate;
        this.num = num;
        this.fund = fund;
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

    public Integer getFund() {
        return fund;
    }

    public void setFund(Integer fund) {
        this.fund = fund;
    }

}
