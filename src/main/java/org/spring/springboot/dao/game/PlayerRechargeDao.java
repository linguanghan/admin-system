package org.spring.springboot.dao.game;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.game.playerunit.PlayerRechargePO;

import java.util.List;

public interface PlayerRechargeDao {

    List<PlayerRechargePO> queryPlayerRechargeInfoByOrderId(@Param("orderId") String orderId);

}