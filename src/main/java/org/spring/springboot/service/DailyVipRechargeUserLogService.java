package org.spring.springboot.service;


import org.spring.springboot.domain.yldres.vip.DailyVipRechargeUserLogPO;
import org.spring.springboot.domain.yldres.vip.DailyVipRechargeUserLogQuery;
import org.spring.springboot.domain.yldres.vip.DailyVipRechargeUserLogVO;

import java.util.List;

public interface DailyVipRechargeUserLogService {

    /**
     *
     * 分页查询
     * @author 13540
     * @date 2023-07-22 15:00
     */
    List<DailyVipRechargeUserLogPO> fetchDailyVipRechargeUserLogByPage(DailyVipRechargeUserLogQuery query);

    /**
     *
     * 计算总数
     * @author 13540
     * @date 2023-07-22 14:59
     * @return java.lang.Integer
     */
    Integer fetchDailyVipRechargeUserLogByPageCount(DailyVipRechargeUserLogQuery query);
    /**
     *
     * 保存
     * @author 13540
     * @date 2023-07-22 14:54 
     * @return java.lang.Integer
     */
    Long saveDailyVipRechargeUserLog(DailyVipRechargeUserLogVO dailyVipRechargeUserLogVO);

}
