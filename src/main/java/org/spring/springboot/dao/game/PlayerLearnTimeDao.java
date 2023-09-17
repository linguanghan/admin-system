package org.spring.springboot.dao.game;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.game.palyerlearntime.PlayerLearnTimePO;
import org.spring.springboot.domain.game.playerunit.Playerunit;

import java.util.List;


public interface PlayerLearnTimeDao {

    List<PlayerLearnTimePO> batchQueryPlayerLearnTimeInfoByPidAndBookIdx(@Param("poList") List<PlayerLearnTimePO> poList);

    int updateByPrimaryKey(PlayerLearnTimePO playerLearnTimePO);

}