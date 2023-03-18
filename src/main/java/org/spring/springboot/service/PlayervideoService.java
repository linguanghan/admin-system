package org.spring.springboot.service;

import org.spring.springboot.domain.game.Playervideo;

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

    List<Playervideo> findDetailBetweenDate(Date startTime, Date endTime);
}
