package org.spring.springboot.service.schedule;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.dao.pelbsData.PlayerDao;
import org.spring.springboot.domain.yldres.active.DailyActiveUserLogVO;
import org.spring.springboot.domain.yldres.active.MonthlyActiveUserLogPO;
import org.spring.springboot.domain.yldres.active.MonthlyActiveUserLogVO;
import org.spring.springboot.service.DailyActiveUserLogService;
import org.spring.springboot.service.MonthlyActiveUserLogService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 * 计算每日活跃人数定时任务
 * @author 13540
 * @version 1.0
 * @date 2023-07-22 13:42
 */
@Service
public class CalcDailyActiveSchedule {

    private static final Logger logger = LoggerFactory.getLogger(CalcDailyActiveSchedule.class);
    @Resource
    private PlayerDao playerDao;

    @Resource
    private DailyActiveUserLogService dailyActiveUserLogService;

    @Resource
    private MonthlyActiveUserLogService monthlyActiveUserLogService;

    @Scheduled(cron = "0 15 0 * * ?")
    private void calcDailyActiveUser() {

        //1、获取昨天的开始时间和结束时间的时间戳
        Map<String, Long> yesterdayTimeStamp = getYesterdayTimeStamp();
        Map<String, Long> monthBeginAndEndTimeStamp = getMonthBeginAndEndTimeStamp();
        logger.info("calcDailyActiveUser 开始计算活跃度了！");

        //2、获取到昨天的活跃数
        Integer activeNum = playerDao.findActiveNumBetweenDate(yesterdayTimeStamp.get("beginOfYesterdayTime"), yesterdayTimeStamp.get("endOfYesterdayTime"));

        // 获取本月的活跃数
        Integer activeNumMonthly = playerDao.findActiveNumBetweenDate(monthBeginAndEndTimeStamp.get("beginOfMonthTime"), monthBeginAndEndTimeStamp.get("endOfMonthTime"));

        //3、数据封装
        DailyActiveUserLogVO dailyActiveUserLogVO = new DailyActiveUserLogVO();
        String countTime = DateUtil.format(DateUtil.offsetDay(new Date(), -1), "yyyy-MM-dd");

        dailyActiveUserLogVO.setActiveCount(activeNum.longValue());
        dailyActiveUserLogVO.setCountTime(countTime);

        //4、插入到数据库中
        Long insert = dailyActiveUserLogService.saveDailyActiveUserLog(dailyActiveUserLogVO);
        if(insert == null || insert < 0) {
            logger.error("calcDailyActiveUser error insert :{}", insert);
        }

        // 如果月份存在，更新月数据
        MonthlyActiveUserLogPO queryMonthlyUserLogPO = monthlyActiveUserLogService.queryMonthlyActiveUserLogCount(countTime);
        if(queryMonthlyUserLogPO == null) {
            // 如果不存在，插入
            MonthlyActiveUserLogVO monthlyActiveUserLogVO = new MonthlyActiveUserLogVO();
            String monthlyTime = DateUtil.format(DateUtil.beginOfMonth(new Date()), "yyyy-MM");

            monthlyActiveUserLogVO.setActiveCount(activeNumMonthly.longValue());
            monthlyActiveUserLogVO.setCountTime(monthlyTime);
            Long insertMonthlyUserLogPO = monthlyActiveUserLogService.saveMonthlyActiveUserLog(monthlyActiveUserLogVO);
            if(insertMonthlyUserLogPO == null || insertMonthlyUserLogPO < 0) {
                logger.error("calcMonthlyActiveUser error insert :{}", insert);
            }
        } else {
            // 如果存在，更新
            Long update = monthlyActiveUserLogService.update(queryMonthlyUserLogPO);
            if (update == null || update < 0) {
                logger.error("calcMonthlyActiveUser error update :{}", update);
            }
        }

    }

    /**
     *
     * 获取昨天的开始时间和结束时间的时间戳
     * @author 13540
     * @date 2023-07-22 14:03 
     * @return java.util.Map<java.lang.String, java.lang.Long>
     */
    private Map<String, Long> getYesterdayTimeStamp() {
        Date now = new Date();
        DateTime yesterday = DateUtil.offsetDay(now, -1);
        DateTime beginOfYesterday = DateUtil.beginOfDay(yesterday);
        DateTime endOfYesterday = DateUtil.endOfDay(yesterday);
        long beginOfYesterdayTime = beginOfYesterday.getTime() / 1000;
        long endOfYesterdayTime = endOfYesterday.getTime() / 1000;
        Map<String, Long> yesterdayMap = new HashMap<>();
        yesterdayMap.put("beginOfYesterdayTime", beginOfYesterdayTime);
        yesterdayMap.put("endOfYesterdayTime", endOfYesterdayTime);
        return yesterdayMap;
    }

    /**
     * 获取本月的开始时间和结束时间的时间戳
     * @return java.util.Map<java.lang.String, java.lang.Long>
     */
    public Map<String, Long> getMonthBeginAndEndTimeStamp() {
        Date now = new Date();
        DateTime beginOfMonth = DateUtil.beginOfMonth(now);
        DateTime endOfMonth = DateUtil.endOfMonth(now);
        long beginOfMonthTime = beginOfMonth.getTime() / 1000;
        long endOfMonthTime = endOfMonth.getTime() / 1000;
        Map<String, Long> monthMap = new HashMap<>();
        monthMap.put("beginOfMonthTime", beginOfMonthTime);
        monthMap.put("endOfMonthTime", endOfMonthTime);
        return monthMap;
    }

    public static void main(String[] args) {
        CalcDailyActiveSchedule calcDailyActiveSchedule = new CalcDailyActiveSchedule();
        calcDailyActiveSchedule.getYesterdayTimeStamp();
    }
}
