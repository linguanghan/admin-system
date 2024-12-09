package org.spring.springboot.service.impl;

import org.spring.springboot.dao.yldres.MonthlyActiveUserLogDao;
import org.spring.springboot.domain.yldres.active.*;
import org.spring.springboot.service.MonthlyActiveUserLogService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-07-22 14:56
 */
@Service
public class MonthlyActiveUserLogServiceImpl implements MonthlyActiveUserLogService {
    @Resource
    private MonthlyActiveUserLogDao monthlyActiveUserLogDao;

    @Override
    public List<MonthlyActiveUserLogPO> fetchMonthlyActiveUserLogByPage(MonthlyActiveUserLogQuery query){
        return monthlyActiveUserLogDao.fetchMonthlyActiveUserLogByPage(query);
    }

    @Override
    public Integer fetchMonthlyActiveUserLogByPageCount(MonthlyActiveUserLogQuery query) {
        return monthlyActiveUserLogDao.fetchMonthlyActiveUserLogByPageCount(query);
    }

    @Override
    public Long saveMonthlyActiveUserLog(MonthlyActiveUserLogVO monthlyActiveUserLogVO) {
        MonthlyActiveUserLogPO monthActiveUserLogPO = new MonthlyActiveUserLogPO();
        BeanUtils.copyProperties(monthlyActiveUserLogVO, monthActiveUserLogPO, "id");
        monthlyActiveUserLogDao.saveMonthlyActiveUserLog(monthActiveUserLogPO);
        return monthActiveUserLogPO.getId();
    }

    @Override
    public List<MonthlyActiveUserLogPO> queryMonthlyActiveUserLog(String startTime, String endTime) {
        if(startTime == null || endTime == null) {
            return Collections.emptyList();
        }
        return monthlyActiveUserLogDao.queryMonthlyActiveUserLog(startTime, endTime);
    }

    @Override
    public MonthlyActiveUserLogPO queryMonthlyActiveUserLogCount(String countTime) {
        return monthlyActiveUserLogDao.queryMonthlyActiveUserLogCount(countTime);
    }

    @Override
    public Long update(MonthlyActiveUserLogPO queryMonthlyUserLogPO) {
        return monthlyActiveUserLogDao.update(queryMonthlyUserLogPO);
    }

}
