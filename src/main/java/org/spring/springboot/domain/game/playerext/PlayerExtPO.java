package org.spring.springboot.domain.game.playerext;

import java.io.Serializable;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-12-03 13:50
 */
public class PlayerExtPO implements Serializable {

    private static final long serialVersionUID = -4431664274469806983L;
    /**
     * 玩家ID
     */
    private Long id;
    /**
     * 玩家ID
     */
    private Long accountID;
    /**
     * 绘本VIP过期时间
     */
    private Integer huibenVipOverdueTime;
    /**
     * 绘本VIP购买时间1
     */
    private Integer createTime1;
    /**
     * 绘本VIP购买时间2
     */
    private Integer createTime2;
    /**
     * 绘本VIP购买时间3
     */
    private Integer createTime3;
    /**
     * 绘本VIP购买类型1
     */
    private Integer type1;
    /**
     * 绘本VIP购买类型2
     */
    private Integer type2;
    /**
     * 绘本VIP购买类型3
     */
    private Integer type3;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountID() {
        return accountID;
    }

    public void setAccountID(Long accountID) {
        this.accountID = accountID;
    }

    public Integer getHuibenVipOverdueTime() {
        return huibenVipOverdueTime;
    }

    public void setHuibenVipOverdueTime(Integer huibenVipOverdueTime) {
        this.huibenVipOverdueTime = huibenVipOverdueTime;
    }

    public Integer getCreateTime1() {
        return createTime1;
    }

    public void setCreateTime1(Integer createTime1) {
        this.createTime1 = createTime1;
    }

    public Integer getCreateTime2() {
        return createTime2;
    }

    public void setCreateTime2(Integer createTime2) {
        this.createTime2 = createTime2;
    }

    public Integer getCreateTime3() {
        return createTime3;
    }

    public void setCreateTime3(Integer createTime3) {
        this.createTime3 = createTime3;
    }

    public Integer getType1() {
        return type1;
    }

    public void setType1(Integer type1) {
        this.type1 = type1;
    }

    public Integer getType2() {
        return type2;
    }

    public void setType2(Integer type2) {
        this.type2 = type2;
    }

    public Integer getType3() {
        return type3;
    }

    public void setType3(Integer type3) {
        this.type3 = type3;
    }
}
