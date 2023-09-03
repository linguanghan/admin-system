package org.spring.springboot.controller;
import cn.hutool.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.common.anno.JwtIgnore;
import org.spring.springboot.common.enums.SysCodeEnum;
import org.spring.springboot.common.result.Result;
import org.spring.springboot.domain.yldres.page.PageEventTrackLogQuery;
import org.spring.springboot.domain.yldres.page.PageEventTrackLogVO;
import org.spring.springboot.service.PageEventTrackLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-08-13 16:27
 */
@RestController
@RequestMapping("/pageEventTrackLog")
public class PageEventTrackLogCtrl {

    private static final Logger logger = LoggerFactory.getLogger(PageEventTrackLogCtrl.class);

    @Autowired
    private PageEventTrackLogService pageEventTrackLogService;
    /**
     *
     * 分页查询
     * @author 13540
     * @date 2023-08-13 16:28 
     * @return org.spring.springboot.common.result.Result<?>
     */
    @JwtIgnore
    @RequestMapping("/searchPageEventTrackLogByPage")
    public Result<?> searchPageEventTrackLogByPage(PageEventTrackLogQuery pageEventTrackLogQuery) {
        if(pageEventTrackLogQuery == null) {
            return Result.buildFailure(SysCodeEnum.ParamError);
        }

        try {
            List<PageEventTrackLogVO> pageEventTrackLogVOS = pageEventTrackLogService.searchPageEventTrackLogByPage(pageEventTrackLogQuery);
            if(CollectionUtils.isEmpty(pageEventTrackLogVOS)) {
                return Result.buildSuccess().add("data", Collections.EMPTY_LIST).add("total", 0);
            }

            Integer total = pageEventTrackLogService.searchPageEventTrackLogByPageCount(pageEventTrackLogQuery);
            return Result.buildSuccess().add("data", pageEventTrackLogVOS).add("total", total);
        }catch (Exception e) {
            logger.error("PageEventTrackLogCtrl#searchPageEventTrackLogByPage error pageEventTrackLogQuery:{}", JSONUtil.toJsonStr(pageEventTrackLogQuery), e);
        }
        return Result.buildFailure(SysCodeEnum.BusinessError);

    }

    
    /**
     *
     * 保存记录
     * @author 13540
     * @date 2023-08-13 16:35 
     * @return org.spring.springboot.common.result.Result<?>
     */
    @JwtIgnore
    @RequestMapping("savePageEventTrackLog")
    public Result<?> savePageEventTrackLog(@RequestParam("log") String log){
        if(StringUtils.isEmpty(log)) {
            return Result.buildFailure(SysCodeEnum.ParamError);
        }
        try {
            long id = pageEventTrackLogService.savePageEventTrackLog(log);
            return Result.buildSuccess().add("id", id);
        }catch (Exception e) {
            logger.error("PageEventTrackLogCtrl#searchPageEventTrackLogByPage error log:{}", log, e);
        }
        return Result.buildFailure(SysCodeEnum.BusinessError);

    }


}
