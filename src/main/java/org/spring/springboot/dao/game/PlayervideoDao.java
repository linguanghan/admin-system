package org.spring.springboot.dao.game;

import generator.PlayervideoExample;
import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.game.Playervideo;

import java.util.List;

public interface PlayervideoDao {
    long countByExample(PlayervideoExample example);

    int deleteByExample(PlayervideoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Playervideo record);

    int insertSelective(Playervideo record);

    List<Playervideo> selectByExample(PlayervideoExample example);

    Playervideo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Playervideo record, @Param("example") PlayervideoExample example);

    int updateByExample(@Param("record") Playervideo record, @Param("example") PlayervideoExample example);

    int updateByPrimaryKeySelective(Playervideo record);

    int updateByPrimaryKey(Playervideo record);

    /*--------------以下为自定义查询----------------*/
//    Integer findNumBetweenDate(long start, long end);
//    List<Playerunit> findBetweenDate(long start, long end);
    Integer findNumBetweenDate(@Param("startTime") Long startTime, @Param("endTime") Long endTime);
    List<Playervideo> findBetweenDate(@Param("startTime") Long startTime, @Param("endTime") Long endTime);

}