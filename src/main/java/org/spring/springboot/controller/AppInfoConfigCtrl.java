package org.spring.springboot.controller;

import cn.hutool.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.common.anno.JwtIgnore;
import org.spring.springboot.common.enums.SysCodeEnum;
import org.spring.springboot.common.result.Result;
import org.spring.springboot.domain.yldres.app.AppInfoConfig;
import org.spring.springboot.domain.yldres.app.AppInfoConfigQuery;
import org.spring.springboot.service.AppInfoConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/resource")
public class AppInfoConfigCtrl {

    private static final Logger logger = LoggerFactory.getLogger(AppInfoConfigCtrl.class);

    @Autowired
    private AppInfoConfigService appInfoConfigService;

    /**
     * 获取包配置分页
     * @return
     */
    @JwtIgnore
    @PostMapping("/list")
    public Result<?> getList(AppInfoConfigQuery query) {
        if (query == null) {
            return Result.buildFailure(SysCodeEnum.ParamError);
        }
        try {
            return appInfoConfigService.getList(query);
        } catch (Exception e) {
            logger.info("StudyClassCtrl#fetchStudyClassPage error vo is {}", JSONUtil.toJsonStr(query), e);
        }
        return Result.buildFailure(SysCodeEnum.SysError);
    }

    /**
     * 获取包配置
     * @return
     */
    @JwtIgnore
    @GetMapping("/getMPkgInfo")
    public List<AppInfoConfig> getMPkgInfo() {
        return appInfoConfigService.findAll();
    }

    /**
     * 编辑
     * @param appInfoConfig
     * @return
     */
    @JwtIgnore
    @PostMapping("/update/info")
    public Result<?> updateAppInfoConfig(@RequestBody AppInfoConfig appInfoConfig) {
        try {
            Integer id = appInfoConfigService.update(appInfoConfig);
            if (id == null || id < 0) {
                return Result.buildFailure(SysCodeEnum.BusinessError);
            }
            return Result.buildSuccess().add("id", id);
        } catch (Exception e) {
            logger.error("AppInfoConfigCtrl#updateAppInfoConfig error query:{}", JSONUtil.toJsonStr(appInfoConfig), e);
            return Result.buildFailure(SysCodeEnum.BusinessError);
        }
    }

    @JwtIgnore
    @GetMapping("/{id}")
    public AppInfoConfig getAppInfoConfigById(@PathVariable Integer id) {
        return appInfoConfigService.findById(id);
    }

    @JwtIgnore
    @PostMapping("/save/info")
    public Result<?> createAppInfoConfig(@RequestBody AppInfoConfig appInfoConfig) {
        try {
            Integer id = appInfoConfigService.save(appInfoConfig);
            if (id == null || id < 0) {
                return Result.buildFailure(SysCodeEnum.BusinessError);
            }
            return Result.buildSuccess().add("id", id);
        } catch (Exception e) {
            logger.error("StudyClassCtrl#createStudyClass error query:{}", JSONUtil.toJsonStr(appInfoConfig), e);
            return Result.buildFailure(SysCodeEnum.BusinessError);
        }
    }

    @JwtIgnore
    @PostMapping("/del/info")
    public Result<?> deleteAppInfoConfig(@RequestBody AppInfoConfig appInfoConfig) {
        if(appInfoConfig.getId() == null || appInfoConfig.getId() <= 0) {
            return Result.buildFailure(SysCodeEnum.ParamError);
        }
        try {
            Integer delete = appInfoConfigService.deleteById(appInfoConfig.getId().intValue());
            if(delete > 0) {
                return  Result.buildSuccess();
            }
        }catch (Exception e) {
            logger.error("AppInfoConfigCtrl#deleteAppInfoConfig error id is{}, e "
                    , JSONUtil.toJsonStr(appInfoConfig.getId()), e);
        }

        return Result.buildFailure(SysCodeEnum.BusinessError);
    }
}