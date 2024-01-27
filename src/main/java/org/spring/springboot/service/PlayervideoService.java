package org.spring.springboot.service;

import org.spring.springboot.common.result.Result;
import org.spring.springboot.domain.game.Playervideo;
import org.spring.springboot.domain.game.vo.PageParamVo;

import java.util.Date;
import java.util.List;

/**
 * Description
 *
 * @Author : zhoubin
 * @Date : 2023-01-15 14:55
 */
public interface PlayervideoService {
    Integer findPlayvideoNum(Date dateTime);

    Integer findNumBetweenDate(Date startTime, Date endTime);

    List<Playervideo> findDetail(Date dateTime);

    Result<?> findDetailBetweenDate(PageParamVo vo);
}
