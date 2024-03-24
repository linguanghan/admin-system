package org.spring.springboot.controller;

import cn.hutool.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.common.enums.SysCodeEnum;
import org.spring.springboot.common.result.Result;
import org.spring.springboot.domain.yldres.vip.DailyVipRechargeUserLogPO;
import org.spring.springboot.domain.yldres.vip.DailyVipRechargeUserLogQuery;
import org.spring.springboot.service.DailyVipRechargeUserLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-07-22 15:02
 */
@RestController
@RequestMapping("/vipRecharge/log")
public class DailyVipRechargeUserLogCtrl {

    @Autowired
    private DailyVipRechargeUserLogService dailyVipRechargeUserLogService;

    private static final Logger logger = LoggerFactory.getLogger(DailyVipRechargeUserLogCtrl.class);

    /**
     *
     * 分页查询日活记录
     * @author 13540
     * @date 2023-07-22 15:05 
     * @return java.util.List<org.spring.springboot.domain.yldres.active.DailyActiveUserLogPO>
     */
    @RequestMapping(value = "/fetchDailyVipRechargeUserLogByPage", method = RequestMethod.POST)
    public Result<?> fetchDailyVipRechargeUserLogByPage(DailyVipRechargeUserLogQuery query){
        try {
            List<DailyVipRechargeUserLogPO> dailyVipRechargeUserLogPOS = dailyVipRechargeUserLogService.fetchDailyVipRechargeUserLogByPage(query);
            if(CollectionUtils.isEmpty(dailyVipRechargeUserLogPOS)) {
                return Result.buildSuccess().add("data", Collections.EMPTY_LIST).add("total", 0);
            }
            Integer count = dailyVipRechargeUserLogService.fetchDailyVipRechargeUserLogByPageCount(query);
            return Result.buildSuccess().add("data", dailyVipRechargeUserLogPOS).add("total", count);
        }catch (Exception e) {
            logger.error("DailyActiveUserLogCtrl#fetchDailyActiveUserLogByPage error query:{}", JSONUtil.toJsonStr(query), e);
            return Result.buildFailure(SysCodeEnum.BusinessError);
        }
    }

}
