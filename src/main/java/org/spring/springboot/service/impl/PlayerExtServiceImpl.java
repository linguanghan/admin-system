package org.spring.springboot.service.impl;

import org.spring.springboot.dao.pelbsData.PlayerExtDao;
import org.spring.springboot.domain.pelbsData.playerext.*;
import org.spring.springboot.service.PlayerExtService;
import org.spring.springboot.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-12-03 14:17
 */
@Service
public class PlayerExtServiceImpl implements PlayerExtService {

    @Autowired
    private PlayerExtDao playerExtDao;

    private static final String LENGTH_10 = "LENGTH_10";

    @Override
    public List<PlayerExtVO> queryPlayerExtVOs(PlayerExtQuery playerExtQuery) {
        PlayerExtDaoQuery playerExtDaoQuery = new PlayerExtDaoQuery();
        BeanUtils.copyProperties(playerExtQuery, playerExtDaoQuery);
        playerExtDaoQuery.setPage(playerExtQuery.getPageNo());
        List<PlayerExtPO> playerExtPOS = playerExtDao.selectByExample(playerExtDaoQuery);
        if(CollectionUtils.isEmpty(playerExtPOS)) {
            return Collections.emptyList();
        }

        List<PlayerExtVO> playerExtVOS = new ArrayList<>();
        for (PlayerExtPO playerExtPO : playerExtPOS) {
            List<PlayerExtCreateTimeTypeEntity> playerExtCreateTimeTypeEntities = new ArrayList<>();
            PlayerExtCreateTimeTypeEntity playerExtCreateTimeTypeEntity1 = new PlayerExtCreateTimeTypeEntity();
            playerExtCreateTimeTypeEntity1.setCreateTime(playerExtPO.getCreateTime1());
            playerExtCreateTimeTypeEntity1.setType(playerExtPO.getType1());
            playerExtCreateTimeTypeEntity1.setCreateTimeStr(DateUtil.timeStamp2Str(playerExtPO.getCreateTime1(), LENGTH_10));
            playerExtCreateTimeTypeEntities.add(playerExtCreateTimeTypeEntity1);
            PlayerExtCreateTimeTypeEntity playerExtCreateTimeTypeEntity2 = new PlayerExtCreateTimeTypeEntity();
            playerExtCreateTimeTypeEntity2.setCreateTime(playerExtPO.getCreateTime2());
            playerExtCreateTimeTypeEntity2.setType(playerExtPO.getType2());
            playerExtCreateTimeTypeEntity2.setCreateTimeStr(DateUtil.timeStamp2Str(playerExtPO.getCreateTime2(), LENGTH_10));
            playerExtCreateTimeTypeEntities.add(playerExtCreateTimeTypeEntity2);
            PlayerExtCreateTimeTypeEntity playerExtCreateTimeTypeEntity3 = new PlayerExtCreateTimeTypeEntity();
            playerExtCreateTimeTypeEntity3.setCreateTime(playerExtPO.getCreateTime3());
            playerExtCreateTimeTypeEntity3.setCreateTimeStr(DateUtil.timeStamp2Str(playerExtPO.getCreateTime3(), LENGTH_10));
            playerExtCreateTimeTypeEntity3.setType(playerExtPO.getType3());
            playerExtCreateTimeTypeEntities.add(playerExtCreateTimeTypeEntity3);
            // 排序
            Collections.sort(playerExtCreateTimeTypeEntities);
            PlayerExtVO playerExtVO = new PlayerExtVO();
            BeanUtils.copyProperties(playerExtPO, playerExtVO);
            playerExtVO.setHuibenVipOverdueTimeStr(DateUtil.timeStamp2Str(playerExtPO.getHuibenVipOverdueTime(), LENGTH_10));
            playerExtVO.setPlayerExtCreateTimeTypeEntities(playerExtCreateTimeTypeEntities);
            playerExtVOS.add(playerExtVO);
        }
        return playerExtVOS;
    }



    @Override
    public long countPlayerExtVOs(PlayerExtQuery playerExtQuery) {
        PlayerExtDaoQuery playerExtDaoQuery = new PlayerExtDaoQuery();
        playerExtDaoQuery.setPage(playerExtQuery.getPageNo());
        BeanUtils.copyProperties(playerExtQuery, playerExtDaoQuery);
        return playerExtDao.countByExample(playerExtDaoQuery);
    }

    @Override
    public Long countDailyPlayerRecharge(Long startTime, Long endTime) {
        if(startTime == null || endTime == null) {
            return 0L;
        }
        return playerExtDao.countDailyPlayerRecharge(startTime, endTime);
    }
}
