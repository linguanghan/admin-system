package org.spring.springboot.dao.yldres;

import org.spring.springboot.domain.yldres.vip.DailyVipRechargeUserLogPO;
import org.spring.springboot.domain.yldres.vip.DailyVipRechargeUserLogQuery;

import java.util.List;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-07-22 14:26
 */
public interface DailyVipRechargeUserLogDao {
    /**
     *
     * 分页查询 
     * @author 13540
     * @date 2023-12-16 14:54
     * @return java.util.List<org.spring.springboot.domain.yldres.active.DailyActiveUserLogPO>
     */
    List<DailyVipRechargeUserLogPO> fetchDailyVipRechargeUserLogByPage(DailyVipRechargeUserLogQuery query);
    /**
     *
     * 查询总数 
     * @author 13540
     * @date 2023-12-16 14:54
     * @return java.lang.Integer
     */
    Integer fetchDailyVipRechargeUserLogByPageCount(DailyVipRechargeUserLogQuery query);
    /**
     *
     * 保存
     * @author 13540
     * @date 2023-12-16 14:54
     * @return java.lang.Integer
     */
    Integer saveDailyVipRechargeUserLog(DailyVipRechargeUserLogPO dailyVipRechargeUserLogPO);

}
