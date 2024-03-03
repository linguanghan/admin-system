package org.spring.springboot.dao.pelbsData;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.pelbsData.playerunit.PlayerRechargePO;

import java.util.List;

public interface PlayerRechargeDao {

    List<PlayerRechargePO> queryPlayerRechargeInfoByOrderId(@Param("orderId") String orderId);

    List<PlayerRechargePO> batchQueryPlayerRechargeInfByUpdateTimeAndPid(@Param("playerRechargePOS") List<PlayerRechargePO> playerRechargePOS);

}