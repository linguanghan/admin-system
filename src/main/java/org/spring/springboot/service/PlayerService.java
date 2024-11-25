package org.spring.springboot.service;

import org.spring.springboot.common.result.Result;
import org.spring.springboot.domain.pelbsData.DayPlayer;
import org.spring.springboot.domain.pelbsData.Player;
import org.spring.springboot.domain.pelbsData.vo.PageParamVo;

import java.util.Date;
import java.util.List;

/**
 * 玩家类相关接口服务
 *
 * @Author : zhoubin
 * @Date : 2022-12-20 14:50
 */
public interface PlayerService {
    /**
     * 根据时间查询注册用户
     *
     * @param startTime
     * @param endTime
     * @return
     */
//    List<Player> findPlyersBetweenTime(Date startTime, Date endTime);
//
//    Integer findPlyersBetweenTimeNum(Date startTime, Date endTime);
//
//    List<Player> findPlyersHistory(Date startTime, Date endTime);
//
//    List<Player> findPlyersCurrent(Date startTime);
//
//    Integer findPlyersHistoryNum(Date startTime, Date endTime);
//
//    Integer findPlyersCurrentNum(Date startTime);
//
//    List<DayPlayer> findPlyersHistoryNumLast30Days();

    /**
     * 查询某日期注册人数
     * @param dateTime
     * @return 注册人数
     */
    Integer findRegisterNum(Date dateTime);

    /**
     * 查询两个日期之间注册人数
     * @param startTime
     * @param endTime
     * @return 注册人数
     */
    Integer findRegisterNumBetweenDate(Date startTime, Date endTime);

    /**
     * 查询某日期注册人的详情
     * @param dateTime
     * @return 详细信息
     */
    List<Player> findRegisterDetail(Date dateTime);

    /**
     * 查询该日期范围注册人员详情
     * @param vo => startTime
     * @param vo => endTime
     * @return 详细信息
     */
    Result<?> findRegisterDetailBetweenDate(PageParamVo vo);

    /**
     * 查询该日期范围注册人数--按天归类
     * @param startTime
     * @param endTime
     * @return
     */
    List<DayPlayer> findRegisterNumGroupbyDate(Date startTime, Date endTime);

    /**一下查询活跃人数，类似注册人数查询逻辑**/
    Integer findActiveNum(Date dateTime);
    Integer findActiveNumBetweenDate(Date startTime, Date endTime);
    List<Player> findActiveDetail(Date dateTime);
    Result<?> findActiveDetailBetweenDate(PageParamVo vo);
    List<DayPlayer> findActiveNumGroupbyDate(Date startTime, Date endTime);
    List<DayPlayer> findActiveNumGroupbyMonth(Date startTime, Date endTime);

    /**
     * 根据id获取用户信息
     *
     * @param playerId
     * @author 13540
     * @date 2024-03-03 15:40
     * @return org.spring.springboot.domain.pelbsData.Player
     */

    Player getPlayerInfoById(Long playerId);
}
