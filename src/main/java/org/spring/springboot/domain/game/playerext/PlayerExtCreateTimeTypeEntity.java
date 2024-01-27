package org.spring.springboot.domain.game.playerext;

import java.io.Serializable;

public class PlayerExtCreateTimeTypeEntity implements Serializable, Comparable<PlayerExtCreateTimeTypeEntity> {

    private static final long serialVersionUID = 2735938137094971541L;
    /**
     * 绘本VIP购买时间
     */
    private Integer createTime;
    /**
     * 绘本VIP购买时间(字符串类型)
     */
    private String createTimeStr;
    /**
     * 绘本VIP购买类型
     */
    private Integer type;


    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    @Override
    public int compareTo(PlayerExtCreateTimeTypeEntity o) {
        //按照时间降序排序
        return o.createTime - this.createTime;
    }
}
