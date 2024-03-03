package org.spring.springboot.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.dao.pelbsData.PlayerAgentInfoDao;
import org.spring.springboot.domain.pelbsData.PlayerAgentInfo;
import org.spring.springboot.service.PlayerAgentInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class PlayerAgentInfoServiceImpl implements PlayerAgentInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerAgentInfoServiceImpl.class);

    private static final String FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String time_start_suffix = " 00:00:00";
    private static final String time_end_suffix = " 23:59:59";

    @Resource
    private PlayerAgentInfoDao playerAgentInfoDao;

    @Override
    public List<PlayerAgentInfo> fetchList() {
        return playerAgentInfoDao.fetchAgentInfos();
    }

    @Override
    public void updateAgentState(PlayerAgentInfo playerAgentInfo) {
        playerAgentInfoDao.updateAgentState(playerAgentInfo);
    }
}
