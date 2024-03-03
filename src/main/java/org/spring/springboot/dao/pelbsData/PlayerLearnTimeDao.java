package org.spring.springboot.dao.pelbsData;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.pelbsData.palyerlearntime.PlayerLearnTimePO;

import java.util.List;


public interface PlayerLearnTimeDao {

    List<PlayerLearnTimePO> batchQueryPlayerLearnTimeInfoByPidAndBookIdx(@Param("poList") List<PlayerLearnTimePO> poList);

    int updateByPrimaryKey(PlayerLearnTimePO playerLearnTimePO);

}