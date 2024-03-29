package org.spring.springboot.service.impl;

import org.spring.springboot.dao.pelbsData.StudyClassDao;
import org.spring.springboot.domain.pelbsData.studyclass.StudyClassPO;
import org.spring.springboot.domain.pelbsData.studyclass.StudyClassVO;
import org.spring.springboot.service.StudyClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
