package org.spring.springboot.dao.game;

import generator.PlayerExample;
import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.game.Player;
import org.spring.springboot.domain.game.DayPlayer;

import java.util.List;

public interface PlayerDao {
    long countByExample(PlayerExample example);

    int deleteByExample(PlayerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Player record);

    int insertSelective(Player record);

    List<Player> selectByExample(PlayerExample example);

    Player selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Player record, @Param("example") PlayerExample example);

    int updateByExample(@Param("record") Player record, @Param("example") PlayerExample example);

    int updateByPrimaryKeySelective(Player record);

    int updateByPrimaryKey(Player record);

    /*--------------以下为自定义查询----------------*/
    Integer findRegisterNumBetweenDate(@Param("startTime") Long startTime, @Param("endTime") Long endTime);
    List<Player> findRegistersBetweenDate(@Param("startTime") Long startTime, @Param("endTime") Long endTime);
    List<DayPlayer> findRegisterNumGroupbyDate(@Param("startTime") Long startTime, @Param("endTime") Long endTime);

    Integer findActiveNumBetweenDate(@Param("startTime") Long startTime, @Param("endTime") Long endTime);
    List<Player> findActiveBetweenDate(@Param("startTime") Long startTime, @Param("endTime") Long endTime);
    List<DayPlayer> findActiveNumGroupbyDate(@Param("startTime") Long startTime, @Param("endTime") Long endTime);


    List<Player> findPlyersBetweenTime(@Param("startTime") Long startTime, @Param("endTime") Long endTime);

    Integer findPlyersBetweenTimeNum(@Param("startTime") Long startTime, @Param("endTime") Long endTime);

    List<DayPlayer> findPlyersHistoryNumLast30Days(@Param("startTime") Long startTime, @Param("endTime") Long endTime);


}