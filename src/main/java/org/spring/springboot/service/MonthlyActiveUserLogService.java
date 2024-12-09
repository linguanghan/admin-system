package org.spring.springboot.service;


import org.spring.springboot.domain.yldres.active.*;

import java.util.Date;
import java.util.List;

public interface MonthlyActiveUserLogService {

    /**
     *
     * 分页查询
     * @author 13540
     * @date 2023-07-22 15:00 
     * @return java.util.List<org.spring.springboot.domain.yldres.active.MonthlyActiveUserLogPO>
     */
    List<MonthlyActiveUserLogPO> fetchMonthlyActiveUserLogByPage(MonthlyActiveUserLogQuery query);

    /**
     *
     * 计算总数 
     * @author 13540
     * @date 2023-07-22 14:59 
     * @return java.lang.Integer
     */
    Integer fetchMonthlyActiveUserLogByPageCount(MonthlyActiveUserLogQuery query);
    /**
     *
     * 保存
     * @author 13540
     * @date 2023-07-22 14:54 
     * @return java.lang.Integer
     */
    Long saveMonthlyActiveUserLog(MonthlyActiveUserLogVO monthlyActiveUserLogVO);


    /**
     *
     * 查询时间范围内的活跃人数
     * @param startTime
     * @param endTime
     * @author 13540
     * @date 2023-10-15 16:40
     * @return java.util.List<org.spring.springboot.domain.yldres.active.MonthlyActiveUserLogPO>
     */
    List<MonthlyActiveUserLogPO> queryMonthlyActiveUserLog(String startTime, String endTime);

    MonthlyActiveUserLogPO queryMonthlyActiveUserLogCount(String countTime);

    Long update(MonthlyActiveUserLogPO queryMonthlyUserLogPO);
}
