package org.spring.springboot.controller;

import cn.hutool.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.common.enums.SysCodeEnum;
import org.spring.springboot.common.result.Result;
import org.spring.springboot.domain.yldres.active.DailyActiveUserLogPO;
import org.spring.springboot.domain.yldres.active.DailyActiveUserLogQuery;
import org.spring.springboot.domain.yldres.active.DailyActiveUserLogVO;
import org.spring.springboot.service.DailyActiveUserLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-07-22 15:02
 */
@RestController
@RequestMapping("/active/log")
public class DailyActiveUserLogCtrl {

    @Autowired
    private DailyActiveUserLogService dailyActiveUserLogService;

    private static final Logger logger = LoggerFactory.getLogger(DailyActiveUserLogCtrl.class);

    /**
     *
     * 分页查询日活记录
     * @author 13540
     * @date 2023-07-22 15:05 
     * @return java.util.List<org.spring.springboot.domain.yldres.active.DailyActiveUserLogPO>
     */
    @RequestMapping(value = "/fetchDailyActiveUserLogByPage", method = RequestMethod.POST)
    public Result<?> fetchDailyActiveUserLogByPage(DailyActiveUserLogQuery query){
        try {
            List<DailyActiveUserLogPO> dailyActiveUserLogPOS = dailyActiveUserLogService.fetchDailyActiveUserLogByPage(query);
            if(CollectionUtils.isEmpty(dailyActiveUserLogPOS)) {
                return Result.buildSuccess().add("data", Collections.EMPTY_LIST).add("total", 0);
            }
            Integer count = dailyActiveUserLogService.fetchDailyActiveUserLogByPageCount(query);
            return Result.buildSuccess().add("data", dailyActiveUserLogPOS).add("total", count);
        }catch (Exception e) {
            logger.error("DailyActiveUserLogCtrl#fetchDailyActiveUserLogByPage error query:{}", JSONUtil.toJsonStr(query), e);
            return Result.buildFailure(SysCodeEnum.BusinessError);
        }

    }

    /**
     *
     * 保存日活记录
     * @author 13540
     * @date 2023-07-22 15:04 
     * @return java.lang.Integer
     */
    @RequestMapping(value = "/saveDailyActiveUserLog", method = RequestMethod.POST)
    public Result<?> saveDailyActiveUserLog(@RequestBody DailyActiveUserLogVO dailyActiveUserLogVO) {
        try {
            Long id = dailyActiveUserLogService.saveDailyActiveUserLog(dailyActiveUserLogVO);
            if (id == null || id < 0) {
                return Result.buildFailure(SysCodeEnum.BusinessError);
            }
            return Result.buildSuccess().add("id", id);
        } catch (Exception e) {
            logger.error("DailyActiveUserLogCtrl#fetchDailyActiveUserLogByPage error query:{}", JSONUtil.toJsonStr(dailyActiveUserLogVO), e);
            return Result.buildFailure(SysCodeEnum.BusinessError);
        }

    }

    @RequestMapping("/queryDailyActiveUserLog")
    public Result<?> queryDailyActiveUserLog(@RequestParam("startTime") Date startTime,@RequestParam("endTime") Date endTime) {
        try {
            List<DailyActiveUserLogPO> dailyActiveUserLogPOS = dailyActiveUserLogService.queryDailyActiveUserLog(startTime, endTime);

        }catch (Exception e) {
            logger.error("DailyActiveUserLogCtrl#queryDailyActiveUserLog error startTime{}, endTime{}", JSONUtil.toJsonStr(startTime), JSONUtil.toJsonStr(endTime));
        }

        return Result.buildFailure();

    }
}
