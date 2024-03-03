package org.spring.springboot.domain.pelbsData;

public class PlayerAgentInfo {
    private Long id;
    private Integer state;
    private Long agentPid;
    private String agentName;

    private Integer createTime;
    private Integer userNum;
    private Double totalProfit;
    private Double curProfit;

    public PlayerAgentInfo() {
    }

    public PlayerAgentInfo(long id, int state, long agentPid, String agentName, int createTime, int userNum, double totalProfit, double curProfit) {
        this.id = id;
        this.state = state;
        this.agentPid = agentPid;
        this.agentName = agentName;
        this.createTime = createTime;
        this.userNum = userNum;
        this.totalProfit = totalProfit;
        this.curProfit = curProfit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public long getAgentPid() {
        return agentPid;
    }

    public void setAgentPid(long agentPid) {
        this.agentPid = agentPid;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public int getUserNum() {
        return userNum;
    }

    public void setUserNum(int userNum) {
        this.userNum = userNum;
    }

    public double getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(double totalProfit) {
        this.totalProfit = totalProfit;
    }

    public double getCurProfit() {
        return curProfit;
    }

    public void setCurProfit(double curProfit) {
        this.curProfit = curProfit;
    }

    @Override
    public String toString() {
        return "PlayerAgentInfo{" +
                "id=" + id +
                ", state=" + state +
                ", agentPid=" + agentPid +
                ", agentName='" + agentName + '\'' +
                ", createTime=" + createTime +
                ", userNum=" + userNum +
                ", totalProfit=" + totalProfit +
                ", curProfit=" + curProfit +
                '}';
    }
}
