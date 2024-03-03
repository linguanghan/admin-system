package org.spring.springboot.domain.pelbsData;

public class PackageQuery {
    private String timedate;
    private Integer num;

    public PackageQuery() {
    }

    public PackageQuery(String timedate, Integer num) {
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
