/**
 * @projectName: admin-system
 * @package: org.spring.springboot.domain.pelbs_data.vo
 * @className: PagePlayerParamVO
 * @author: Chen Dehong
 * @description: 分页查询玩家信息的参数
 * @date: 2/4/2024 1:28 PM
 * @version: 1.0
 */
package org.spring.springboot.domain.pelbsData.vo;

import java.io.Serializable;

public class PagePlayerParamVO implements Serializable{

    private static final long serialVersionUID = 2850352033085414364L;
    /**
     * 当前页
     */
    private Integer pageNo = 1;
    /**
     * 页码
     */
    private Integer pageSize = 20;
    /**
     * 玩家名称
     */
    private String agentName;
    /**
     * 玩家编号
     */
    private String agentPid;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentPid() {
        return agentPid;
    }

    public void setAgentPid(String agentPid) {
        this.agentPid = agentPid;
    }
}
