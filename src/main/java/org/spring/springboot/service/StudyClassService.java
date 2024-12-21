package org.spring.springboot.service;

import com.github.pagehelper.PageInfo;
import org.spring.springboot.common.result.Result;
import org.spring.springboot.domain.pelbsData.studyclass.*;

import java.util.List;

public interface StudyClassService {
    List<StudyClassVO> CLASS_VO_LIST();

    Result<?> queryPage(StudyClassQuery query);

    Long createStudyClass(StudyClassBasePO studyClassDTO);

    Long updateStudyClass(StudyClassBaseVO studyClassDTO);

    Result<?> queryOne(Long id);
}
