/**
 * @projectName: admin-system
 * @package: org.spring.springboot.domain.pelbs_data
 * @className: PlayerContorl
 * @author: Chen Dehong
 * @description: 实体类表示数据库表的信息
 * @date: 2/3/2024 9:21 PM
 * @version: 1.0
 */
package org.spring.springboot.domain.pelbsData;

import java.math.BigDecimal;

public class PlayerManagement {
    private Long id;
    private Integer state;
    private Long agentPid;
    private String agentName;
    private Integer createTime;
    private Integer userNum;
    private BigDecimal totalProfit;
    private BigDecimal curProfit;
    private Integer profitRatio;

    private Integer identity;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getAgentPid() {
        return agentPid;
    }

    public void setAgentPid(Long agentPid) {
        this.agentPid = agentPid;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getUserNum() {
        return userNum;
    }

    public void setUserNum(Integer userNum) {
        this.userNum = userNum;
    }

    public BigDecimal getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(BigDecimal totalProfit) {
        this.totalProfit = totalProfit;
    }

    public BigDecimal getCurProfit() {
        return curProfit;
    }

    public void setCurProfit(BigDecimal curProfit) {
        this.curProfit = curProfit;
    }

    public Integer getProfitRatio() {
        return profitRatio;
    }

    public void setProfitRatio(Integer profitRatio) {
        this.profitRatio = profitRatio;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }


    @Override
    public String toString() {
        return "PlayerManagement{" +
                "id=" + id +
                ", state=" + state +
                ", agentPid=" + agentPid +
                ", agentName='" + agentName + '\'' +
                ", createTime=" + createTime +
                ", userNum=" + userNum +
                ", totalProfit=" + totalProfit +
                ", curProfit=" + curProfit +
                ", profitRatio=" + profitRatio +
                ", identity=" + identity +
                '}';
    }
}
