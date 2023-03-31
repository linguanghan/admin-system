package org.spring.springboot.service;

import org.spring.springboot.domain.game.PlayerAgentInfo;

import java.util.List;

public interface PlayerAgentInfoService {
    List<PlayerAgentInfo> fetchList();

    void updateAgentState(PlayerAgentInfo playerAgentInfo);
}
