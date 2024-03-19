package org.spring.springboot.dao.pelbsData;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.pelbsData.playerext.PlayerExtDaoQuery;
import org.spring.springboot.domain.pelbsData.playerext.PlayerExtPO;
import org.spring.springboot.domain.yldres.vip.DailyVipRechargeUserLogPO;
import org.spring.springboot.domain.yldres.vip.DailyVipRechargeUserLogQuery;

import java.util.List;

public interface PlayerExtDao {

    long countByExample(PlayerExtDaoQuery playerExtPO);

    List<PlayerExtPO> selectByExample(PlayerExtDaoQuery playerExtPO);

    long countDailyPlayerRecharge(@Param("startTime") Long startTime,
                                  @Param("endTime") Long endTime);

    List<DailyVipRechargeUserLogPO> fetchDailyVipRechargeUserLogByPage(DailyVipRechargeUserLogQuery query);

    Integer fetchDailyVipRechargeUserLogByPageCount(DailyVipRechargeUserLogQuery query);
}