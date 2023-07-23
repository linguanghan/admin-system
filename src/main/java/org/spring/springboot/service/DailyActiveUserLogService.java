package org.spring.springboot.service;


import org.spring.springboot.domain.yldres.DailyActiveUserLogPO;
import org.spring.springboot.domain.yldres.DailyActiveUserLogQuery;
import org.spring.springboot.domain.yldres.DailyActiveUserLogVO;

import java.util.List;

public interface DailyActiveUserLogService {

    /**
     *
     * 分页查询
     * @author 13540
     * @date 2023-07-22 15:00 
     * @return java.util.List<org.spring.springboot.domain.yldres.DailyActiveUserLogPO>
     */
    List<DailyActiveUserLogPO> fetchDailyActiveUserLogByPage(DailyActiveUserLogQuery query);

    /**
     *
     * 计算总数 
     * @author 13540
     * @date 2023-07-22 14:59 
     * @return java.lang.Integer
     */
    Integer fetchDailyActiveUserLogByPageCount();
    /**
     *
     * 保存
     * @author 13540
     * @date 2023-07-22 14:54 
     * @return java.lang.Integer
     */
    Long saveDailyActiveUserLog(DailyActiveUserLogVO dailyActiveUserLogVO);
}
