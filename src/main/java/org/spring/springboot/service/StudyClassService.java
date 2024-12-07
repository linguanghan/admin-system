package org.spring.springboot.service;

import com.github.pagehelper.PageInfo;
import org.spring.springboot.common.result.Result;
import org.spring.springboot.domain.pelbsData.studyclass.StudyClassBasePO;
import org.spring.springboot.domain.pelbsData.studyclass.StudyClassDTO;
import org.spring.springboot.domain.pelbsData.studyclass.StudyClassQuery;
import org.spring.springboot.domain.pelbsData.studyclass.StudyClassVO;

import java.util.List;

public interface StudyClassService {
    List<StudyClassVO> CLASS_VO_LIST();

    Result<?> queryPage(StudyClassQuery query);

    Long createStudyClass(StudyClassBasePO studyClassDTO);
}
