package org.spring.springboot.domain.pelbsData.playerext;

import java.io.Serializable;
import java.util.List;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-12-03 13:50
 */
public class PlayerExtVO implements Serializable {

    private static final long serialVersionUID = -6076437910845164644L;
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
    private String huibenVipOverdueTimeStr;
    /**
     * 绘本VIP购买时间-类型list
     */
    List<PlayerExtCreateTimeTypeEntity> playerExtCreateTimeTypeEntities;


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

    public String getHuibenVipOverdueTimeStr() {
        return huibenVipOverdueTimeStr;
    }

    public void setHuibenVipOverdueTimeStr(String huibenVipOverdueTimeStr) {
        this.huibenVipOverdueTimeStr = huibenVipOverdueTimeStr;
    }

    public List<PlayerExtCreateTimeTypeEntity> getPlayerExtCreateTimeTypeEntities() {
        return playerExtCreateTimeTypeEntities;
    }

    public void setPlayerExtCreateTimeTypeEntities(List<PlayerExtCreateTimeTypeEntity> playerExtCreateTimeTypeEntities) {
        this.playerExtCreateTimeTypeEntities = playerExtCreateTimeTypeEntities;
    }
}
