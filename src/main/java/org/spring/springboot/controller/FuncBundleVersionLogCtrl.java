package org.spring.springboot.controller;

import cn.hutool.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.common.enums.SysCodeEnum;
import org.spring.springboot.common.result.Result;
import org.spring.springboot.domain.yldres.func.FuncBundleVersionLogQuery;
import org.spring.springboot.domain.yldres.func.FuncBundleVersionLogVO;
import org.spring.springboot.service.FuncBundleVersionLogService;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * TODO
 *
 * @author 13540
 * @version 1.0
 * @date 2023-07-29 13:24
 */
@RestController
@RequestMapping("funcBundleVersionLog")
public class FuncBundleVersionLogCtrl {

    private static final Logger logger = LoggerFactory.getLogger(FuncBundleVersionLogCtrl.class);

    @Resource
    private FuncBundleVersionLogService funcBundleVersionLogService;

    @RequestMapping(value = "/searchFuncBundleVersionLogByKeyWord")
    public Result<?>  searchFuncBundleVersionLogByKeyWord(@RequestBody FuncBundleVersionLogQuery funcBundleVersionLogQuery){
        if(funcBundleVersionLogQuery == null) {
            return Result.buildFailure(SysCodeEnum.ParamError);
        }
        funcBundleVersionLogQuery.setKeyWord(StringUtils.trimWhitespace(funcBundleVersionLogQuery.getKeyWord()));
        List<FuncBundleVersionLogVO> funcBundleVersionLogVOS = funcBundleVersionLogService.searchFuncBundleVersionLogByKeyWord(funcBundleVersionLogQuery);
        if(CollectionUtils.isEmpty(funcBundleVersionLogVOS)) {
            return Result.buildSuccess().add("data", Collections.EMPTY_LIST).add("total", 0);
        }
        Integer total = funcBundleVersionLogService.searchFuncBundleVersionLogByKeyWordCount(funcBundleVersionLogQuery);
        return Result.buildSuccess().add("data", funcBundleVersionLogVOS).add("total", total);

    }

    @RequestMapping(value = "/updateFuncBundleVersionLog")
    public Result<?>  updateFuncBundleVersionLog(@RequestBody FuncBundleVersionLogVO funcBundleVersionLogVO){
        if(funcBundleVersionLogVO == null) {
            return Result.buildFailure(SysCodeEnum.ParamError);
        }
        try {
            boolean updateFuncBundleVersionLog = funcBundleVersionLogService.updateFuncBundleVersionLog(funcBundleVersionLogVO);
            if(updateFuncBundleVersionLog) {
                return Result.buildSuccess();
            }
        }catch (Exception e) {
            logger.error("FuncBundleVersionLogCtrl#updateFuncBundleVersionLog error funcBundleVersionLogVO is{}, e "
                    , JSONUtil.toJsonStr(funcBundleVersionLogVO), e);
        }

        return Result.buildFailure(SysCodeEnum.BusinessError);

    }

    @RequestMapping(value = "/deleteFuncBundleVersionLogById")
    public Result<?>  deleteFuncBundleVersionLogById(@RequestParam("id") Long id){
        if(id == null || id <= 0) {
            return Result.buildFailure(SysCodeEnum.ParamError);
        }
        try {
            boolean delete = funcBundleVersionLogService.deleteFuncBundleVersionLog(id);
            if(delete) {
                return  Result.buildSuccess();
            }
        }catch (Exception e) {
            logger.error("FuncBundleVersionLogCtrl#deleteFuncBundleVersionLog error id is{}, e "
                    , JSONUtil.toJsonStr(id), e);
        }

        return Result.buildFailure(SysCodeEnum.BusinessError);
    }

    @RequestMapping(value = "/saveFuncBundleVersionLog")
    public Result<?> saveFuncBundleVersionLog(@RequestBody FuncBundleVersionLogVO funcBundleVersionLogVO) {
        if (funcBundleVersionLogVO == null) {
            return Result.buildFailure(SysCodeEnum.ParamError);
        }
        try {
            boolean save = funcBundleVersionLogService.saveFuncBundleVersionLog(funcBundleVersionLogVO);
            if (save) {
                return Result.buildSuccess();
            }
        }catch (Exception e) {
            logger.error("FuncBundleVersionLogCtrl#saveFuncBundleVersionLog error funcBundleVersionLogVO is{}, e "
                    , JSONUtil.toJsonStr(funcBundleVersionLogVO), e);
        }

        return Result.buildFailure(SysCodeEnum.BusinessError);
    }

}
