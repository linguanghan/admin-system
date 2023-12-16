package org.spring.springboot.dao.game;

import generator.PlayerExample;
import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.game.DayPlayer;
import org.spring.springboot.domain.game.Player;
import org.spring.springboot.domain.game.playerext.PlayerExtDaoQuery;
import org.spring.springboot.domain.game.playerext.PlayerExtPO;
import org.spring.springboot.domain.game.playerext.PlayerExtQuery;

import java.util.List;

public interface PlayerExtDao {

    long countByExample(PlayerExtDaoQuery playerExtPO);

    List<PlayerExtPO> selectByExample(PlayerExtDaoQuery playerExtPO);

    long countDailyPlayerRecharge(@Param("startTime") Long startTime,
                                  @Param("endTime") Long endTime);
}