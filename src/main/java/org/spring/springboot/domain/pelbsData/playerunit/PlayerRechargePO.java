package org.spring.springboot.domain.pelbsData.playerunit;

import lombok.Data;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-09-03 13:55
 */
@Data
public class PlayerRechargePO {
    /**
     * 自增主键
     */
    private Long id;
    /**
     * 玩家账号ID
     */
    private Long accountId;
    /**
     * 充值时间
     */
    private String updateTime;
    /**
     * 推荐人
     */
    private String refer;
    /**
     * 工会ID
     */
    private Long familyId;
    /**
     * 一级代理ID
     */
    private Integer oneLevelAgentsId;
    /**
     * 顶级代理ID
     */
    private Integer topAgentsId;
    /**
     * 价格
     */
    private Integer appPrice;
    /**
     * 订单id
     */
    private String orderId;
    /**
     * 账号id
     */
    private Long pid;
    /**
     * 账号昵称
     */
    private String name;

}
