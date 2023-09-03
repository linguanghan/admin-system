package org.spring.springboot.service;

import org.spring.springboot.bean.Option;
import org.spring.springboot.common.result.Result;
import org.spring.springboot.domain.game.playerunit.PlayerRechargeOperateVO;
import org.spring.springboot.domain.game.playerunit.PlayerRechargeQuery;
import org.spring.springboot.domain.game.playerunit.PlayerRechargeVO;
import org.spring.springboot.domain.game.playerunit.Playerunit;
import org.spring.springboot.domain.game.vo.PageParamVo;

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
    Result<?> findDetailBetweenDate(PageParamVo vo);

    // 用户购买特定版本
    Integer findPurchasePlayunitNum(Date dateTime);
    Integer findPurchaseNumBetweenDate(Date startTime, Date endTime);
    List<Playerunit> findPurchaseDetail(Date dateTime);
    Result<?> findPurchaseDetailBetweenDate(PageParamVo vo);

    // 特定版本查询
    Integer findVersionPlayunitNum(Date dateTime);
    Integer findVersionNumBetweenDate(Date startTime, Date endTime);
    List<Playerunit> findVersionDetail(Date dateTime);
    Result<?> findVersionDetailBetweenDate(PageParamVo vo);

    List<Option> getPlayerUnitOptionListByPid(Long pid);

    Result<?> queryRechargeByPage(PlayerRechargeQuery query);

    String changeRecharge(PlayerRechargeOperateVO playerRechargeOperateVO);
}
