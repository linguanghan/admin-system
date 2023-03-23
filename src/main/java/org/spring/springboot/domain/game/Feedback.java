package org.spring.springboot.domain.game;

public class Feedback {
    private long id;
    private long pid;
    private String describe;

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

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", pid=" + pid +
                ", describe='" + describe + '\'' +
                '}';
    }
}

