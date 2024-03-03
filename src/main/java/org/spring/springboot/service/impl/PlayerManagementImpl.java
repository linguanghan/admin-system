/**
 * @projectName:    admin-system
 * @package:        org.spring.springboot.service.impl
 * @className:      PlayerManagementImpl
 * @author:     Chen Dehong
 * @description:
 * @date:    2/4/2024 11:56 AM
 * @version:    1.0
 */
package org.spring.springboot.service.impl;

import cn.hutool.core.collection.ListUtil;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.bean.Option;
import org.spring.springboot.common.result.Result;
import org.spring.springboot.dao.pelbsData.PlayerManagementDao;
import org.spring.springboot.domain.pelbsData.PlayerManagement;
import org.spring.springboot.domain.pelbsData.vo.PagePlayerParamVO;;
import org.spring.springboot.service.PlayerManagementService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Date;

@Service
public class PlayerManagementImpl implements PlayerManagementService{
    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerManagementImpl.class);

    private static final String FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String time_start_suffix = " 00:00:00";
    private static final String time_end_suffix = " 23:59:59";
    @Resource
    private PlayerManagementDao PlayerManagementDao;
    @Override
    public Result<?> fetchList(PagePlayerParamVO vo) {
        List<PlayerManagement> playerResources = Collections.emptyList();

//        LOGGER.info("PlayerManagementImpl#fetchList vo is {}, {}, {}, {}", vo.getPlayerId(), vo.getPlayerName(), vo.getPageNo(), vo.getPageSize());

        if (StringUtils.isEmpty(vo.getAgentName()) && StringUtils.isEmpty(vo.getAgentPid())) {
            playerResources = PlayerManagementDao.fetchPlayerManagementInfos();
        }

        if (!StringUtils.isEmpty(vo.getAgentName()) && StringUtils.isEmpty(vo.getAgentPid())) {
            playerResources = PlayerManagementDao.fetchPlayerManagementInfosByName(vo.getAgentName());
        }

        if(StringUtils.isEmpty(vo.getAgentName()) && !StringUtils.isEmpty(vo.getAgentPid())) {
            playerResources = PlayerManagementDao.fetchPlayerManagementInfosByPlayerId(vo.getAgentPid());
        }

        return Result.buildSuccess().add("data", ListUtil.page(vo.getPageNo() - 1, vo.getPageSize(), playerResources)).add("total", playerResources.size());

    }

    @Override
    public List<PlayerManagement> fetchListByName(String name) {
        return PlayerManagementDao.fetchPlayerManagementInfosByName(name);
    }

    @Override
    public List<PlayerManagement> fetchListByPlayerId(String playerId) {
        return PlayerManagementDao.fetchPlayerManagementInfosByPlayerId(playerId);
    }

    @Override
    public List<PlayerManagement> searchPlayerlist(String name, String playerId, String keyword) {
        if (!Strings.isEmpty(name)) {
            return PlayerManagementDao.fetchPlayerManagementInfosByName(name);
        }
        else if(!Strings.isEmpty(playerId)) {
            return PlayerManagementDao.fetchPlayerManagementInfosByPlayerId(playerId);
        }
        else if(!Strings.isEmpty(keyword)) {
            return PlayerManagementDao.searchPlayerlist(keyword);
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePlayerInfo(PlayerManagement playerInfo) {
        PlayerManagementDao.updatePlayerManagementInfo(playerInfo);
        PlayerManagementDao.updatePlayerIdentityInfo(playerInfo);
    }

    @Override
    public void deletePlayerInfo(PlayerManagement playerInfo) {
        PlayerManagementDao.deletePlayerManagementInfo(playerInfo);
        PlayerManagementDao.deletePlayerIdentityInfo(playerInfo);
    }

    @Override
    public void savePlayerManagementInfo(PlayerManagement playerInfo) {

        if (playerInfo.getCreateTime() == null) {
            long currentTimestamp = System.currentTimeMillis() / 1000L; // 转换为十位数时间戳
            playerInfo.setCreateTime((int) currentTimestamp);
        }


        PlayerManagementDao.savePlayerManagementInfo(playerInfo);
    }

    @Override
    public List<Option> queryPlayerResourceOptions() {
        List<PlayerManagement> playerManagements = PlayerManagementDao.fetchPlayerManagementInfos();
        if (CollectionUtils.isEmpty(playerManagements)) {
            return Collections.emptyList();
        }
        return playerManagements.stream().map(playerManagement -> {
            Option option = new Option();
            option.setLabel("【" + playerManagement.getAgentPid() + "】" + playerManagement.getAgentName());
            option.setValue(String.valueOf(playerManagement.getAgentPid()));
            return option;
        }).collect(Collectors.toList());
    }

    @Override
    public Map<Long, PlayerManagement> fetchPlayerResourceByIds(List<Long> playerIds) {
        List<PlayerManagement> playerManagements = PlayerManagementDao.batchQueryPlayerManagementInfosByIds(playerIds);
        if (CollectionUtils.isEmpty(playerManagements)) {
            return new HashMap<>();
        }
        return playerManagements.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(PlayerManagement::getAgentPid, v -> v, (k1, k2) -> k1));
    }
}
