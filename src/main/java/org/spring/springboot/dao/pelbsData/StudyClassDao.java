package org.spring.springboot.dao.pelbsData;

import org.spring.springboot.domain.pelbsData.studyclass.StudyClassPO;

import java.util.List;

public interface StudyClassDao {
    List<StudyClassPO> selectStudyClass();
}
