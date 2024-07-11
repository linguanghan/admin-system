package org.spring.springboot.service.impl;

import org.spring.springboot.dao.pelbsData.PlayerExtDao;
import org.spring.springboot.dao.yldres.DailyVipRechargeUserLogDao;
import org.spring.springboot.domain.yldres.vip.DailyVipRechargeUserLogPO;
import org.spring.springboot.domain.yldres.vip.DailyVipRechargeUserLogQuery;
import org.spring.springboot.domain.yldres.vip.DailyVipRechargeUserLogVO;
import org.spring.springboot.service.DailyVipRechargeUserLogService;
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
public class DailyVipRechargeUserLogServiceImpl implements DailyVipRechargeUserLogService {
    @Resource
    private DailyVipRechargeUserLogDao dailyVipRechargeUserLogDao;

    @Resource
    private PlayerExtDao PlayerExtDao;

    @Override
    public List<DailyVipRechargeUserLogPO> fetchDailyVipRechargeUserLogByPage(DailyVipRechargeUserLogQuery query){
//        return dailyVipRechargeUserLogDao.fetchDailyVipRechargeUserLogByPage(query);
        return PlayerExtDao.fetchDailyVipRechargeUserLogByPage(query);
    }

    @Override
    public Integer fetchDailyVipRechargeUserLogByPageCount(DailyVipRechargeUserLogQuery query) {
        return PlayerExtDao.fetchDailyVipRechargeUserLogByPageCount(query);
    }

    @Override
    public Long saveDailyVipRechargeUserLog(DailyVipRechargeUserLogVO dailyVipRechargeUserLogVO) {
        DailyVipRechargeUserLogPO dailyVipRechargeUserLogPO = new DailyVipRechargeUserLogPO();
        BeanUtils.copyProperties(dailyVipRechargeUserLogVO, dailyVipRechargeUserLogPO, "id");
        dailyVipRechargeUserLogDao.saveDailyVipRechargeUserLog(dailyVipRechargeUserLogPO);
        return dailyVipRechargeUserLogPO.getId();
    }

}
