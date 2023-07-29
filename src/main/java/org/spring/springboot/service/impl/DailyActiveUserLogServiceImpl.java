package org.spring.springboot.service.impl;

import org.spring.springboot.dao.yldres.DailyActiveUserLogDao;
import org.spring.springboot.domain.yldres.active.DailyActiveUserLogPO;
import org.spring.springboot.domain.yldres.active.DailyActiveUserLogQuery;
import org.spring.springboot.domain.yldres.active.DailyActiveUserLogVO;
import org.spring.springboot.service.DailyActiveUserLogService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-07-22 14:56
 */
@Service
public class DailyActiveUserLogServiceImpl implements DailyActiveUserLogService {
    @Resource
    private DailyActiveUserLogDao dailyActiveUserLogDao;

    @Override
    public List<DailyActiveUserLogPO> fetchDailyActiveUserLogByPage(DailyActiveUserLogQuery query){
        return dailyActiveUserLogDao.fetchDailyActiveUserLogByPage(query);
    }

    @Override
    public Integer fetchDailyActiveUserLogByPageCount() {
        return dailyActiveUserLogDao.fetchDailyActiveUserLogByPageCount();
    }

    @Override
    public Long saveDailyActiveUserLog(DailyActiveUserLogVO dailyActiveUserLogVO) {
        DailyActiveUserLogPO dailyActiveUserLogPO = new DailyActiveUserLogPO();
        BeanUtils.copyProperties(dailyActiveUserLogVO, dailyActiveUserLogPO, "id");
        dailyActiveUserLogDao.saveDailyActiveUserLog(dailyActiveUserLogPO);
        return dailyActiveUserLogPO.getId();
    }


}
