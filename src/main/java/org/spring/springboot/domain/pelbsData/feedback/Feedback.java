package org.spring.springboot.domain.pelbsData.feedback;

public class Feedback {
    private long id;
    private long pid;
    private String describe;

    private Integer time;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", pid=" + pid +
                ", describe='" + describe +
                ", time='" + time + '\'' +
                '}';
    }
}

