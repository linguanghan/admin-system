package org.spring.springboot.dao.pelbsData;

import org.spring.springboot.domain.pelbsData.PlayerAgentInfo;

import java.util.List;

public interface PlayerAgentInfoDao {
    List<PlayerAgentInfo> fetchAgentInfos();

    void updateAgentState(PlayerAgentInfo playerAgentInfo);
}
