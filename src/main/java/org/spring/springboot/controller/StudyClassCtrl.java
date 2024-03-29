package org.spring.springboot.controller;

import org.spring.springboot.bean.AjaxResult;
import org.spring.springboot.service.StudyClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("studyClass")
public class StudyClassCtrl {
    @Autowired
    private StudyClassService studyClassService;

    @RequestMapping(value = "/list")
    public AjaxResult FetchStudyClassList() {
        return AjaxResult.successResult(studyClassService.CLASS_VO_LIST());
    }
}
