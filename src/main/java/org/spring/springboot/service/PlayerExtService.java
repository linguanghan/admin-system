package org.spring.springboot.service;

import org.spring.springboot.domain.pelbsData.playerext.PlayerExtQuery;
import org.spring.springboot.domain.pelbsData.playerext.PlayerExtVO;

import java.util.List;

public interface PlayerExtService {

    List<PlayerExtVO> queryPlayerExtVOs(PlayerExtQuery playerExtQuery);

    long countPlayerExtVOs(PlayerExtQuery playerExtQuery);

    /**
     *
     * 计算从启始时间到结束时间的充值人数
     * @param startTime
     * @param endTime
     * @author 13540
     * @date 2023-12-16 14:19 
     * @return long
     */
    Long countDailyPlayerRecharge(Long startTime, Long endTime);

}
