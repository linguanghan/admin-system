package org.spring.springboot.dao.pelbsData;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.pelbsData.studyclass.*;

import java.util.List;

public interface StudyClassDao {
    List<StudyClassPO> selectStudyClass();

    List<StudyClassBasePO> queryPage(@Param("startTime") Long startTime, @Param("endTime") Long endTime);

    Long createStudyClass(StudyClassBasePO studyClassDTO);

    Long updateStudyClass(StudyClassBasePO studyClassDTO);

    StudyClassBasePO selectStudyClassByID(@Param("id") Long id);
}
