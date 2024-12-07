package org.spring.springboot.service.impl;

import cn.hutool.core.collection.ListUtil;
import com.github.pagehelper.PageInfo;
import org.spring.springboot.common.result.Result;
import org.spring.springboot.dao.pelbsData.StudyClassDao;
import org.spring.springboot.domain.pelbsData.studyclass.*;
import org.spring.springboot.service.StudyClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Service
class StudyClassServiceImpl implements StudyClassService {
    @Autowired
    private StudyClassDao studyClassDao;

    @Override
    public List<StudyClassVO> CLASS_VO_LIST() {
        List<StudyClassPO> studyClassPOList = studyClassDao.selectStudyClass();
        return StudyClassVO.convertFromPOList(studyClassPOList);
    }

    @Override
    public Result<?> queryPage(StudyClassQuery query) {
        long startTime = query.getStartTime().getTime();
        long endTime = query.getEndTime().getTime();
        List<StudyClassBasePO> studyClassVOS = studyClassDao.queryPage(startTime/1000, endTime/1000);
        List<StudyClassBasePO> page = ListUtil.page(query.getPageNo() - 1, query.getPageSize(), studyClassVOS);
        if (CollectionUtils.isEmpty(page)) {
            return Result.buildSuccess().add("data", Collections.EMPTY_LIST).add("total", 0);
        }
        return Result.buildSuccess().add("data", page).add("total", studyClassVOS.size());
    }

    @Override
    public Long createStudyClass(StudyClassBasePO studyClassDTO) {
        Long result = studyClassDao.createStudyClass(studyClassDTO);
        return result;
    }
}
