package org.spring.springboot.dao.pelbsData;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.pelbsData.playerunit.PlayerRechargePO;
import org.spring.springboot.domain.pelbsData.playerunit.PlayerRechargeQuery;

import java.util.List;

public interface PlayerRechargeDao {

    List<PlayerRechargePO> queryPlayerRechargeInfoByOrderId(@Param("orderId") String orderId);

    List<PlayerRechargePO> batchQueryPlayerRechargeInfByUpdateTimeAndPid(@Param("playerRechargePOS") List<PlayerRechargePO> playerRechargePOS);

    List<PlayerRechargePO> queryPlayerRecharge(@Param("startTime") Long startTime, @Param("endTime") Long endTime);

    List<PlayerRechargePO> queryList(PlayerRechargeQuery query);
}