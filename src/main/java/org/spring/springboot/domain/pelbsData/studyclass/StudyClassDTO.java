package org.spring.springboot.domain.pelbsData.studyclass;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudyClassDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer classInviteID;
    private Integer classNumber;
    private String teacherName;
    private String schoolName;
    private Integer grade;
    private Long ownerPid;
    private String memData;
}
