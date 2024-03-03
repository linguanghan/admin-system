package org.spring.springboot.service;

import org.spring.springboot.bean.Option;
import org.spring.springboot.common.result.Result;
import org.spring.springboot.domain.pelbsData.PackageQuery;
import org.spring.springboot.domain.pelbsData.playerunit.*;
import org.spring.springboot.domain.pelbsData.vo.PageParamVo;

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

    /**
     *
     * 更新书本锁定状态
     * @author 13540
     * @date 2023-09-10 13:20
     * @return java.lang.String
     */
    Integer updateUnlockStatus(PlayerRechargeUnLockQuery playerRechargeUnLockQuery);

    /**
     *
     * 用户添加自己的书本（后台）
     * @author 13540
     * @date 2023-09-17 15:24
     * @return boolean
     */
    String addBookUnit(PlayerUnitQuery query);

    /**
     *
     * 更新用户购买书本的使用时间和学习时长
     * @param query
     * @author 13540
     * @date 2023-09-17 15:44
     * @return boolean
     */
    void updateBookUnitUpdateTimeOrLearnTime(PlayerUnitLearnQuery query);

    List<Option> queryBookResourceOptions(Long pid);

    List<PackageQuery> queryPackageIdxRecharge(Long packageIdx, Date starTime, Date endTime);
}
