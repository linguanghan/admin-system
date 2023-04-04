package org.spring.springboot.dao.game;

import org.spring.springboot.domain.game.PlayerAgentInfo;

import java.util.List;

public interface PlayerAgentInfoDao {
    List<PlayerAgentInfo> fetchAgentInfos();

    void updateAgentState(PlayerAgentInfo playerAgentInfo);
}
