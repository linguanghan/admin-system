package org.spring.springboot.controller;

import cn.hutool.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.bean.AjaxResult;
import org.spring.springboot.common.enums.SysCodeEnum;
import org.spring.springboot.common.result.Result;
import org.spring.springboot.domain.pelbsData.studyclass.StudyClassBasePO;
import org.spring.springboot.domain.pelbsData.studyclass.StudyClassDTO;
import org.spring.springboot.domain.pelbsData.studyclass.StudyClassQuery;
import org.spring.springboot.domain.pelbsData.studyclass.StudyClassVO;
import org.spring.springboot.service.StudyClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("studyClass")
public class StudyClassCtrl {

    private static final Logger logger = LoggerFactory.getLogger(StudyClassCtrl.class);

    @Autowired
    private StudyClassService studyClassService;

    @RequestMapping(value = "/list")
    public AjaxResult FetchStudyClassList() {
        return AjaxResult.successResult(studyClassService.CLASS_VO_LIST());
    }

    @RequestMapping(value = "/page")
    public Result<?> fetchStudyClassPage(StudyClassQuery query) {
        if (query == null
                || query.getEndTime() == null
                || query.getStartTime() == null) {
            return Result.buildFailure(SysCodeEnum.ParamError);
        }
        try {
            return studyClassService.queryPage(query);
        } catch (Exception e) {
            logger.info("StudyClassCtrl#fetchStudyClassPage error vo is {}", JSONUtil.toJsonStr(query), e);
        }
        return Result.buildFailure(SysCodeEnum.SysError);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Result<?> createStudyClass(@RequestBody StudyClassBasePO studyClassDTO) {
        try {
            Long id = studyClassService.createStudyClass(studyClassDTO);
            if (id == null || id < 0) {
                return Result.buildFailure(SysCodeEnum.BusinessError);
            }
            return Result.buildSuccess().add("id", id);
        } catch (Exception e) {
            logger.error("StudyClassCtrl#createStudyClass error query:{}", JSONUtil.toJsonStr(studyClassDTO), e);
            return Result.buildFailure(SysCodeEnum.BusinessError);
        }

    }
}
