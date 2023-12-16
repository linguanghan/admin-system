package org.spring.springboot.service;


import org.spring.springboot.dao.yldres.DailyActiveUserLogDao;
import org.spring.springboot.domain.yldres.active.DailyActiveUserLogPO;
import org.spring.springboot.domain.yldres.active.DailyActiveUserLogQuery;
import org.spring.springboot.domain.yldres.active.DailyActiveUserLogVO;

import java.util.Date;
import java.util.List;

public interface DailyActiveUserLogService {

    /**
     *
     * 分页查询
     * @author 13540
     * @date 2023-07-22 15:00 
     * @return java.util.List<org.spring.springboot.domain.yldres.active.DailyActiveUserLogPO>
     */
    List<DailyActiveUserLogPO> fetchDailyActiveUserLogByPage(DailyActiveUserLogQuery query);

    /**
     *
     * 计算总数 
     * @author 13540
     * @date 2023-07-22 14:59 
     * @return java.lang.Integer
     */
    Integer fetchDailyActiveUserLogByPageCount(DailyActiveUserLogQuery query);
    /**
     *
     * 保存
     * @author 13540
     * @date 2023-07-22 14:54 
     * @return java.lang.Integer
     */
    Long saveDailyActiveUserLog(DailyActiveUserLogVO dailyActiveUserLogVO);


    /**
     *
     * 查询时间范围内的活跃人数
     * @param startTime
     * @param endTime
     * @author 13540
     * @date 2023-10-15 16:40
     * @return java.util.List<org.spring.springboot.domain.yldres.active.DailyActiveUserLogPO>
     */
    List<DailyActiveUserLogPO> queryDailyActiveUserLog(Date startTime, Date endTime);
}
