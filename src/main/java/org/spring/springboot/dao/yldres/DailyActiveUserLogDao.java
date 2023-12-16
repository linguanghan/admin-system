package org.spring.springboot.dao.yldres;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.yldres.active.DailyActiveUserLogPO;
import org.spring.springboot.domain.yldres.active.DailyActiveUserLogQuery;

import java.util.Date;
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
     * @return java.util.List<org.spring.springboot.domain.yldres.active.DailyActiveUserLogPO>
     */
    List<DailyActiveUserLogPO> fetchDailyActiveUserLogByPage(DailyActiveUserLogQuery query);
    /**
     *
     * 查询总数 
     * @author 13540
     * @date 2023-07-22 14:54 
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
    Integer saveDailyActiveUserLog(DailyActiveUserLogPO dailyActiveUserLogPO);


    /**
     * 根据开始时间和结束时间查询范围内的
     *
     * @param startTime
     * @param endTime
     * @author 13540
     * @date 2023-10-15 15:52
     * @return java.util.List<org.spring.springboot.domain.yldres.active.DailyActiveUserLogPO>
     */
    List<DailyActiveUserLogPO> queryDailyActiveUserLog(@Param("startTime") Date startTime,@Param("endTime") Date endTime);
}
