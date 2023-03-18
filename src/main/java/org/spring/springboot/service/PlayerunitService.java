package org.spring.springboot.service;

import org.spring.springboot.domain.game.Playerunit;

import java.util.Date;
import java.util.List;

/**
 * Description
 *
 * @Author : zhoubin
 * @Date : 2023-01-15 12:46
 */
public interface PlayerunitService {
    // 绘本
    Integer findPlayunitNum(Date dateTime);
    Integer findNumBetweenDate(Date startTime, Date endTime);
    List<Playerunit> findDetail(Date dateTime);
    List<Playerunit> findDetailBetweenDate(Date startTime, Date endTime);

    // 用户购买特定版本
    Integer findPurchasePlayunitNum(Date dateTime);
    Integer findPurchaseNumBetweenDate(Date startTime, Date endTime);
    List<Playerunit> findPurchaseDetail(Date dateTime);
    List<Playerunit> findPurchaseDetailBetweenDate(Date startTime, Date endTime);

    // 特定版本查询
    Integer findVersionPlayunitNum(Date dateTime);
    Integer findVersionNumBetweenDate(Date startTime, Date endTime);
    List<Playerunit> findVersionDetail(Date dateTime);
    List<Playerunit> findVersionDetailBetweenDate(Date startTime, Date endTime);
}
