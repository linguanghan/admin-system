package org.spring.springboot.dao.yldres;

import org.spring.springboot.domain.yldres.DailyActiveUserLogPO;
import org.spring.springboot.domain.yldres.DailyActiveUserLogQuery;

import java.util.List;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-07-22 14:26
 */
public interface DailyActiveUserLogDao {
    /**
     *
     * 分页查询 
     * @author 13540
     * @date 2023-07-22 14:54 
     * @return java.util.List<org.spring.springboot.domain.yldres.DailyActiveUserLogPO>
     */
    List<DailyActiveUserLogPO> fetchDailyActiveUserLogByPage(DailyActiveUserLogQuery query);
    /**
     *
     * 查询总数 
     * @author 13540
     * @date 2023-07-22 14:54 
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
    Integer saveDailyActiveUserLog(DailyActiveUserLogPO dailyActiveUserLogPO);
}
