package org.spring.springboot.domain.game.feedback;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-10-22 7:39
 */
public class FeedBackVO {
    /**
     * 主键id
     */
    private long id;
    /**
     * 用户id
     */
    private long pid;
    /**
     * 评论内容
     */
    private String describe;
    /**
     * 评论时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time;

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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
